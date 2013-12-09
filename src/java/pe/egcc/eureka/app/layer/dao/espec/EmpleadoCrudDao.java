package pe.egcc.eureka.app.layer.dao.espec;

import pe.egcc.eureka.app.domain.Empleado;

public interface EmpleadoCrudDao extends CrudDao<Empleado>{

	Empleado leerPorUsuario(String usuario);
}
