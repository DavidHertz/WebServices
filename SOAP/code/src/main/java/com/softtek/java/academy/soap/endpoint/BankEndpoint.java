package com.softtek.java.academy.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.softtek.java.academy.soap.domain.model.BankAccountRequest;
import com.softtek.java.academy.soap.domain.model.BankAccountResponse;
import com.softtek.java.academy.soap.service.BankService;

/**
 * This marks the class as a special sort of @Component, suitable for handling
 * XML messages in Spring-WS, and also making it eligible for suitable for
 * component scanning.
 */
@Endpoint
public class BankEndpoint {

	private static final String NAME_SPACE = "http://www.academy-softtek.com/soap/bank";

	@Autowired
	private BankService bankService;

	/**
	 * The @PayloadRoot annotation tells Spring-WS that the request method is
	 * suitable for handling XML messages.
	 * 
	 * The @RequestPayload annotation indicates that the parameter should be
	 * mapped to the payload of the request message.
	 * 
	 * @ResponsePayload, indicating that the return value is used as the payload
	 * of the response message.
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(localPart = "accountDetailsRequest", namespace = NAME_SPACE)
	@ResponsePayload
	public BankAccountResponse getAccountDetails(
			@RequestPayload BankAccountRequest request) {
		final BankAccountResponse response = bankService.getAccountDetails(
				request.getAccountNumber(), request.getPassword());
		return response;
	}
}
