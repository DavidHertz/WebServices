package com.softtek.java.academy.soap.service;

import org.springframework.stereotype.Service;

import com.softtek.java.academy.soap.domain.model.BankAccountResponse;

@Service
public class BankService {

	public BankAccountResponse getAccountDetails(final String account, final String password) {
		final BankAccountResponse response = new BankAccountResponse();
		
		response.setAccountNumber(account);
		response.setAmount(100.00);
		response.setOwnerFirstName("jahv");
		response.setOwnerLastName("hv");
		
		return response;
	}
}
