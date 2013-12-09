/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.eureka.app.layer.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.egcc.eureka.app.domain.Movimiento;
import pe.egcc.eureka.app.layer.service.OperacionesService;

@Component
@ManagedBean
@RequestScoped
public class ProcesosController {

    @Autowired
    private OperacionesService services;
    private Movimiento movimiento;
    private String cuenta;
    private Double importe;

    public void depositar() {
        String destino;
        FacesMessage msg;
        movimiento=new Movimiento();
        movimiento.setImporte(importe);
        movimiento.setCuenta(cuenta);
        movimiento.setEmpleado("0004");
        movimiento.setMoneda("01");
        services.procesarDeposito(movimiento);
        try {
            
        } catch (Exception e) {
            destino = "index";
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al realizar depósito",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        msg = new FacesMessage("Depósito realizado con exito");
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

}
