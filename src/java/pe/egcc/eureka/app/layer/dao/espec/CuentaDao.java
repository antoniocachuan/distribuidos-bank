package pe.egcc.eureka.app.layer.dao.espec;

import java.util.List;
import java.util.Map;
import pe.egcc.eureka.app.domain.Movimiento;

public interface CuentaDao {

	String consultarMoneda(String cuenta);

	void procesarDeposito(Movimiento mov);

	List<Map<String, Object>> consultarMovimientos(String cuenta);
}
