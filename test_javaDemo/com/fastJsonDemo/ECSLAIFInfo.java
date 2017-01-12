package com.fastJsonDemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ECSLAIFInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ECSLAIFInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BankClntNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccDsc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FactHous" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZCardFlg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EffDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HHPLEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HPLEINT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Needchgacc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HealthIndicator" type="{http://ECS/StartECS_WS.tws}HealthIndicator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ECSLAIFInfo", propOrder = {
    "bankClntNum",
    "bankAccDsc",
    "factHous",
    "bankName",
    "zCardFlg",
    "bankAccNum",
    "effDate",
    "toamount",
    "hhpleamt",
    "hpleint",
    "needchgacc",
    "healthIndicator"
})
public class ECSLAIFInfo {

    @XmlElement(name = "BankClntNum")
    protected String bankClntNum;
    @XmlElement(name = "BankAccDsc")
    protected String bankAccDsc;
    @XmlElement(name = "FactHous")
    protected String factHous;
    @XmlElement(name = "BankName")
    protected String bankName;
    @XmlElement(name = "ZCardFlg")
    protected String zCardFlg;
    @XmlElement(name = "BankAccNum")
    protected String bankAccNum;
    @XmlElement(name = "EffDate")
    protected String effDate;
    @XmlElement(name = "TOAMOUNT")
    protected String toamount;
    @XmlElement(name = "HHPLEAMT")
    protected String hhpleamt;
    @XmlElement(name = "HPLEINT")
    protected String hpleint;
    @XmlElement(name = "Needchgacc")
    protected String needchgacc;
    @XmlElement(name = "HealthIndicator")
    protected HealthIndicator healthIndicator;

    /**
     * Gets the value of the bankClntNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankClntNum() {
        return bankClntNum;
    }

    /**
     * Sets the value of the bankClntNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankClntNum(String value) {
        this.bankClntNum = value;
    }

    /**
     * Gets the value of the bankAccDsc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccDsc() {
        return bankAccDsc;
    }

    /**
     * Sets the value of the bankAccDsc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccDsc(String value) {
        this.bankAccDsc = value;
    }

    /**
     * Gets the value of the factHous property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactHous() {
        return factHous;
    }

    /**
     * Sets the value of the factHous property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactHous(String value) {
        this.factHous = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the zCardFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZCardFlg() {
        return zCardFlg;
    }

    /**
     * Sets the value of the zCardFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZCardFlg(String value) {
        this.zCardFlg = value;
    }

    /**
     * Gets the value of the bankAccNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccNum() {
        return bankAccNum;
    }

    /**
     * Sets the value of the bankAccNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccNum(String value) {
        this.bankAccNum = value;
    }

    /**
     * Gets the value of the effDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffDate() {
        return effDate;
    }

    /**
     * Sets the value of the effDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffDate(String value) {
        this.effDate = value;
    }

    /**
     * Gets the value of the toamount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOAMOUNT() {
        return toamount;
    }

    /**
     * Sets the value of the toamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOAMOUNT(String value) {
        this.toamount = value;
    }

    /**
     * Gets the value of the hhpleamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHHPLEAMT() {
        return hhpleamt;
    }

    /**
     * Sets the value of the hhpleamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHHPLEAMT(String value) {
        this.hhpleamt = value;
    }

    /**
     * Gets the value of the hpleint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPLEINT() {
        return hpleint;
    }

    /**
     * Sets the value of the hpleint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPLEINT(String value) {
        this.hpleint = value;
    }

    /**
     * Gets the value of the needchgacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeedchgacc() {
        return needchgacc;
    }

    /**
     * Sets the value of the needchgacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeedchgacc(String value) {
        this.needchgacc = value;
    }

    /**
     * Gets the value of the healthIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link HealthIndicator }
     *     
     */
    public HealthIndicator getHealthIndicator() {
        return healthIndicator;
    }

    /**
     * Sets the value of the healthIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthIndicator }
     *     
     */
    public void setHealthIndicator(HealthIndicator value) {
        this.healthIndicator = value;
    }

}

