package pe.egcc.eureka.app.layer.dao.espec;

import java.util.List;

public interface CrudDao<T> {

	T leerPorCodigo(String codigo);

	List<T> leerPorNombre(String nombre);

	void crear(T obj);

	void modificar(T obj);

	void eliminar(String codigo);
}
