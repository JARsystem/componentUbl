package pe.com.fe.standar;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AttachmentType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExternalReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SignatureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.URIType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;
import pe.com.fe.beanxml.Emisor;

public class ExtensionSignature {

	ExtensionContentType extensionContent;
	UBLExtensionsType ublExtensions;
	SignatureType signatureType;
	
	public ExtensionSignature() {
		super();
	}
	
	public UBLExtensionsType setUblExtensions() {
		extensionContent = new ExtensionContentType();
		UBLExtensionType ublExtension = new UBLExtensionType();
		ublExtension.setExtensionContent(extensionContent);
		ublExtensions = new UBLExtensionsType();
		ublExtensions.getUBLExtension().add(ublExtension);
		return ublExtensions;
	}
	
	public SignatureType setSignature(Emisor emisor) {
		if (emisor.getNumeroDocumentoIdentidad() != null && emisor.getRazonSocial() != null &&
				emisor.getNumeroDocumentoIdentidad() != "" && emisor.getRazonSocial() != "") {
		
			SignatureType signatureType = new SignatureType();
			IDType idType = new IDType();
			
			NameType nameType = new NameType();
			
			idType.setValue("IDSignKG");
			signatureType.setID(idType);
			
			/*Razon Social*/
			PartyNameType partyNameType = new PartyNameType();
			nameType.setValue(emisor.getRazonSocial());
			partyNameType.setName(nameType);
			
			/*RUC*/
			PartyType partyType = new PartyType();
			IDType idTypeRuc = new IDType();
			PartyIdentificationType partyIdentification = new PartyIdentificationType();
			idTypeRuc.setValue(emisor.getNumeroDocumentoIdentidad());
			partyIdentification.setID(idTypeRuc);
			partyType.getPartyIdentification().add(partyIdentification);
			
			/*URI*/
			ExternalReferenceType externalReferenceType = new ExternalReferenceType();
			URIType uriType = new URIType();
			AttachmentType attachmentType = new AttachmentType();
			
			uriType.setValue("#signatureKG");
			externalReferenceType.setURI(uriType);
			attachmentType.setExternalReference(externalReferenceType);
			
			/*Signature*/		
			signatureType.setSignatoryParty(partyType);
			signatureType.getSignatoryParty().getPartyName().add(partyNameType);
			signatureType.setDigitalSignatureAttachment(attachmentType);
			
			return signatureType;
		}
		return null;
	}
}
