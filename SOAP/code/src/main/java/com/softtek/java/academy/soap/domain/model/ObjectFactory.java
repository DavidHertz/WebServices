package com.softtek.java.academy.soap.domain.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {}
	
	public BankAccountRequest createBankAccountRequest() {
		return new BankAccountRequest();
	}
	
	public BankAccountResponse createBankAccountResponse() {
		return new BankAccountResponse();
	}
}
