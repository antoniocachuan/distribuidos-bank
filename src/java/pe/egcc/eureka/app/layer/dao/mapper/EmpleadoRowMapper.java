package pe.egcc.eureka.app.layer.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pe.egcc.eureka.app.domain.Empleado;


public class EmpleadoRowMapper implements RowMapper<Empleado> {

	@Override
	public Empleado mapRow(ResultSet rs, int i) throws SQLException {
		Empleado emp = new Empleado();
		emp.setCodigo(rs.getString("chr_emplcodigo"));
		emp.setPaterno(rs.getString("vch_emplpaterno"));
		emp.setMaterno(rs.getString("vch_emplmaterno"));
		emp.setNombre(rs.getString("vch_emplnombre"));
		emp.setCiudad(rs.getString("vch_emplciudad"));
		emp.setDireccion(rs.getString("vch_empldireccion"));
		emp.setUsuario(rs.getString("vch_emplusuario"));
		emp.setClave(rs.getString("vch_emplclave"));
		return emp;
	}

}
