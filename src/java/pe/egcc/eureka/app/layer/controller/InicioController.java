package pe.egcc.eureka.app.layer.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.egcc.eureka.app.domain.Empleado;
import pe.egcc.eureka.app.layer.service.IngresoService;

@Component
@ManagedBean
@SessionScoped
public class InicioController {

	@Autowired
	private IngresoService service;
	private Empleado empleado;
	private String usuario;
	private String clave;

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}
	
	public String procesar(){
		String destino;
		try {
			empleado = service.validar(usuario, clave);
			destino = "mainPage";
		} catch (Exception e) {
			destino = "home";
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"Error en inicio de sesión.", 
							e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return destino;
	}
	
	public String salir(){
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "home";
	}
	
	
}
