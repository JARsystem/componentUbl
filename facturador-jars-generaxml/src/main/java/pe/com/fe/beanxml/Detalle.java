package pe.com.fe.beanxml;

import java.math.BigDecimal;
import java.util.List;

public class Detalle {

	private Integer id;
	private String unidadMedida;
	private BigDecimal cantidad;
	private String codigoProductoEmisor;
	private String codigoProductoSunat;
	private String codigoProductoGS1;
	private String codigoProductoGS1Gtin;
	private String placaVehiculo;
	private List<String> lstDescripcion;
	private BigDecimal valorUnitarioItem;
	private BigDecimal precioUnitarioItem;
	private BigDecimal valorReferencialItem;
	private BigDecimal totalImpuestos;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUnidadMedida() {
		return unidadMedida;
	}
	
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	public BigDecimal getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getCodigoProductoEmisor() {
		return codigoProductoEmisor;
	}
	
	public void setCodigoProductoEmisor(String codigoProductoEmisor) {
		this.codigoProductoEmisor = codigoProductoEmisor;
	}
	
	public String getCodigoProductoSunat() {
		return codigoProductoSunat;
	}
	
	public void setCodigoProductoSunat(String codigoProductoSunat) {
		this.codigoProductoSunat = codigoProductoSunat;
	}
	
	public String getCodigoProductoGS1() {
		return codigoProductoGS1;
	}
	
	public void setCodigoProductoGS1(String codigoProductoGS1) {
		this.codigoProductoGS1 = codigoProductoGS1;
	}
	
	public String getCodigoProductoGS1Gtin() {
		return codigoProductoGS1Gtin;
	}

	public void setCodigoProductoGS1Gtin(String codigoProductoGS1Gtin) {
		this.codigoProductoGS1Gtin = codigoProductoGS1Gtin;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}
	
	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}
	
	public List<String> getLstDescripcion() {
		return lstDescripcion;
	}

	public void setLstDescripcion(List<String> lstDescripcion) {
		this.lstDescripcion = lstDescripcion;
	}

	public BigDecimal getValorUnitarioItem() {
		return valorUnitarioItem;
	}

	public void setValorUnitarioItem(BigDecimal valorUnitarioItem) {
		this.valorUnitarioItem = valorUnitarioItem;
	}

	public BigDecimal getPrecioUnitarioItem() {
		return precioUnitarioItem;
	}

	public void setPrecioUnitarioItem(BigDecimal precioUnitarioItem) {
		this.precioUnitarioItem = precioUnitarioItem;
	}

	public BigDecimal getValorReferencialItem() {
		return valorReferencialItem;
	}

	public void setValorReferencialItem(BigDecimal valorReferencialItem) {
		this.valorReferencialItem = valorReferencialItem;
	}

	public BigDecimal getTotalImpuestos() {
		return totalImpuestos;
	}

	public void setTotalImpuestos(BigDecimal totalImpuestos) {
		this.totalImpuestos = totalImpuestos;
	}

	
		
}
