package pe.com.fe.test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import pe.com.fe.beanxml.DireccionEntrega;
import pe.com.fe.beanxml.DocumentoRelacionado;
import pe.com.fe.beanxml.Emisor;
import pe.com.fe.beanxml.General;
import pe.com.fe.beanxml.Detalle;
import pe.com.fe.beanxml.PeriodoFacturacion;
import pe.com.fe.beanxml.Receptor;
import pe.com.fe.standar.ExtensionSignature;
import pe.com.fe.standar.GenerarInvoice;

public class Test {

	ExtensionSignature firma = new ExtensionSignature();
	
	
	public static void main(String[] args) {

		General general = new General();
		GenerarInvoice generarInvoice = new GenerarInvoice();
		
		List<DocumentoRelacionado> lstGuia = new ArrayList<DocumentoRelacionado>();
		List<DocumentoRelacionado> lstOtro = new ArrayList<DocumentoRelacionado>();
		List<PeriodoFacturacion> lstPeriodoFacturacion = new ArrayList<PeriodoFacturacion>();
		
		GregorianCalendar fechaEmision = new GregorianCalendar();
		fechaEmision.setTime(new Date());
		
		GregorianCalendar fechaVencimiento = new GregorianCalendar();
		fechaVencimiento.setTime(new Date());
		
		general.setFechaEmision(fechaEmision);
		general.setHoraEmision(fechaEmision);
		general.setFechaVencimiento(fechaVencimiento);
		general.setMoneda("PEN");
		general.setMontoLetras("CINCO");
		general.setSerieNumero("F001-265");
		general.setTipoDocumento("01");
		general.setTipoOperacion("0101");
		general.setCantidadItems(BigDecimal.valueOf(8));
		
		DocumentoRelacionado guia = new DocumentoRelacionado();
		guia.setSerieNumeroDocRelacionado("0001-123456");
		guia.setTipoDocuRelacionado("09");
		lstGuia.add(guia);
				
		DocumentoRelacionado otro = new DocumentoRelacionado();
		otro.setSerieNumeroDocRelacionado("0001-654321");
		otro.setTipoDocuRelacionado("35");
		lstOtro.add(otro);
		
		/*Periodo de facturacion*/
		PeriodoFacturacion periodoFacturacion = new PeriodoFacturacion();
		
		GregorianCalendar fechaInicio = new GregorianCalendar();
		fechaInicio.setTime(new Date());
		periodoFacturacion.setFechaInicio(fechaInicio);
		
		GregorianCalendar fechaFin = new GregorianCalendar();
		fechaFin.setTime(new Date());
		periodoFacturacion.setFechaFin(fechaFin);
		
		lstPeriodoFacturacion.add(periodoFacturacion);
		
		general.setLstPeriodoFacturacion(lstPeriodoFacturacion);
		
		/*-----------------------------------------*/
		
		general.setNumeroOrdenCompra("2018-123458996");
		
		/* Empresa Emisora */
		Emisor emisor = new Emisor();
		
		emisor.setNombreComercial("JARS 2");
		emisor.setRazonSocial("JARS S.A. 2");
		emisor.setTipoDocumentoIdentidad("6");
		emisor.setNumeroDocumentoIdentidad("10403702489-2");
		emisor.setCodigoEstablecimientoSunat("0001-2");
		emisor.setDireccion("direccion-2");
		emisor.setUrbanizacion("urbanizacion-2");
		emisor.setDistrito("distrito-2");
		emisor.setProvincia("provincia-2");
		emisor.setDepartamento("departamento-2");
		emisor.setUbigeo("010101-2");
		emisor.setCodigoPais("PE-2");
		
		/* Empresa Receptora */
		Receptor receptor = new Receptor();
		
		receptor.setNombreComercial("JARS");
		receptor.setRazonSocial("JARS S.A.");
		receptor.setTipoDocumentoIdentidad("6");
		receptor.setNumeroDocumentoIdentidad("10403702489");
		receptor.setDireccion("direccion");
		receptor.setUrbanizacion("urbanizacion");
		receptor.setDistrito("distrito");
		receptor.setProvincia("provincia");
		receptor.setDepartamento("departamento");
		receptor.setUbigeo("010101");
		receptor.setCodigoPais("PE");
		
		/* Delivery */
		DireccionEntrega direccionEntrega = new DireccionEntrega();
		
		direccionEntrega.setDireccion("direccionEntrega");
		direccionEntrega.setUrbanizacion("urbanizacionEntrega");
		direccionEntrega.setDistrito("distritoEntrega");
		direccionEntrega.setProvincia("provinciaEntrega");
		direccionEntrega.setDepartamento("departamentoEntrega");
		direccionEntrega.setUbigeo("010101Entrega");
		direccionEntrega.setCodigoPais("PEEntrega");
		
		/*Items*/
		List<Detalle> lstItem = new ArrayList<Detalle>();
		Detalle item = new Detalle();
		item.setId(1);
		item.setCantidad(BigDecimal.valueOf(25.35));
		item.setUnidadMedida("ZZ");
		item.setCodigoProductoEmisor("775256585896");
		item.setCodigoProductoSunat("12345678");
		item.setCodigoProductoGS1("123456789");
		item.setCodigoProductoGS1Gtin("GTIN-8");
			//Detalle
			List<String> lstDescripcion = new ArrayList<String>();
			lstDescripcion.add("1 Item Linea 1");
			lstDescripcion.add("1 Item Linea 2");
			item.setLstDescripcion(lstDescripcion);
		
			// Valor Unitario Item
			item.setValorUnitarioItem(BigDecimal.valueOf(26.10));
		
		
		
		lstItem.add(item);
		
		InvoiceType invoiceType = new InvoiceType();
		
		invoiceType = generarInvoice.setGeneral(
				general, 
				lstGuia, 
				lstOtro,
				emisor,
				receptor,
				direccionEntrega,
				lstItem);
		
		File archivo = new File("F:\\00_ProyectosJbossDev11\\00_almacen\\20123456789.xml");
		
		JAXBContext jaxbContext;
		
		try {
			
			jaxbContext = JAXBContext.newInstance(InvoiceType.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
			
			jaxbMarshaller.marshal(invoiceType, System.out);	
			jaxbMarshaller.marshal(invoiceType, archivo);
			
			Signature signature = new Signature();
			signature.getSignature(archivo, "F:\\00_ProyectosJbossDev11\\00_almacen\\20123456789_firmado.xml", 
					"F:\\00_ProyectosJbossDev11\\00_almacen\\almacen.jks", "123456", "20112811096", "123456");
			
			System.out.println("Termine XML Firmado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
