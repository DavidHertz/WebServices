package com.softtek.java.academy.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.softtek.java.academy.soap.domain.model.BankAccountRequest;
import com.softtek.java.academy.soap.domain.model.BankAccountResponse;
import com.softtek.java.academy.soap.service.BankService;

@Endpoint
public class BankEndpoint {

	private static final String NAME_SPACE = "http://www.academy-softtek.com/soap/bank";
	
	@Autowired
	private BankService bankService;

	@PayloadRoot(localPart = "accountDetailsRequest", namespace = NAME_SPACE)
	@ResponsePayload
	public BankAccountResponse getAccountDetails(@RequestPayload BankAccountRequest request) {
		final BankAccountResponse response = bankService.
				getAccountDetails(request.getNumberAccount(), request.getPassword());
		return response;
	}
}
