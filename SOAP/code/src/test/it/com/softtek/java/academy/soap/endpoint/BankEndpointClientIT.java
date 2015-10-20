package com.softtek.java.academy.soap.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.softtek.java.academy.soap.domain.model.BankAccountRequest;
import com.softtek.java.academy.soap.domain.model.BankAccountResponse;


@ContextConfiguration("classpath:client-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BankEndpointClientIT {
	
	@Autowired
	private WebServiceTemplate wsTemplate;
	
	@Test
	public void consumeBankService() {
		final BankAccountRequest request = new BankAccountRequest();
		request.setAccountNumber("abc");
		request.setPassword("123");
		
		final BankAccountResponse response = (BankAccountResponse) wsTemplate.marshalSendAndReceive(request);
		
		Assert.assertNotNull(response);
	}

}
