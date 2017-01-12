package com.fastJsonDemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ECSAppInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ECSAppInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AppNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClntNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SurName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Chdrcoy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChdrNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FullChdrnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AppStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ECSAppInfo", propOrder = { "appNum", "clntNum", "surName", "chdrcoy", "branch", "chdrNum",
		"fullChdrnum", "appDate", "appType", "appStatus" })
public class ECSAppInfo {

	@XmlElement(name = "AppNum")
	protected String appNum;
	@XmlElement(name = "ClntNum")
	protected String clntNum;
	@XmlElement(name = "SurName")
	protected String surName;
	@XmlElement(name = "Chdrcoy")
	protected String chdrcoy;
	@XmlElement(name = "Branch")
	protected String branch;
	@XmlElement(name = "ChdrNum")
	protected String chdrNum;
	@XmlElement(name = "FullChdrnum")
	protected String fullChdrnum;
	@XmlElement(name = "AppDate")
	protected String appDate;
	@XmlElement(name = "AppType")
	protected String appType;
	@XmlElement(name = "AppStatus")
	protected String appStatus;

	/**
	 * Gets the value of the appNum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAppNum() {
		return appNum;
	}

	/**
	 * Sets the value of the appNum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAppNum(String value) {
		this.appNum = value;
	}

	/**
	 * Gets the value of the clntNum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClntNum() {
		return clntNum;
	}

	/**
	 * Sets the value of the clntNum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClntNum(String value) {
		this.clntNum = value;
	}

	/**
	 * Gets the value of the surName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * Sets the value of the surName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSurName(String value) {
		this.surName = value;
	}

	/**
	 * Gets the value of the chdrcoy property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChdrcoy() {
		return chdrcoy;
	}

	/**
	 * Sets the value of the chdrcoy property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setChdrcoy(String value) {
		this.chdrcoy = value;
	}

	/**
	 * Gets the value of the branch property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * Sets the value of the branch property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBranch(String value) {
		this.branch = value;
	}

	/**
	 * Gets the value of the chdrNum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChdrNum() {
		return chdrNum;
	}

	/**
	 * Sets the value of the chdrNum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setChdrNum(String value) {
		this.chdrNum = value;
	}

	/**
	 * Gets the value of the fullChdrnum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFullChdrnum() {
		return fullChdrnum;
	}

	/**
	 * Sets the value of the fullChdrnum property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFullChdrnum(String value) {
		this.fullChdrnum = value;
	}

	/**
	 * Gets the value of the appDate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * Sets the value of the appDate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAppDate(String value) {
		this.appDate = value;
	}

	/**
	 * Gets the value of the appType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * Sets the value of the appType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAppType(String value) {
		this.appType = value;
	}

	/**
	 * Gets the value of the appStatus property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAppStatus() {
		return appStatus;
	}

	/**
	 * Sets the value of the appStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAppStatus(String value) {
		this.appStatus = value;
	}

}
