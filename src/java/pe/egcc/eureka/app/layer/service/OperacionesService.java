package pe.egcc.eureka.app.layer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.egcc.eureka.app.domain.Movimiento;
import pe.egcc.eureka.app.layer.dao.espec.CuentaDao;

@Service
public class OperacionesService {

	@Autowired
	private CuentaDao cuentaDao;

	public void procesarDeposito(Movimiento mov) {
		// Tipo de mov
		mov.setTipo("003");
		// Moneda
		String moneda = cuentaDao.consultarMoneda(mov.getCuenta());
		if (moneda.equals("01")) {
			if (mov.getMoneda().equals("02")) {
				double importe = mov.getImporte() * 2.80;
				mov.setImporte(importe);
				mov.setMoneda(moneda);
			}
		} else if (moneda.equals("02")) {
			if (mov.getMoneda().equals("01")) {
				double importe = mov.getImporte() / 2.80;
				mov.setImporte(importe);
				mov.setMoneda(moneda);
			}
		}
		cuentaDao.procesarDeposito(mov);
	}
}
