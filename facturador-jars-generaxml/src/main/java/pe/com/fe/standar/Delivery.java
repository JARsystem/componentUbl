package pe.com.fe.standar;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CitySubdivisionNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DistrictType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineType;
import pe.com.fe.beanxml.DireccionEntrega;

public class Delivery {

	public DeliveryType setDireccionEntrega(DireccionEntrega direccionEntrega) {
		DeliveryType deliveryType = new DeliveryType();
		AddressType datosDireccion = new AddressType(); 
		LocationType locationType = new LocationType();
			
		AddressLineType direccion = setDireccion(direccionEntrega);
		if (direccion != null)
			datosDireccion.getAddressLine().add(direccion);
			
		CitySubdivisionNameType urbanizacion = setUrbanizacion(direccionEntrega);
		if (urbanizacion != null)
			datosDireccion.setCitySubdivisionName(urbanizacion);
		
		DistrictType distrito = setDistrito(direccionEntrega);
		if (distrito != null)
			datosDireccion.setDistrict(distrito);
		
		CityNameType provincia = setProvincia(direccionEntrega);
		if (provincia != null)
			datosDireccion.setCityName(provincia);
			
		CountrySubentityType departamento = setDepartamento(direccionEntrega);
		if (departamento != null)
			datosDireccion.setCountrySubentity(departamento);
		
		IDType ubigeo = setUbigeo(direccionEntrega);
		if (ubigeo != null)
			datosDireccion.setID(ubigeo);
			
		CountryType codigoPais = setCodigoPais(direccionEntrega);
		if (codigoPais != null)
			datosDireccion.setCountry(codigoPais);
		
		locationType.setAddress(datosDireccion);
		deliveryType.setDeliveryLocation(locationType);
		
		return deliveryType;
	}
	
	private AddressLineType setDireccion(DireccionEntrega direccionEntrega) {
		
		if(direccionEntrega.getDireccion() != null && direccionEntrega.getDireccion() != "") {
			AddressLineType addressLineType = new AddressLineType();
			LineType lineType = new LineType();
			lineType.setValue(direccionEntrega.getDireccion());
			addressLineType.setLine(lineType);
			
			return addressLineType;
		}
		return null;
	}
	
	private CitySubdivisionNameType setUrbanizacion(DireccionEntrega direccionEntrega) {
		
		if(direccionEntrega.getUrbanizacion() != null && direccionEntrega.getUrbanizacion() != "") {
			CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
			citySubdivisionNameType.setValue(direccionEntrega.getUrbanizacion());
			
			return citySubdivisionNameType;
		}
		return null;
	}
	
	private DistrictType setDistrito(DireccionEntrega direccionEntrega) {
		
		if(direccionEntrega.getDistrito() != null && direccionEntrega.getDistrito() != "") {
			DistrictType districtType = new DistrictType();
			districtType.setValue(direccionEntrega.getDistrito());
			return districtType;
		}
		return null;
	}
	
	private CityNameType setProvincia(DireccionEntrega direccionEntrega) {
		if(direccionEntrega.getProvincia() != null && direccionEntrega.getProvincia() != "") {
			CityNameType cityNameType = new CityNameType();
			cityNameType.setValue(direccionEntrega.getProvincia());
			return cityNameType;
		}
		return null;
	}
	
	private CountrySubentityType setDepartamento(DireccionEntrega direccionEntrega) {
		if(direccionEntrega.getDepartamento() != null && direccionEntrega.getDepartamento() != "") {
			CountrySubentityType countrySubentityType = new CountrySubentityType();
			countrySubentityType.setValue(direccionEntrega.getDepartamento());
			return countrySubentityType;
		}
		return null;
	}
	
	private CountryType setCodigoPais(DireccionEntrega direccionEntrega) {
		
		if (direccionEntrega.getCodigoPais() != null && direccionEntrega.getCodigoPais() != "") {
			IdentificationCodeType identificationCodeType = new IdentificationCodeType();
			CountryType countryType = new CountryType();
			
			identificationCodeType.setListID("ISO 3166-1");
			identificationCodeType.setListAgencyName("United Nations Economic Commission for Europe");
			identificationCodeType.setListName("Country");
			identificationCodeType.setValue(direccionEntrega.getCodigoPais());
			countryType.setIdentificationCode(identificationCodeType);
			return countryType;
		}
		return null;
	}
	
	private IDType setUbigeo(DireccionEntrega direccionEntrega) {
		
		if (direccionEntrega.getUbigeo() != null && direccionEntrega.getUbigeo() != "") {
			IDType idType = new IDType();
			idType.setSchemeAgencyName("PE:INEI");
			idType.setSchemeName("Ubigeos");
			idType.setValue(direccionEntrega.getUbigeo());
			return idType;
		}
		return null;
	}
}
