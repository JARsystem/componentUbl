package pe.com.fe.standar;

import java.util.ArrayList;
import java.util.List;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CommodityClassificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ItemClassificationCodeType;
import pe.com.fe.beanxml.Detalle;

public class Item {

	public ItemType setItem (Detalle detalle) {
		ItemType itemType = new ItemType();
		
		// Codigo Emisor
		ItemIdentificationType itemIdentificationType = setIdentificationType(detalle);
		if (itemIdentificationType != null) {
			itemType.setSellersItemIdentification(itemIdentificationType);
		}
		
		// Codigo SUNAT
		CommodityClassificationType commodityClassificationType = setCommodityClassificationType(detalle);
		if (commodityClassificationType != null) 
			itemType.getCommodityClassification().add(commodityClassificationType);
		
		// Codigo GS1
		ItemIdentificationType itemIdentificationTypeGS1 = setIdentificationTypeGS1(detalle);
		if (itemIdentificationTypeGS1 != null)
			itemType.setStandardItemIdentification(itemIdentificationTypeGS1);
		
		// Descripción
		List<DescriptionType> lstDescriptionTypes = setLstDescription(detalle);
		if (lstDescriptionTypes != null && lstDescriptionTypes.size() > 0)
			itemType.getDescription().addAll(lstDescriptionTypes);
		
		return itemType;
		
	}
	
	private ItemIdentificationType setIdentificationType (Detalle detalle) {
		
		if (detalle.getCodigoProductoEmisor() != null &&
				detalle.getCodigoProductoEmisor() != "") {
		
			ItemIdentificationType itemIdentificationType = new ItemIdentificationType();
			IDType idType = new IDType();
			
			idType.setValue(detalle.getCodigoProductoEmisor());
			itemIdentificationType.setID(idType);
			
			return itemIdentificationType;
		}
		return null;
	}
	
	private CommodityClassificationType setCommodityClassificationType (Detalle detalle) {
		if (detalle.getCodigoProductoSunat() != null &&
				detalle.getCodigoProductoSunat() != "") {
			CommodityClassificationType commodityClassificationType = new CommodityClassificationType();
			ItemClassificationCodeType itemClassificationCodeType = new ItemClassificationCodeType();
			itemClassificationCodeType.setValue(detalle.getCodigoProductoSunat());
			
			itemClassificationCodeType.setListID("UNSPSC");
			itemClassificationCodeType.setListAgencyName("GS1 US");
			itemClassificationCodeType.setListName("Item Classification");
			commodityClassificationType.setItemClassificationCode(itemClassificationCodeType);
			return commodityClassificationType;
		}
		return null;
	}
	
	private ItemIdentificationType setIdentificationTypeGS1 (Detalle detalle) {
		if (detalle.getCodigoProductoGS1() != null && detalle.getCodigoProductoGS1() != "") {
			ItemIdentificationType itemIdentificationType = new ItemIdentificationType();
			IDType idType = new IDType();
			
			idType.setSchemeID(detalle.getCodigoProductoGS1Gtin());
			idType.setValue(detalle.getCodigoProductoGS1());
			itemIdentificationType.setID(idType);
			return itemIdentificationType;
		}
		return null;
	}
	
	private List<DescriptionType> setLstDescription(Detalle detalle) {
		if (detalle.getLstDescripcion() != null && detalle.getLstDescripcion().size() > 0) {
			List<DescriptionType> lsDescriptionTypes = new ArrayList<DescriptionType>();
			
			for (String det : detalle.getLstDescripcion()) {
				if (det != null && det != "") {
					DescriptionType descriptionType = new DescriptionType();
					descriptionType.setValue(det);
					lsDescriptionTypes.add(descriptionType);
				}
			}
			return lsDescriptionTypes;
		}
		return null;
	}
	
	
	
}
