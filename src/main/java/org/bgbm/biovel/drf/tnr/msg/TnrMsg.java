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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tnrRequest">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="taxonName" type="{http://bgbm.org/biovel/drf/tnr/msg}taxonNameType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element ref="{http://bgbm.org/biovel/drf/tnr/msg}tnrResponse" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "", propOrder = {
    "query"
})
@XmlRootElement(name = "tnrMsg")
public class TnrMsg {

    @XmlElement(required = true)
    protected List<TnrMsg.Query> query;

    /**
     * Gets the value of the query property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the query property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TnrMsg.Query }
     * 
     * 
     */
    public List<TnrMsg.Query> getQuery() {
        if (query == null) {
            query = new ArrayList<TnrMsg.Query>();
        }
        return this.query;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="tnrRequest">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="taxonName" type="{http://bgbm.org/biovel/drf/tnr/msg}taxonNameType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element ref="{http://bgbm.org/biovel/drf/tnr/msg}tnrResponse" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tnrRequest",
        "tnrResponse"
    })
    public static class Query {

        @XmlElement(required = true)
        protected TnrMsg.Query.TnrRequest tnrRequest;
        @XmlElement(required = true)
        protected List<TnrResponse> tnrResponse;

        /**
         * Gets the value of the tnrRequest property.
         * 
         * @return
         *     possible object is
         *     {@link TnrMsg.Query.TnrRequest }
         *     
         */
        public TnrMsg.Query.TnrRequest getTnrRequest() {
            return tnrRequest;
        }

        /**
         * Sets the value of the tnrRequest property.
         * 
         * @param value
         *     allowed object is
         *     {@link TnrMsg.Query.TnrRequest }
         *     
         */
        public void setTnrRequest(TnrMsg.Query.TnrRequest value) {
            this.tnrRequest = value;
        }

        /**
         * Gets the value of the tnrResponse property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tnrResponse property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTnrResponse().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TnrResponse }
         * 
         * 
         */
        public List<TnrResponse> getTnrResponse() {
            if (tnrResponse == null) {
                tnrResponse = new ArrayList<TnrResponse>();
            }
            return this.tnrResponse;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="taxonName" type="{http://bgbm.org/biovel/drf/tnr/msg}taxonNameType"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "taxonName"
        })
        public static class TnrRequest {

            @XmlElement(required = true)
            protected TaxonNameType taxonName;

            /**
             * Gets the value of the taxonName property.
             * 
             * @return
             *     possible object is
             *     {@link TaxonNameType }
             *     
             */
            public TaxonNameType getTaxonName() {
                return taxonName;
            }

            /**
             * Sets the value of the taxonName property.
             * 
             * @param value
             *     allowed object is
             *     {@link TaxonNameType }
             *     
             */
            public void setTaxonName(TaxonNameType value) {
                this.taxonName = value;
            }

        }

    }

}
