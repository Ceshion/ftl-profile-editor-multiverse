//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.6 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.15 at 05:23:14 PM EDT 
//


package net.ceshion.ftl.xml.hyperspace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="medbay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="drones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "medbay",
    "drones"
})
public class SystemPowerDependency {

    protected String medbay;
    protected String drones;

    /**
     * Gets the value of the medbay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedbay() {
        return medbay;
    }

    /**
     * Sets the value of the medbay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedbay(String value) {
        this.medbay = value;
    }

    /**
     * Gets the value of the drones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrones() {
        return drones;
    }

    /**
     * Sets the value of the drones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrones(String value) {
        this.drones = value;
    }

}
