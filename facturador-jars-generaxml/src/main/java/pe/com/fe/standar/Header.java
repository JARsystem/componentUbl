package pe.com.fe.standar;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineCountNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import pe.com.fe.beanxml.General;
import pe.com.fe.beanxml.PeriodoFacturacion;

public class Header {
	
	public InvoiceType setInvoice(General general) {
		
		InvoiceType invoiceType = new InvoiceType();
		
		IssueDateType fechaEmision = setFechaEmision(general);
		if (fechaEmision != null)
			invoiceType.setIssueDate(fechaEmision);
		
		IssueTimeType horaEmision = setHoraEmision(general);
		if (horaEmision != null)
			invoiceType.setIssueTime(horaEmision);
		
		DueDateType fechaVencimiento = setFechaVencimiento(general);
		if (fechaEmision != null)
			invoiceType.setDueDate(fechaVencimiento);
		
		DocumentCurrencyCodeType moneda = setMoneda(general);
		if (moneda != null)
			invoiceType.setDocumentCurrencyCode(moneda);
		
		NoteType montoEnLetras = setMontoEnLetras(general);
		if (montoEnLetras != null)
			invoiceType.getNote().add(montoEnLetras);
		
		IDType serieNumero = setSerieNumero(general);
		if (serieNumero != null)
			invoiceType.setID(serieNumero);
		
		InvoiceTypeCodeType tipoDocumento = setTipoDocumento(general);
		if (tipoDocumento != null)
			invoiceType.setInvoiceTypeCode(tipoDocumento);
		
		ProfileIDType tipoOperacion = setTipoOperacion(general);
		if (tipoOperacion != null)
			invoiceType.setProfileID(tipoOperacion);
		
		LineCountNumericType cantidadItems = setCantidadItems(general);
		if (cantidadItems != null)
			invoiceType.setLineCountNumeric(cantidadItems);

		List<PeriodType> lstPeriodo = setLstPeriodoFacturacion(general);
		if (lstPeriodo != null)
			invoiceType.getInvoicePeriod().addAll(lstPeriodo);
		
		OrderReferenceType numeroOrdenCompra = setNumeroOrdenCompra(general);
		if (numeroOrdenCompra != null)
			invoiceType.setOrderReference(numeroOrdenCompra);
		
		return invoiceType;
	}
	
	public CreditNoteType setCreditNote(General general) {
		return null;
	}
	
	public DebitNoteType setDebitNote(General general) {
		return null;
	}
	
	public IssueDateType setFechaEmision(General general) {
		IssueDateType issueDate = new IssueDateType();
		if (general.getFechaEmision() != null) {
			try {
				XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
						general.getFechaEmision().get(Calendar.YEAR), 
						general.getFechaEmision().get(Calendar.MONTH)+1, 
						general.getFechaEmision().get(Calendar.DAY_OF_MONTH), 
						DatatypeConstants.FIELD_UNDEFINED);
				
			    issueDate.setValue(fecha);
			    return issueDate;
			    
			} catch (DatatypeConfigurationException e) {
				System.out.println("Excepcion: Error al parsear fecha de emisión: " + e);
				return null;
			}
		}
		return null;
	}

	public IssueTimeType setHoraEmision(General general) {
		
		IssueTimeType issueTimeType = new IssueTimeType();
		
		if (general.getFechaEmision()!= null) { 
			try {
				XMLGregorianCalendar hora = DatatypeFactory.newInstance().newXMLGregorianCalendarTime(
						general.getHoraEmision().get(Calendar.HOUR), 
						general.getHoraEmision().get(Calendar.MINUTE), 
						general.getHoraEmision().get(Calendar.SECOND), 
						DatatypeConstants.FIELD_UNDEFINED);
				
				issueTimeType.setValue(hora);
			    return issueTimeType;
			    
			} catch (DatatypeConfigurationException e) {
				System.out.println("Excepcion: Error al parsear fecha de emisión: " + e);
				return null;
			}
		}
		return null;
	}
	
	public DueDateType setFechaVencimiento(General general) {
		DueDateType dueDateType = new DueDateType();
		
		if (general.getFechaVencimiento() != null) {
			try {
				XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
						general.getFechaVencimiento().get(Calendar.YEAR), 
						general.getFechaVencimiento().get(Calendar.MONTH)+1, 
						general.getFechaVencimiento().get(Calendar.DAY_OF_MONTH), 
						DatatypeConstants.FIELD_UNDEFINED);
				
				dueDateType.setValue(fecha);
			    return dueDateType;
			    
			} catch (DatatypeConfigurationException e) {
				System.out.println("Excepcion: Error al parsear fecha de emisión: " + e);
				return null;
			}
		}
		return null;
	}
	
	public DocumentCurrencyCodeType setMoneda(General general) {
		
		if (general.getMoneda() != null && general.getMoneda() != "") {
			DocumentCurrencyCodeType documentCurrencyCodeType = new DocumentCurrencyCodeType();
			documentCurrencyCodeType.setListID("ISO 4217 Alpha");
			documentCurrencyCodeType.setListName("Currency");
			documentCurrencyCodeType.setListAgencyName("United Nations Economic Commission for Europe");
			documentCurrencyCodeType.setValue(general.getMoneda());
			return documentCurrencyCodeType;
		}
		return null;
	}
	
	public NoteType setMontoEnLetras(General general) {
		if (general.getMontoLetras() != null && general.getMontoLetras() != "") {
			NoteType noteType = new NoteType();
			noteType.setLanguageLocaleID("1000");
			noteType.setValue(general.getMontoLetras());
			return noteType;
		}
		return null;
	}
	
	public IDType setSerieNumero(General general) {
		if (general.getSerieNumero() != null && general.getSerieNumero() != "") {
			IDType idType = new IDType();
			idType.setValue(general.getSerieNumero());
			return idType;
		}
		return null;
	}

	public InvoiceTypeCodeType setTipoDocumento(General general) {
		
		if (general.getTipoDocumento() != null && general.getTipoDocumento() != "") {
			InvoiceTypeCodeType invoiceTypeCodeType = new InvoiceTypeCodeType();
			invoiceTypeCodeType.setListAgencyName("PE:SUNAT");
			invoiceTypeCodeType.setListName("SUNAT:Identificador de Tipo de Documento");
			invoiceTypeCodeType.setListURI("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo01");
			invoiceTypeCodeType.setValue(general.getTipoDocumento());
			return invoiceTypeCodeType;
		}
		return null;
	}
	
	public ProfileIDType setTipoOperacion(General general) {
		if (general.getTipoOperacion() != null && general.getTipoOperacion() != "") {
			ProfileIDType profileIDType = new ProfileIDType();
			profileIDType.setSchemeName("SUNAT:Identificador de Tipo de Operación");
			profileIDType.setSchemeAgencyName("PE:SUNAT");
			profileIDType.setSchemeURI("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo17");
			profileIDType.setValue(general.getTipoOperacion());
			return profileIDType;
		}
		return  null;
	}

	public LineCountNumericType setCantidadItems (General general) {
		if (general.getCantidadItems() != null && general.getCantidadItems() == BigDecimal.valueOf(0)) {
			LineCountNumericType lineCountNumericType = new LineCountNumericType();
			lineCountNumericType.setValue(general.getCantidadItems());
			lineCountNumericType.getValue();
			return lineCountNumericType;
		}
		return null;
	}
	
	public List<PeriodType> setLstPeriodoFacturacion (General general){
		
		if (general.getLstPeriodoFacturacion().size() == 0 )
			return null;
		
		List<PeriodType> lstPeriodoFac = new ArrayList<PeriodType>();
		
		for (PeriodoFacturacion periodoFacturacion : general.getLstPeriodoFacturacion()) {
			PeriodType periodType = new PeriodType();
			StartDateType startDateType = new StartDateType();
			EndDateType endDateType = new EndDateType();
			
			if(periodoFacturacion != null && 
					periodoFacturacion.getFechaFin() != null && 
					periodoFacturacion.getFechaInicio() != null) {
			
				try {
					XMLGregorianCalendar fechaInicio = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
							periodoFacturacion.getFechaInicio().get(Calendar.YEAR), 
							periodoFacturacion.getFechaInicio().get(Calendar.MONTH)+1, 
							periodoFacturacion.getFechaInicio().get(Calendar.DAY_OF_MONTH), 
							DatatypeConstants.FIELD_UNDEFINED);
					
					XMLGregorianCalendar fechaFin = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
							periodoFacturacion.getFechaFin().get(Calendar.YEAR), 
							periodoFacturacion.getFechaFin().get(Calendar.MONTH)+1, 
							periodoFacturacion.getFechaFin().get(Calendar.DAY_OF_MONTH), 
							DatatypeConstants.FIELD_UNDEFINED);
					
					startDateType.setValue(fechaInicio);
					endDateType.setValue(fechaFin);
					
					periodType.setStartDate(startDateType);
					periodType.setEndDate(endDateType);
					
					lstPeriodoFac.add(periodType);
					
					
				} catch (DatatypeConfigurationException e) {
					System.out.println("Excepcion: Error al parsear fecha de emisión: " + e);
					return null;
				}
			}
			
		}
		
		return lstPeriodoFac;
		
	}
	
	public OrderReferenceType setNumeroOrdenCompra(General general) {
		if(general.getNumeroOrdenCompra() != null && general.getNumeroOrdenCompra() != "") {
			OrderReferenceType orderReferenceType = new OrderReferenceType();
			IDType idType = new IDType();
			idType.setValue(general.getNumeroOrdenCompra());
			orderReferenceType.setID(idType);
			return orderReferenceType;
		}
		return null;
	}
}
