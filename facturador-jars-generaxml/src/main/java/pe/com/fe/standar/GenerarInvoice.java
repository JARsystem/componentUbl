package pe.com.fe.standar;

import java.util.List;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import pe.com.fe.beanxml.Detalle;
import pe.com.fe.beanxml.DireccionEntrega;
import pe.com.fe.beanxml.DocumentoRelacionado;
import pe.com.fe.beanxml.Emisor;
import pe.com.fe.beanxml.General;
import pe.com.fe.beanxml.Receptor;
import pe.com.fe.invoice.InvoiceLine;

public class GenerarInvoice {

	
	private RelatedDocuments relatedDocuments = new RelatedDocuments();
	private AccountingSupplier accountingSupplier = new AccountingSupplier();
	private AccountingCustomer accountingCustomer = new AccountingCustomer();
	private InvoiceType invoiceType = new InvoiceType();
	
	private ExtensionSignature extensionSignature;
	private Header invoiceHeader = new Header();
	private Delivery delivery = new Delivery();
	private InvoiceLine line = new InvoiceLine();
	
	public InvoiceType setGeneral( 
			General general, 
			List<DocumentoRelacionado> guiaRelacionada,
			List<DocumentoRelacionado> otroDocRelacionada,
			Emisor emisor,
			Receptor receptor,
			DireccionEntrega direccionEntrega,
			List<Detalle> lstItem) {

		invoiceType = invoiceHeader.setInvoice(general);
		
		// Estructura de firma
		extensionSignature = new ExtensionSignature();
		invoiceType.setUBLExtensions(extensionSignature.setUblExtensions());
		
		// Estructura adicional de la firma
		invoiceType.getSignature().add(extensionSignature.setSignature(emisor));
		
		// Guia de remisión asociado
		List<DocumentReferenceType> lsDocumentReferenceTypesGuide = relatedDocuments.guideRelatedDocuments(guiaRelacionada);
		if (lsDocumentReferenceTypesGuide != null && 
				lsDocumentReferenceTypesGuide.size() > 0)
			invoiceType.getDespatchDocumentReference().addAll(lsDocumentReferenceTypesGuide);
				
		// Otros documentos relacionados
		List<DocumentReferenceType> lsDocumentReferenceTypesOther = relatedDocuments.otherRelatedDocuments(otroDocRelacionada);
		if (lsDocumentReferenceTypesOther!=null &&
				lsDocumentReferenceTypesOther.size() > 0) 
			invoiceType.getAdditionalDocumentReference().addAll(lsDocumentReferenceTypesOther);
		
		// Datos del Emisor
		invoiceType.setAccountingSupplierParty(accountingSupplier.setEmisor(emisor));
		
		// Datos del Receptor
		invoiceType.setAccountingCustomerParty(accountingCustomer.setReceptor(receptor));
		
		// Direccion de entrega del bien o servicio
		invoiceType.getDelivery().add(delivery.setDireccionEntrega(direccionEntrega));
		
		// Detalle
		invoiceType.getInvoiceLine().addAll(line.setInvoiceLine(lstItem, general));
		
		return invoiceType;
	}
	
}
