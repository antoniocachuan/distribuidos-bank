package pe.egcc.eureka.app.layer.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.egcc.eureka.app.layer.dao.espec.CuentaDao;

/**
 *
 * @author Gustavo Coronel
 */
@Service
public class ConsultasService {

	@Autowired
	private CuentaDao cuentaDao;
	
	public List<Map<String, Object>> consultarMovimientos(String cuenta){
		return cuentaDao.consultarMovimientos(cuenta);
	}
}
