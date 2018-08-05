package pe.com.fe.standar;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CitySubdivisionNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DistrictType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import pe.com.fe.beanxml.Receptor;

public class AccountingCustomer {
	
	CustomerPartyType customerPartyType;
	PartyType partyType;
	
	public CustomerPartyType setReceptor(Receptor receptor) {
		customerPartyType = new CustomerPartyType();
		partyType = new PartyType();
		
		
		PartyIdentificationType documentoIdentidadEmisor = setNumeroDocumentoIdentidad(receptor);
		if(documentoIdentidadEmisor != null)
			partyType.getPartyIdentification().add(documentoIdentidadEmisor);
		
		PartyNameType nombreComercial = setNombreComercial(receptor);
		if (nombreComercial != null)
			partyType.getPartyName().add(nombreComercial);
			
		PartyLegalEntityType datosEmisor = setRazonSocial(receptor);
		if(datosEmisor != null)
			partyType.getPartyLegalEntity().add(datosEmisor);
		
		AddressType direccion = setDireccion(receptor);
		if (direccion != null)
			datosEmisor.setRegistrationAddress(direccion);
		
		CitySubdivisionNameType urbanizacion = setUrbanizacion(receptor);
		if (urbanizacion != null)
			datosEmisor.getRegistrationAddress().setCitySubdivisionName(urbanizacion);
		
		DistrictType distrito = setDistrito(receptor);
		if (distrito != null)
			datosEmisor.getRegistrationAddress().setDistrict(distrito);
		
		CityNameType provincia = setProvincia(receptor);
		if (provincia != null)
			datosEmisor.getRegistrationAddress().setCityName(provincia);
		
		CountrySubentityType departamento = setDepartamento(receptor);
		if (departamento != null)
			datosEmisor.getRegistrationAddress().setCountrySubentity(departamento);
		
		CountryType codigoPais = setCodigoPais(receptor);
		if (codigoPais != null)
			datosEmisor.getRegistrationAddress().setCountry(codigoPais);
		
		IDType ubigeo = setUbigeo(receptor);
		if (ubigeo != null)
			datosEmisor.getRegistrationAddress().setID(ubigeo);
		
		customerPartyType.setParty(partyType);
		
		return customerPartyType;
	}
	
	private PartyIdentificationType setNumeroDocumentoIdentidad(Receptor receptor) {
		
		PartyIdentificationType partyIdentificationType = new PartyIdentificationType();
		
		System.out.println(receptor.getNumeroDocumentoIdentidad());
		System.out.println(receptor.getTipoDocumentoIdentidad());
		
		if (receptor.getNumeroDocumentoIdentidad()!= null &&
				receptor.getNumeroDocumentoIdentidad() != "" &&
				receptor.getTipoDocumentoIdentidad() != null &&
				receptor.getTipoDocumentoIdentidad() != "") {
			
			IDType idType = new IDType();
			idType.setSchemeID(receptor.getTipoDocumentoIdentidad());
			idType.setSchemeName("SUNAT:Identificador de Documento de Identidad");
			idType.setSchemeAgencyName("PE:SUNAT");
			idType.setSchemeURI("urn:pe:gob:sunat:cpe:see:gem:catalogos:catalogo06");
			idType.setValue(receptor.getNumeroDocumentoIdentidad());
			
			partyIdentificationType.setID(idType);
			
			return partyIdentificationType;
			
		}
		return null;
	}
	
	private PartyNameType setNombreComercial(Receptor receptor) {
		
		if (receptor.getNombreComercial() != null) {
			PartyNameType partyNameType = new PartyNameType();
			NameType nameType = new NameType();
			nameType.setValue(receptor.getNombreComercial());
			partyNameType.setName(nameType);
			
			return partyNameType;
		}
		
		return null;
	}
	
	private PartyLegalEntityType setRazonSocial (Receptor receptor) {
		
		if(receptor.getRazonSocial() != "") {
			PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
			RegistrationNameType registrationNameType = new RegistrationNameType();
			
			registrationNameType.setValue(receptor.getRazonSocial());
			partyLegalEntityType.setRegistrationName(registrationNameType);
			
			return partyLegalEntityType;
		}
		return null;
	}
	
	private AddressType setDireccion(Receptor receptor) {
		
		if(receptor.getDireccion() != null && receptor.getDireccion() != "") {
			AddressType addressType = new AddressType();
			AddressLineType addressLineType = new AddressLineType();
			LineType lineType = new LineType();
			lineType.setValue(receptor.getDireccion());
			addressLineType.setLine(lineType);
			addressType.getAddressLine().add(addressLineType);
			
			return addressType;
		}
		return null;
	}
	
	private CitySubdivisionNameType setUrbanizacion(Receptor receptor) {
		
		if(receptor.getUrbanizacion() != null && receptor.getUrbanizacion() != "") {
			CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
			citySubdivisionNameType.setValue(receptor.getUrbanizacion());
			
			return citySubdivisionNameType;
		}
		return null;
	}
	
	private DistrictType setDistrito(Receptor receptor) {
		
		if(receptor.getDistrito() != null && receptor.getDistrito() != "") {
			DistrictType districtType = new DistrictType();
			districtType.setValue(receptor.getDistrito());
			return districtType;
		}
		return null;
	}
	
	private CityNameType setProvincia(Receptor receptor) {
		if(receptor.getProvincia() != null && receptor.getProvincia() != "") {
			CityNameType cityNameType = new CityNameType();
			cityNameType.setValue(receptor.getProvincia());
			return cityNameType;
		}
		return null;
	}
	
	private CountrySubentityType setDepartamento(Receptor receptor) {
		if(receptor.getDepartamento() != null && receptor.getDepartamento() != "") {
			CountrySubentityType countrySubentityType = new CountrySubentityType();
			countrySubentityType.setValue(receptor.getDepartamento());
			return countrySubentityType;
		}
		return null;
	}
	
	private CountryType setCodigoPais(Receptor receptor) {
		
		if (receptor.getCodigoPais() != null && receptor.getCodigoPais() != "") {
			IdentificationCodeType identificationCodeType = new IdentificationCodeType();
			CountryType countryType = new CountryType();
			
			identificationCodeType.setListID("ISO 3166-1");
			identificationCodeType.setListAgencyName("United Nations Economic Commission for Europe");
			identificationCodeType.setListName("Country");
			identificationCodeType.setValue(receptor.getCodigoPais());
			countryType.setIdentificationCode(identificationCodeType);
			return countryType;
		}
		return null;
	}
	
	private IDType setUbigeo(Receptor receptor) {
		
		if (receptor.getUbigeo() != null && receptor.getUbigeo() != "") {
			IDType idType = new IDType();
			idType.setSchemeAgencyName("PE:INEI");
			idType.setSchemeName("Ubigeos");
			idType.setValue(receptor.getUbigeo());
			return idType;
		}
		return null;
	}
	
	

}
