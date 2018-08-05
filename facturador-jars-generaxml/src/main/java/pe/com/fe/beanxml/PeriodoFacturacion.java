package pe.com.fe.beanxml;

import java.util.GregorianCalendar;

public class PeriodoFacturacion {
	
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	
	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}
}