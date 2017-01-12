package com.fastJsonDemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for covrArrayList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="covrArrayList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Life" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Covrage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Crtable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sumins" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ZBINSTPREM" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CrtableDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Raflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "covrArrayList", propOrder = {
    "life",
    "covrage",
    "rider",
    "crtable",
    "sumins",
    "zbinstprem",
    "crtableDesc",
    "raflag"
})
public class CovrArrayList {

    @XmlElement(name = "Life")
    protected String life;
    @XmlElement(name = "Covrage")
    protected String covrage;
    @XmlElement(name = "Rider")
    protected String rider;
    @XmlElement(name = "Crtable")
    protected String crtable;
    @XmlElement(name = "Sumins")
    protected Double sumins;
    @XmlElement(name = "ZBINSTPREM")
    protected Double zbinstprem;
    @XmlElement(name = "CrtableDesc")
    protected String crtableDesc;
    @XmlElement(name = "Raflag")
    protected String raflag;

    /**
     * Gets the value of the life property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLife() {
        return life;
    }

    /**
     * Sets the value of the life property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLife(String value) {
        this.life = value;
    }

    /**
     * Gets the value of the covrage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCovrage() {
        return covrage;
    }

    /**
     * Sets the value of the covrage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCovrage(String value) {
        this.covrage = value;
    }

    /**
     * Gets the value of the rider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRider() {
        return rider;
    }

    /**
     * Sets the value of the rider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRider(String value) {
        this.rider = value;
    }

    /**
     * Gets the value of the crtable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrtable() {
        return crtable;
    }

    /**
     * Sets the value of the crtable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrtable(String value) {
        this.crtable = value;
    }

    /**
     * Gets the value of the sumins property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSumins() {
        return sumins;
    }

    /**
     * Sets the value of the sumins property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSumins(Double value) {
        this.sumins = value;
    }

    /**
     * Gets the value of the zbinstprem property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getZBINSTPREM() {
        return zbinstprem;
    }

    /**
     * Sets the value of the zbinstprem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setZBINSTPREM(Double value) {
        this.zbinstprem = value;
    }

    /**
     * Gets the value of the crtableDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrtableDesc() {
        return crtableDesc;
    }

    /**
     * Sets the value of the crtableDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrtableDesc(String value) {
        this.crtableDesc = value;
    }

    /**
     * Gets the value of the raflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaflag() {
        return raflag;
    }

    /**
     * Sets the value of the raflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaflag(String value) {
        this.raflag = value;
    }

}
