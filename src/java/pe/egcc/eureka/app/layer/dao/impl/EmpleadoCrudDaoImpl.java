package pe.egcc.eureka.app.layer.dao.impl;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import pe.egcc.eureka.app.domain.Empleado;
import pe.egcc.eureka.app.layer.dao.espec.EmpleadoCrudDao;
import pe.egcc.eureka.app.layer.dao.mapper.EmpleadoRowMapper;

@Repository
public class EmpleadoCrudDaoImpl extends AbstractDao implements EmpleadoCrudDao {

	@Override
	public Empleado leerPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> leerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Empleado obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modificar(Empleado obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
	}

	@Override
	public Empleado leerPorUsuario(String usuario) {
		Empleado emp = null;
		try {
			String sql = "select chr_emplcodigo, vch_emplpaterno, vch_emplmaterno, "
					+ "vch_emplnombre, vch_emplciudad, vch_empldireccion, "
					+ "vch_emplusuario, vch_emplclave "
					+ "from eurekabank.empleado where vch_emplusuario = ?";
			Object[] parm = { usuario };
			emp = jdbcTemplate.queryForObject(sql, parm,
					new EmpleadoRowMapper());
		} catch (EmptyResultDataAccessException e) {
			emp = null;
		}
		return emp;
	}

}
