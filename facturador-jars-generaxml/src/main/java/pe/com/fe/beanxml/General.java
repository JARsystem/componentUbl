package pe.com.fe.beanxml;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

public class General {

	GregorianCalendar fechaEmision;
	GregorianCalendar horaEmision;
	GregorianCalendar fechaVencimiento;
	String moneda;
	String montoLetras;
	String serieNumero;
	String tipoDocumento;
	String tipoOperacion;
	BigDecimal cantidadItems;
	List<PeriodoFacturacion> lstPeriodoFacturacion;
	String numeroOrdenCompra;
	
	public General() {
		super();
	}
	
	public GregorianCalendar getFechaEmision() {
		return fechaEmision;
	}
	
	public void setFechaEmision(GregorianCalendar fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	public GregorianCalendar getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	public void setFechaVencimiento(GregorianCalendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public GregorianCalendar getHoraEmision() {
		return horaEmision;
	}
	
	public void setHoraEmision(GregorianCalendar horaEmision) {
		this.horaEmision = horaEmision;
	}
	
	public String getMoneda() {
		return moneda;
	}
	
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
	public String getMontoLetras() {
		return montoLetras;
	}
	
	public void setMontoLetras(String montoLetras) {
		this.montoLetras = montoLetras;
	}
	
	public String getSerieNumero() {
		return serieNumero;
	}
	
	public void setSerieNumero(String serieNumero) {
		this.serieNumero = serieNumero;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public BigDecimal getCantidadItems() {
		return cantidadItems;
	}

	public void setCantidadItems(BigDecimal cantidadItems) {
		this.cantidadItems = cantidadItems;
	}

	public List<PeriodoFacturacion> getLstPeriodoFacturacion() {
		return lstPeriodoFacturacion;
	}

	public void setLstPeriodoFacturacion(List<PeriodoFacturacion> lstPeriodoFacturacion) {
		this.lstPeriodoFacturacion = lstPeriodoFacturacion;
	}

	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}
	
	
}
