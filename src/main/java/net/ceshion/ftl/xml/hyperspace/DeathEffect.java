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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="ion" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="persDamage" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="stun" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="friendlyFire" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="shipFriendlyFire" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lockdown" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="breachChance" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="spawnCrew"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="race" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="playerEvent"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="load" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fireChance" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ion",
    "persDamage",
    "stun",
    "friendlyFire",
    "shipFriendlyFire",
    "lockdown",
    "breachChance",
    "spawnCrew",
    "playerEvent",
    "fireChance"
})
public class DeathEffect {

    @XmlElement(type = Byte.class)
    protected List<Byte> ion;
    @XmlElement(type = Byte.class)
    protected List<Byte> persDamage;
    @XmlElement(type = Byte.class)
    protected List<Byte> stun;
    protected List<String> friendlyFire;
    protected List<String> shipFriendlyFire;
    protected List<String> lockdown;
    @XmlElement(type = Byte.class)
    protected List<Byte> breachChance;
    protected List<SpawnCrew> spawnCrew;
    protected List<PlayerEvent> playerEvent;
    @XmlElement(type = Byte.class)
    protected List<Byte> fireChance;

    /**
     * Gets the value of the ion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Byte }
     * 
     * 
     */
    public List<Byte> getIon() {
        if (ion == null) {
            ion = new ArrayList<Byte>();
        }
        return this.ion;
    }

    /**
     * Gets the value of the persDamage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the persDamage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersDamage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Byte }
     * 
     * 
     */
    public List<Byte> getPersDamage() {
        if (persDamage == null) {
            persDamage = new ArrayList<Byte>();
        }
        return this.persDamage;
    }

    /**
     * Gets the value of the stun property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stun property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStun().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Byte }
     * 
     * 
     */
    public List<Byte> getStun() {
        if (stun == null) {
            stun = new ArrayList<Byte>();
        }
        return this.stun;
    }

    /**
     * Gets the value of the friendlyFire property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the friendlyFire property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFriendlyFire().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFriendlyFire() {
        if (friendlyFire == null) {
            friendlyFire = new ArrayList<String>();
        }
        return this.friendlyFire;
    }

    /**
     * Gets the value of the shipFriendlyFire property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipFriendlyFire property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipFriendlyFire().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getShipFriendlyFire() {
        if (shipFriendlyFire == null) {
            shipFriendlyFire = new ArrayList<String>();
        }
        return this.shipFriendlyFire;
    }

    /**
     * Gets the value of the lockdown property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lockdown property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLockdown().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLockdown() {
        if (lockdown == null) {
            lockdown = new ArrayList<String>();
        }
        return this.lockdown;
    }

    /**
     * Gets the value of the breachChance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the breachChance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBreachChance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Byte }
     * 
     * 
     */
    public List<Byte> getBreachChance() {
        if (breachChance == null) {
            breachChance = new ArrayList<Byte>();
        }
        return this.breachChance;
    }

    /**
     * Gets the value of the spawnCrew property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spawnCrew property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpawnCrew().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpawnCrew }
     * 
     * 
     */
    public List<SpawnCrew> getSpawnCrew() {
        if (spawnCrew == null) {
            spawnCrew = new ArrayList<SpawnCrew>();
        }
        return this.spawnCrew;
    }

    /**
     * Gets the value of the playerEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the playerEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlayerEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlayerEvent }
     * 
     * 
     */
    public List<PlayerEvent> getPlayerEvent() {
        if (playerEvent == null) {
            playerEvent = new ArrayList<PlayerEvent>();
        }
        return this.playerEvent;
    }

    /**
     * Gets the value of the fireChance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fireChance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFireChance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Byte }
     * 
     * 
     */
    public List<Byte> getFireChance() {
        if (fireChance == null) {
            fireChance = new ArrayList<Byte>();
        }
        return this.fireChance;
    }

}