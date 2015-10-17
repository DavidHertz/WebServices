package com.softtek.java.academy.soap.domain.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name = "clientDataResponse")
public class ClientDataResponse {

	@XmlAttribute(required = true)
	private int amount;

	@XmlAttribute(required = true)
	private String confirmationId;

	@XmlAttribute(required = true)
	private XMLGregorianCalendar orderDate;

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the confirmationId
	 */
	public String getConfirmationId() {
		return confirmationId;
	}

	/**
	 * @param confirmationId
	 *            the confirmationId to set
	 */
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	/**
	 * @return the orderDate
	 */
	public XMLGregorianCalendar getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(XMLGregorianCalendar orderDate) {
		this.orderDate = orderDate;
	}

}
