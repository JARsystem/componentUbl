package pe.com.fe.beanxml;

public class ItemIGV {

	private Double montoBase;
	private Double montoIgv;
	private Double porcentajeIgv;
	private String codigoAfectacion;
	private String tipoTributo;
	
	public Double getMontoBase() {
		return montoBase;
	}
	
	public void setMontoBase(Double montoBase) {
		this.montoBase = montoBase;
	}
	
	public Double getMontoIgv() {
		return montoIgv;
	}
	
	public void setMontoIgv(Double montoIgv) {
		this.montoIgv = montoIgv;
	}
	
	public Double getPorcentajeIgv() {
		return porcentajeIgv;
	}
	
	public void setPorcentajeIgv(Double porcentajeIgv) {
		this.porcentajeIgv = porcentajeIgv;
	}
	
	public String getCodigoAfectacion() {
		return codigoAfectacion;
	}
	
	public void setCodigoAfectacion(String codigoAfectacion) {
		this.codigoAfectacion = codigoAfectacion;
	}
	
	public String getTipoTributo() {
		return tipoTributo;
	}
	
	public void setTipoTributo(String tipoTributo) {
		this.tipoTributo = tipoTributo;
	}
}
