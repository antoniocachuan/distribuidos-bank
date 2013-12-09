package pe.egcc.eureka.app.domain;

import java.util.Date;

public class Movimiento {

	private String cuenta;
	private Integer nroMov;
	private Date fecha;
	private String empleado;
	private String tipo;
	private Double importe;
	private String referencia;
	// Dato auxiliar
	private String moneda;

	public Movimiento() {
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getNroMov() {
		return nroMov;
	}

	public void setNroMov(Integer nroMov) {
		this.nroMov = nroMov;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getMoneda() {
		return moneda;
	}
	
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
}
