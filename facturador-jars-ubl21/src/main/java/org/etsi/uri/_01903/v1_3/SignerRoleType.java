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
 * <p>Clase Java para SignerRoleType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SignerRoleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClaimedRoles" type="{http://uri.etsi.org/01903/v1.3.2#}ClaimedRolesListType" minOccurs="0"/&gt;
 *         &lt;element name="CertifiedRoles" type="{http://uri.etsi.org/01903/v1.3.2#}CertifiedRolesListType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignerRoleType", propOrder = {
    "claimedRoles",
    "certifiedRoles"
})
public class SignerRoleType {

    @XmlElement(name = "ClaimedRoles")
    protected ClaimedRolesListType claimedRoles;
    @XmlElement(name = "CertifiedRoles")
    protected CertifiedRolesListType certifiedRoles;

    /**
     * Obtiene el valor de la propiedad claimedRoles.
     * 
     * @return
     *     possible object is
     *     {@link ClaimedRolesListType }
     *     
     */
    public ClaimedRolesListType getClaimedRoles() {
        return claimedRoles;
    }

    /**
     * Define el valor de la propiedad claimedRoles.
     * 
     * @param value
     *     allowed object is
     *     {@link ClaimedRolesListType }
     *     
     */
    public void setClaimedRoles(ClaimedRolesListType value) {
        this.claimedRoles = value;
    }

    /**
     * Obtiene el valor de la propiedad certifiedRoles.
     * 
     * @return
     *     possible object is
     *     {@link CertifiedRolesListType }
     *     
     */
    public CertifiedRolesListType getCertifiedRoles() {
        return certifiedRoles;
    }

    /**
     * Define el valor de la propiedad certifiedRoles.
     * 
     * @param value
     *     allowed object is
     *     {@link CertifiedRolesListType }
     *     
     */
    public void setCertifiedRoles(CertifiedRolesListType value) {
        this.certifiedRoles = value;
    }

}
