package pe.com.fe.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import pe.com.fe.beanxml.Detalle;
import pe.com.fe.beanxml.General;
import pe.com.fe.standar.Item;

public class InvoiceLine {

	private InvoiceLineType invoiceLineType;
	private List<InvoiceLineType> lstInvoiceLine = new ArrayList<InvoiceLineType>();
	private Item item = new Item();
	
	public List<InvoiceLineType> setInvoiceLine (List<Detalle> lstDetalle, General general) {
		
		
		for (Detalle detalle : lstDetalle) {
			invoiceLineType = new InvoiceLineType();
			
			// Numero Item
			IDType id = setId(detalle);
			if(id != null) 
				invoiceLineType.setID(id);
			
			// Cantidad Item
			InvoicedQuantityType invoicedQuantityType = setInvoicedQuantity(detalle);
			if (invoicedQuantityType != null) 
				invoiceLineType.setInvoicedQuantity(invoicedQuantityType);
			
			// DATOS ITEM (Codigo Emisor / Codigo SUNAT / Codigo GS1 / Descripción)
			ItemType itemType = item.setItem(detalle);
			invoiceLineType.setItem(itemType);
			
			// Valor Unitario
			PriceType priceType = setPriceType(detalle, general);
			if (priceType != null)
				invoiceLineType.setPrice(priceType);
			
			lstInvoiceLine.add(invoiceLineType);
		}
		return lstInvoiceLine;
	}
	
	private IDType setId (Detalle detalle) {
		if (detalle.getId() != null && detalle.getId() > 0) {
			IDType idType = new IDType();
			idType.setValue(detalle.getId().toString());
			return idType;
		}
		return null;
	}
	
	private InvoicedQuantityType setInvoicedQuantity(Detalle detalle) {
		if (detalle.getCantidad() != null && detalle.getUnidadMedida() != null && 
				detalle.getCantidad().compareTo(BigDecimal.valueOf(0)) > 0 &&
				detalle.getUnidadMedida() != "") {
			InvoicedQuantityType invoicedQuantityType = new InvoicedQuantityType();
			
			invoicedQuantityType.setUnitCode(detalle.getUnidadMedida());
			invoicedQuantityType.setUnitCodeListID("UN/ECE rec 20");
			invoicedQuantityType.setUnitCodeListAgencyName("United Nations Economic Commission for Europe");
			invoicedQuantityType.setValue(detalle.getCantidad());

			return invoicedQuantityType;
		}
		return null;		
	}
	
	private PriceType setPriceType(Detalle detalle, General general ) {
		if (detalle.getValorUnitarioItem() != null && 
				general.getMoneda() != null &&
				detalle.getValorUnitarioItem().compareTo(BigDecimal.valueOf(0)) > 0 &&
				general.getMoneda() != "") {
			PriceType priceType = new PriceType();
			PriceAmountType priceAmountType = new PriceAmountType();
			
			priceAmountType.setCurrencyID(general.getMoneda());
			priceAmountType.setValue(detalle.getValorUnitarioItem());
			priceType.setPriceAmount(priceAmountType);
			return priceType;
		}
		return null;
	}
}
