package pe.com.fe.standar;

import java.util.ArrayList;
import java.util.List;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import pe.com.fe.beanxml.DocumentoRelacionado;

public class RelatedDocuments {

	List<DocumentReferenceType> lstOtherDocumentReferenceType = new ArrayList<DocumentReferenceType>();
	List<DocumentReferenceType> lstGuideDocumentReferenceType = new ArrayList<DocumentReferenceType>();
	
	public List<DocumentReferenceType> otherRelatedDocuments(List<DocumentoRelacionado> lstOtroRelacionados) {
		
		if (lstOtroRelacionados.size() == 0 )
			return null;
		
		for (DocumentoRelacionado documentoRelacionado : lstOtroRelacionados) {
			DocumentTypeCodeType documentTypeCodeType = new DocumentTypeCodeType();
			IDType idType = new IDType();
			
			if (documentoRelacionado.getSerieNumeroDocRelacionado() != null &&
				documentoRelacionado.getTipoDocuRelacionado() != null &&
				documentoRelacionado.getSerieNumeroDocRelacionado() != "" &&
				documentoRelacionado.getTipoDocuRelacionado() != "") {
				
				documentTypeCodeType.setListAgencyName("PE:SUNAT");
				documentTypeCodeType.setListName("SUNAT: Identificador de documento relacionado");
				documentTypeCodeType.setListURI("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo12");
				documentTypeCodeType.setValue(documentoRelacionado.getTipoDocuRelacionado());
				
				idType.setValue(documentoRelacionado.getSerieNumeroDocRelacionado());
				
				DocumentReferenceType documentReferenceType = new DocumentReferenceType();
				documentReferenceType.setDocumentTypeCode(documentTypeCodeType);
				documentReferenceType.setID(idType);
				
				lstOtherDocumentReferenceType.add(documentReferenceType);
			}
		}
		
		return lstOtherDocumentReferenceType;
	}
	
	public List<DocumentReferenceType> guideRelatedDocuments(List <DocumentoRelacionado> lstGuiaRelacionados) {
		
		if (lstGuiaRelacionados.size() == 0 )
			return null;
		
		for (DocumentoRelacionado documentoRelacionado : lstGuiaRelacionados) {
			if (documentoRelacionado.getSerieNumeroDocRelacionado() != null &&
				documentoRelacionado.getTipoDocuRelacionado() != null &&
				documentoRelacionado.getSerieNumeroDocRelacionado() != "" &&
				documentoRelacionado.getTipoDocuRelacionado() != "") {
			
				DocumentTypeCodeType documentTypeCodeType = new DocumentTypeCodeType();
				IDType idType = new IDType();
				
				documentTypeCodeType.setListAgencyName("PE:SUNAT");
				documentTypeCodeType.setListName("SUNAT: Identificador de documento relacionado");
				documentTypeCodeType.setListURI("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo01");
				documentTypeCodeType.setValue(documentoRelacionado.getTipoDocuRelacionado());
				
				idType.setValue(documentoRelacionado.getSerieNumeroDocRelacionado());
				
				DocumentReferenceType documentReferenceType = new DocumentReferenceType();
				documentReferenceType.setDocumentTypeCode(documentTypeCodeType);
				documentReferenceType.setID(idType);
				lstGuideDocumentReferenceType.add(documentReferenceType);
			}
		}
		return lstGuideDocumentReferenceType;
	}
}
