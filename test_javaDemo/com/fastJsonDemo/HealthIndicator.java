package com.fastJsonDemo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HealthIndicator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HealthIndicator">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FormId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cownnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Lifcnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="covrArrayList" type="{http://ECS/StartECS_WS.tws}ArrayOf_covrArrayList" minOccurs="0"/>
 *         &lt;element name="TransExeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransExeTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialTxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sumin" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="healthNoteList" type="{http://ECS/StartECS_WS.tws}ArrayOf_healthNoteList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HealthIndicator", propOrder = {
    "formId",
    "cownnum",
    "lifcnum",
    "covrArrayList",
    "transExeDate",
    "transExeTime",
    "specialTxt",
    "sumin",
    "healthNoteList"
})
public class HealthIndicator {

    @XmlElement(name = "FormId")
    protected String formId;
    @XmlElement(name = "Cownnum")
    protected String cownnum;
    @XmlElement(name = "Lifcnum")
    protected String lifcnum;
    protected ArrayOfCovrArrayList covrArrayList;
    @XmlElement(name = "TransExeDate")
    protected String transExeDate;
    @XmlElement(name = "TransExeTime")
    protected String transExeTime;
    @XmlElement(name = "SpecialTxt")
    protected String specialTxt;
    @XmlElement(name = "Sumin")
    protected Double sumin;
    protected ArrayOfHealthNoteList healthNoteList;

    /**
     * Gets the value of the formId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormId() {
        return formId;
    }

    /**
     * Sets the value of the formId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormId(String value) {
        this.formId = value;
    }

    /**
     * Gets the value of the cownnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCownnum() {
        return cownnum;
    }

    /**
     * Sets the value of the cownnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCownnum(String value) {
        this.cownnum = value;
    }

    /**
     * Gets the value of the lifcnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLifcnum() {
        return lifcnum;
    }

    /**
     * Sets the value of the lifcnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLifcnum(String value) {
        this.lifcnum = value;
    }

    /**
     * Gets the value of the covrArrayList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCovrArrayList }
     *     
     */
    public ArrayOfCovrArrayList getCovrArrayList() {
        return covrArrayList;
    }

    /**
     * Sets the value of the covrArrayList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCovrArrayList }
     *     
     */
    public void setCovrArrayList(ArrayOfCovrArrayList value) {
        this.covrArrayList = value;
    }

    /**
     * Gets the value of the transExeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransExeDate() {
        return transExeDate;
    }

    /**
     * Sets the value of the transExeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransExeDate(String value) {
        this.transExeDate = value;
    }

    /**
     * Gets the value of the transExeTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransExeTime() {
        return transExeTime;
    }

    /**
     * Sets the value of the transExeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransExeTime(String value) {
        this.transExeTime = value;
    }

    /**
     * Gets the value of the specialTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialTxt() {
        return specialTxt;
    }

    /**
     * Sets the value of the specialTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialTxt(String value) {
        this.specialTxt = value;
    }

    /**
     * Gets the value of the sumin property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSumin() {
        return sumin;
    }

    /**
     * Sets the value of the sumin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSumin(Double value) {
        this.sumin = value;
    }

    /**
     * Gets the value of the healthNoteList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHealthNoteList }
     *     
     */
    public ArrayOfHealthNoteList getHealthNoteList() {
        return healthNoteList;
    }

    /**
     * Sets the value of the healthNoteList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHealthNoteList }
     *     
     */
    public void setHealthNoteList(ArrayOfHealthNoteList value) {
        this.healthNoteList = value;
    }

}
