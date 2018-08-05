package pe.com.fe.standar;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AddressTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CitySubdivisionNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DistrictType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import pe.com.fe.beanxml.Emisor;

public class AccountingSupplier {
	
	SupplierPartyType supplierPartyType;
	PartyType partyType;
	
	public SupplierPartyType setEmisor(Emisor emisor) {
		supplierPartyType = new SupplierPartyType();
		partyType = new PartyType();
		
		
		PartyIdentificationType documentoIdentidadEmisor = setNumeroDocumentoIdentidad(emisor);
		if(documentoIdentidadEmisor != null)
			partyType.getPartyIdentification().add(documentoIdentidadEmisor);
		
		PartyNameType nombreComercial = setNombreComercial(emisor);
		if (nombreComercial != null)
			partyType.getPartyName().add(nombreComercial);
			
		PartyLegalEntityType datosEmisor = setRazonSocial(emisor);
		if(datosEmisor != null)
			partyType.getPartyLegalEntity().add(datosEmisor);
		
		AddressType direccion = setDireccion(emisor);
		if (direccion != null)
			datosEmisor.setRegistrationAddress(direccion);
		
		CitySubdivisionNameType urbanizacion = setUrbanizacion(emisor);
		if (urbanizacion != null)
			datosEmisor.getRegistrationAddress().setCitySubdivisionName(urbanizacion);
		
		DistrictType distrito = setDistrito(emisor);
		if (distrito != null)
			datosEmisor.getRegistrationAddress().setDistrict(distrito);
		
		CityNameType provincia = setProvincia(emisor);
		if (provincia != null)
			datosEmisor.getRegistrationAddress().setCityName(provincia);
		
		CountrySubentityType departamento = setDepartamento(emisor);
		if (departamento != null)
			datosEmisor.getRegistrationAddress().setCountrySubentity(departamento);
		
		CountryType codigoPais = setCodigoPais(emisor);
		if (codigoPais != null)
			datosEmisor.getRegistrationAddress().setCountry(codigoPais);
		
		IDType ubigeo = setUbigeo(emisor);
		if (ubigeo != null)
			datosEmisor.getRegistrationAddress().setID(ubigeo);
		
		AddressTypeCodeType addressTypeCodeType = setCodigoEstablecimiento(emisor);
		if (addressTypeCodeType != null)
			datosEmisor.getRegistrationAddress().setAddressTypeCode(addressTypeCodeType);
		
		supplierPartyType.setParty(partyType);
		
		return supplierPartyType;
	}
	
	private PartyIdentificationType setNumeroDocumentoIdentidad(Emisor emisor) {
		
		PartyIdentificationType partyIdentificationType = new PartyIdentificationType();
		
		System.out.println(emisor.getNumeroDocumentoIdentidad());
		System.out.println(emisor.getTipoDocumentoIdentidad());
		
		if (emisor.getNumeroDocumentoIdentidad()!= null &&
				emisor.getNumeroDocumentoIdentidad() != "" &&
				emisor.getTipoDocumentoIdentidad() != null &&
				emisor.getTipoDocumentoIdentidad() != "") {
			
			IDType idType = new IDType();
			idType.setSchemeID(emisor.getTipoDocumentoIdentidad());
			idType.setSchemeName("SUNAT:Identificador de Documento de Identidad");
			idType.setSchemeAgencyName("PE:SUNAT");
			idType.setSchemeURI("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06");
			idType.setValue(emisor.getNumeroDocumentoIdentidad());
			
			partyIdentificationType.setID(idType);
			
			return partyIdentificationType;
			
		}
		return null;
	}
	
	private PartyNameType setNombreComercial(Emisor emisor) {
		
		if (emisor.getNombreComercial() != null) {
			PartyNameType partyNameType = new PartyNameType();
			NameType nameType = new NameType();
			nameType.setValue(emisor.getNombreComercial());
			partyNameType.setName(nameType);
			
			return partyNameType;
		}
		
		return null;
	}
	
	private PartyLegalEntityType setRazonSocial (Emisor emisor) {
		
		if(emisor.getRazonSocial() != "") {
			PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
			RegistrationNameType registrationNameType = new RegistrationNameType();
			
			registrationNameType.setValue(emisor.getRazonSocial());
			partyLegalEntityType.setRegistrationName(registrationNameType);
			
			return partyLegalEntityType;
		}
		return null;
	}
	
	private AddressType setDireccion(Emisor emisor) {
		
		if(emisor.getDireccion() != null && emisor.getDireccion() != "") {
			AddressType addressType = new AddressType();
			AddressLineType addressLineType = new AddressLineType();
			LineType lineType = new LineType();
			lineType.setValue(emisor.getDireccion());
			addressLineType.setLine(lineType);
			addressType.getAddressLine().add(addressLineType);
			
			return addressType;
		}
		return null;
	}
	
	private CitySubdivisionNameType setUrbanizacion(Emisor emisor) {
		
		if(emisor.getUrbanizacion() != null && emisor.getUrbanizacion() != "") {
			CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
			citySubdivisionNameType.setValue(emisor.getUrbanizacion());
			
			return citySubdivisionNameType;
		}
		return null;
	}
	
	private DistrictType setDistrito(Emisor emisor) {
		
		if(emisor.getDistrito() != null && emisor.getDistrito() != "") {
			DistrictType districtType = new DistrictType();
			districtType.setValue(emisor.getDistrito());
			return districtType;
		}
		return null;
	}
	
	private CityNameType setProvincia(Emisor emisor) {
		if(emisor.getProvincia() != null && emisor.getProvincia() != "") {
			CityNameType cityNameType = new CityNameType();
			cityNameType.setValue(emisor.getProvincia());
			return cityNameType;
		}
		return null;
	}
	
	private CountrySubentityType setDepartamento(Emisor emisor) {
		if(emisor.getDepartamento() != null && emisor.getDepartamento() != "") {
			CountrySubentityType countrySubentityType = new CountrySubentityType();
			countrySubentityType.setValue(emisor.getDepartamento());
			return countrySubentityType;
		}
		return null;
	}
	
	private CountryType setCodigoPais(Emisor emisor) {
		
		if (emisor.getCodigoPais() != null && emisor.getCodigoPais() != "") {
			IdentificationCodeType identificationCodeType = new IdentificationCodeType();
			CountryType countryType = new CountryType();
			
			identificationCodeType.setListID("ISO 3166-1");
			identificationCodeType.setListAgencyName("United Nations Economic Commission for Europe");
			identificationCodeType.setListName("Country");
			identificationCodeType.setValue(emisor.getCodigoPais());
			countryType.setIdentificationCode(identificationCodeType);
			return countryType;
		}
		return null;
	}
	
	private IDType setUbigeo(Emisor emisor) {
		
		if (emisor.getUbigeo() != null && emisor.getUbigeo() != "") {
			IDType idType = new IDType();
			idType.setSchemeAgencyName("PE:INEI");
			idType.setSchemeName("Ubigeos");
			idType.setValue(emisor.getUbigeo());
			return idType;
		}
		return null;
	}
	
	private AddressTypeCodeType setCodigoEstablecimiento(Emisor emisor) {
		if(emisor.getCodigoEstablecimientoSunat() != null && emisor.getCodigoEstablecimientoSunat() != "") {
			AddressTypeCodeType addressTypeCodeType = new AddressTypeCodeType();
			addressTypeCodeType.setListAgencyName("PE:SUNAT");
			addressTypeCodeType.setListName("Establecimientos anexos");
			addressTypeCodeType.setValue(emisor.getCodigoEstablecimientoSunat());
			return addressTypeCodeType;
		}
		
		return null;
	}

}
