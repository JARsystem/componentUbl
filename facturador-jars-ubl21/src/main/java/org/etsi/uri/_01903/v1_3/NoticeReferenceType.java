//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.07 a las 10:36:18 AM COT 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NoticeReferenceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="NoticeReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Organization" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NoticeNumbers" type="{http://uri.etsi.org/01903/v1.3.2#}IntegerListType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoticeReferenceType", propOrder = {
    "organization",
    "noticeNumbers"
})
public class NoticeReferenceType {

    @XmlElement(name = "Organization", required = true)
    protected String organization;
    @XmlElement(name = "NoticeNumbers", required = true)
    protected IntegerListType noticeNumbers;

    /**
     * Obtiene el valor de la propiedad organization.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Define el valor de la propiedad organization.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganization(String value) {
        this.organization = value;
    }

    /**
     * Obtiene el valor de la propiedad noticeNumbers.
     * 
     * @return
     *     possible object is
     *     {@link IntegerListType }
     *     
     */
    public IntegerListType getNoticeNumbers() {
        return noticeNumbers;
    }

    /**
     * Define el valor de la propiedad noticeNumbers.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerListType }
     *     
     */
    public void setNoticeNumbers(IntegerListType value) {
        this.noticeNumbers = value;
    }

}
