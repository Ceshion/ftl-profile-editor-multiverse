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
 *         &lt;element name="noSys" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="noPwr" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="onePwr" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="twoPwr" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *         &lt;element name="threePwr" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *         &lt;element name="fourPwr" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
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
    "noSys",
    "noPwr",
    "onePwr",
    "twoPwr",
    "threePwr",
    "fourPwr"
})
public class SystemPowerScaling {

    protected byte noSys;
    protected byte noPwr;
    protected byte onePwr;
    protected Float twoPwr;
    protected Float threePwr;
    protected Float fourPwr;

    /**
     * Gets the value of the noSys property.
     * 
     */
    public byte getNoSys() {
        return noSys;
    }

    /**
     * Sets the value of the noSys property.
     * 
     */
    public void setNoSys(byte value) {
        this.noSys = value;
    }

    /**
     * Gets the value of the noPwr property.
     * 
     */
    public byte getNoPwr() {
        return noPwr;
    }

    /**
     * Sets the value of the noPwr property.
     * 
     */
    public void setNoPwr(byte value) {
        this.noPwr = value;
    }

    /**
     * Gets the value of the onePwr property.
     * 
     */
    public byte getOnePwr() {
        return onePwr;
    }

    /**
     * Sets the value of the onePwr property.
     * 
     */
    public void setOnePwr(byte value) {
        this.onePwr = value;
    }

    /**
     * Gets the value of the twoPwr property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTwoPwr() {
        return twoPwr;
    }

    /**
     * Sets the value of the twoPwr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTwoPwr(Float value) {
        this.twoPwr = value;
    }

    /**
     * Gets the value of the threePwr property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getThreePwr() {
        return threePwr;
    }

    /**
     * Sets the value of the threePwr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setThreePwr(Float value) {
        this.threePwr = value;
    }

    /**
     * Gets the value of the fourPwr property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFourPwr() {
        return fourPwr;
    }

    /**
     * Sets the value of the fourPwr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFourPwr(Float value) {
        this.fourPwr = value;
    }

}
