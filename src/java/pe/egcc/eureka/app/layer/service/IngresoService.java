package pe.egcc.eureka.app.layer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.egcc.eureka.app.domain.Empleado;
import pe.egcc.eureka.app.layer.dao.espec.EmpleadoCrudDao;

@Service
public class IngresoService {

	@Autowired
	private EmpleadoCrudDao empleadoCrudDao;
	
	public Empleado validar(String usuario, String clave) {
		Empleado emp = empleadoCrudDao.leerPorUsuario(usuario);
		if(emp == null){
			throw new RuntimeException("Usuario no es correcto.");
		} else if(!emp.getClave().equals(clave)){
			throw new RuntimeException("Clave no es correcta.");
		}
		return emp;		
		
	}

}
