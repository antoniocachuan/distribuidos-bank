package pe.egcc.eureka.app.layer.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.egcc.eureka.app.domain.Movimiento;
import pe.egcc.eureka.app.layer.dao.espec.CuentaDao;

@Repository
public class CuentaDaoImpl extends AbstractDao implements CuentaDao {

	@Override
	public String consultarMoneda(String cuenta) {
		String sql = "select chr_monecodigo moneda from eurekabank.cuenta where chr_cuencodigo=?";
		String moneda;
		try {
			Object parms[] = { cuenta };
			moneda = jdbcTemplate.queryForObject(sql, parms, String.class);
		} catch (Exception e) {
			moneda = "";
		}
		return moneda;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void procesarDeposito(Movimiento mov) {
		// Leer el contador
		String sql = "SELECT dec_cuensaldo, int_cuencontmov " + "FROM eurekabank.cuenta "
				+ "WHERE chr_cuencodigo = ?";
		Map<String, Object> rec = jdbcTemplate.queryForMap(sql,
				new Object[] { mov.getCuenta() });
		Double saldo = Double.parseDouble(rec.get("dec_cuensaldo").toString());
		Integer cont = Integer.parseInt(rec.get("int_cuencontmov").toString());
		// Registrar movimiento
		cont++;
		sql = "insert into eurekabank.movimiento(chr_cuencodigo,int_movinumero,"
				+ "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
				+ "dec_moviimporte,chr_cuenreferencia) "
				+ "values(?,?,sysdate(),?,?,?,null)";
		Object[] parms = { mov.getCuenta(), cont, mov.getEmpleado(),
				mov.getTipo(), mov.getImporte() };
		jdbcTemplate.update(sql, parms);
		// Actualizar la cuenta
		saldo += mov.getImporte();
		sql = "UPDATE eurekabank.cuenta SET dec_cuensaldo = ?, int_cuencontmov = ? "
				+ "WHERE chr_cuencodigo = ?";
		parms = new Object[] { saldo, cont, mov.getCuenta() };
		int filas = jdbcTemplate.update(sql, parms);
		if (filas == 0) {
			throw new RuntimeException("No existe la cuenta.");
		}
	}

	@Override
	public List<Map<String, Object>> consultarMovimientos(String cuenta) {
		String sql = "SELECT cuenta, codcliente, cliente, "
						+ "fecha, importe, "
						+ "descripcion FROM eurekabank.vi_movimientos "
						+ "WHERE cuenta = ?";
		Object[] parm = {cuenta};
		List<Map<String,Object>> lista  =  jdbcTemplate.queryForList(sql, parm);
		return lista;
	}

}
