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
 *         &lt;element name="statBoost" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *                   &lt;element name="boostType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                   &lt;element name="shipTarget" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="crewTarget" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="affectsSelf" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="whiteList"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="hatch" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="spider" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="weaver" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="queen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
    "statBoost"
})
public class StatBoosts2 {

    protected List<StatBoost4> statBoost;

    /**
     * Gets the value of the statBoost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statBoost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatBoost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatBoost4 }
     * 
     * 
     */
    public List<StatBoost4> getStatBoost() {
        if (statBoost == null) {
            statBoost = new ArrayList<StatBoost4>();
        }
        return this.statBoost;
    }

}
