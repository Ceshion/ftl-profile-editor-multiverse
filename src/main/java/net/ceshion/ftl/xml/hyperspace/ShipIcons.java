//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.6 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.15 at 05:23:14 PM EDT 
//


package net.ceshion.ftl.xml.hyperspace;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="normalPos"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}short" /&gt;
 *                 &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}short" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="bossPos"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}short" /&gt;
 *                 &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}short" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="shipIcon" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="tooltip" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "normalPos",
    "bossPos",
    "shipIcon"
})
public class ShipIcons {

    @XmlElement(required = true)
    protected NormalPos normalPos;
    @XmlElement(required = true)
    protected BossPos bossPos;
    protected List<ShipIcon> shipIcon;

    /**
     * Gets the value of the normalPos property.
     * 
     * @return
     *     possible object is
     *     {@link NormalPos }
     *     
     */
    public NormalPos getNormalPos() {
        return normalPos;
    }

    /**
     * Sets the value of the normalPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalPos }
     *     
     */
    public void setNormalPos(NormalPos value) {
        this.normalPos = value;
    }

    /**
     * Gets the value of the bossPos property.
     * 
     * @return
     *     possible object is
     *     {@link BossPos }
     *     
     */
    public BossPos getBossPos() {
        return bossPos;
    }

    /**
     * Sets the value of the bossPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link BossPos }
     *     
     */
    public void setBossPos(BossPos value) {
        this.bossPos = value;
    }

    /**
     * Gets the value of the shipIcon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipIcon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipIcon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipIcon }
     * 
     * 
     */
    public List<ShipIcon> getShipIcon() {
        if (shipIcon == null) {
            shipIcon = new ArrayList<ShipIcon>();
        }
        return this.shipIcon;
    }

}
