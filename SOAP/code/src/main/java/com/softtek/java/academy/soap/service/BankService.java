package com.softtek.java.academy.soap.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.softtek.java.academy.soap.domain.model.BankAccountResponse;

@Service
public class BankService {
	
	private Map<String, BankAccountResponse> users = new HashMap<String, BankAccountResponse>();
	
	public BankService() {
		final BankAccountResponse user1 = new BankAccountResponse();
		user1.setAccountNumber("030889");
		user1.setAmount(1000.00);
		user1.setOwnerFirstName("Jose Antonio");
		user1.setOwnerLastName("Hernandez Vazquez");
		user1.setPassword("abc");
		users.put(user1.getAccountNumber(), user1);
	}

	public BankAccountResponse getAccountDetails(final String account, final String password) {
		final BankAccountResponse user = users.get(account);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
