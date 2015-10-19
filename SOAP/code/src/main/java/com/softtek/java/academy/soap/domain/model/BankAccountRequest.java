package com.softtek.java.academy.soap.domain.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "accountDetailsRequest", namespace = "http://www.academy-softtek.com/soap/bank")
@XmlType
public class BankAccountRequest {

	@XmlElement(required = true)
	private String numberAccount;

	@XmlElement(required = true)
	private String password;

	/**
	 * @return the numberAccount
	 */
	public String getNumberAccount() {
		return numberAccount;
	}

	/**
	 * @param numberAccount
	 *            the numberAccount to set
	 */
	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
