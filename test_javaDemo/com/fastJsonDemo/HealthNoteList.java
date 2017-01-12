package com.fastJsonDemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for healthNoteList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="healthNoteList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QuestionTextOw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseCodeOw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseTextOw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuestionTextLf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseCodeLf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseTextLf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "healthNoteList", propOrder = {
    "questionTextOw",
    "responseCodeOw",
    "responseTextOw",
    "questionTextLf",
    "responseCodeLf",
    "responseTextLf"
})
public class HealthNoteList {

    @XmlElement(name = "QuestionTextOw")
    protected String questionTextOw;
    @XmlElement(name = "ResponseCodeOw")
    protected String responseCodeOw;
    @XmlElement(name = "ResponseTextOw")
    protected String responseTextOw;
    @XmlElement(name = "QuestionTextLf")
    protected String questionTextLf;
    @XmlElement(name = "ResponseCodeLf")
    protected String responseCodeLf;
    @XmlElement(name = "ResponseTextLf")
    protected String responseTextLf;

    /**
     * Gets the value of the questionTextOw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestionTextOw() {
        return questionTextOw;
    }

    /**
     * Sets the value of the questionTextOw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestionTextOw(String value) {
        this.questionTextOw = value;
    }

    /**
     * Gets the value of the responseCodeOw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCodeOw() {
        return responseCodeOw;
    }

    /**
     * Sets the value of the responseCodeOw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCodeOw(String value) {
        this.responseCodeOw = value;
    }

    /**
     * Gets the value of the responseTextOw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseTextOw() {
        return responseTextOw;
    }

    /**
     * Sets the value of the responseTextOw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseTextOw(String value) {
        this.responseTextOw = value;
    }

    /**
     * Gets the value of the questionTextLf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestionTextLf() {
        return questionTextLf;
    }

    /**
     * Sets the value of the questionTextLf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestionTextLf(String value) {
        this.questionTextLf = value;
    }

    /**
     * Gets the value of the responseCodeLf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCodeLf() {
        return responseCodeLf;
    }

    /**
     * Sets the value of the responseCodeLf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCodeLf(String value) {
        this.responseCodeLf = value;
    }

    /**
     * Gets the value of the responseTextLf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseTextLf() {
        return responseTextLf;
    }

    /**
     * Sets the value of the responseTextLf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseTextLf(String value) {
        this.responseTextLf = value;
    }

}
