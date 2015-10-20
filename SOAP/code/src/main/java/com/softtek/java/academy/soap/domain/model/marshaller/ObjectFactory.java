package com.softtek.java.academy.soap.domain.model.marshaller;

import javax.xml.bind.annotation.XmlRegistry;

import com.softtek.java.academy.soap.domain.model.BankAccountRequest;
import com.softtek.java.academy.soap.domain.model.BankAccountResponse;

/**
 * Class to marshal XML responses for WebServiceTemplate
 * @author JAHV
 *
 */
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
