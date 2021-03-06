//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.31 at 01:49:34 PM CEST 
//


package org.bgbm.biovel.drf.tnr.msg;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nameType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nameComplete">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nameCanonical">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nameLabel" maxOccurs="unbounded" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="atomisedName" type="{http://bgbm.org/biovel/drf/tnr/msg}atomisedNameType" minOccurs="0"/>
 *         &lt;element name="nameStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nameType", propOrder = {
    "nameComplete",
    "nameCanonical",
    "nameLabel",
    "atomisedName",
    "nameStatus"
})
public class NameType {

    @XmlElement(required = true)
    protected String nameComplete;
    @XmlElement(required = true)
    protected String nameCanonical;
    protected List<String> nameLabel;
    protected AtomisedNameType atomisedName;
    protected String nameStatus;

    /**
     * Gets the value of the nameComplete property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameComplete() {
        return nameComplete;
    }

    /**
     * Sets the value of the nameComplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameComplete(String value) {
        this.nameComplete = value;
    }

    /**
     * Gets the value of the nameCanonical property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameCanonical() {
        return nameCanonical;
    }

    /**
     * Sets the value of the nameCanonical property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameCanonical(String value) {
        this.nameCanonical = value;
    }

    /**
     * Gets the value of the nameLabel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameLabel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameLabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNameLabel() {
        if (nameLabel == null) {
            nameLabel = new ArrayList<String>();
        }
        return this.nameLabel;
    }

    /**
     * Gets the value of the atomisedName property.
     * 
     * @return
     *     possible object is
     *     {@link AtomisedNameType }
     *     
     */
    public AtomisedNameType getAtomisedName() {
        return atomisedName;
    }

    /**
     * Sets the value of the atomisedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AtomisedNameType }
     *     
     */
    public void setAtomisedName(AtomisedNameType value) {
        this.atomisedName = value;
    }

    /**
     * Gets the value of the nameStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameStatus() {
        return nameStatus;
    }

    /**
     * Sets the value of the nameStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameStatus(String value) {
        this.nameStatus = value;
    }

}
