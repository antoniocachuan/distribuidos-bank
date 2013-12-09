
package pe.egcc.eureka.app.layer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.egcc.eureka.app.layer.service.ConsultasService;

@Component
@ManagedBean
@SessionScoped
public class ConsultasController {

	@Autowired
	private ConsultasService consultasService;
	
	private String cuenta;
	private List<Map<String,Object>> lista;

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public List<Map<String, Object>> getLista() {
		if(lista == null){
			lista = new ArrayList<Map<String, Object>>();
		}
		return lista;
	}
	
	
	public void consultarMovimientos(){
		lista = consultasService.consultarMovimientos(cuenta);
		//cuenta = "Chevere";
	}
}
