package com.softtek.java.academy.soap.controller;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.RequestCreator;
import org.springframework.ws.test.server.RequestCreators;
import org.springframework.ws.test.server.ResponseMatchers;
import org.springframework.xml.transform.StringSource;

@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderEndPointTest {

	@Autowired
	private ApplicationContext applicationContext;

	private MockWebServiceClient mockWebServiceClient;
	
	@Before
	public void setUp() {
		mockWebServiceClient = MockWebServiceClient.createClient(applicationContext);
	}

	@Test
	public void testValidOrderRequest() {
		final Source requestPayload = new StringSource(
				"<bank:accountDetailsRequest xmlns:bank='http://www.academy-softtek.com/soap/bank'>"
						+ "<numberAccount>abc</numberAccount>"
						+ "<password>1234</password>"
				+ "</bank:accountDetailsRequest>");

		final Source responsePayload = new StringSource(
				"<bank:accountDetailsResponse xmlns:bank='http://www.academy-softtek.com/soap/bank'>"
						+ "<accountNumber>abc</accountNumber>"
						+ "<ownerFirstName>jahv</ownerFirstName>"
						+ "<ownerLastName>hv</ownerLastName>"
						+ "<amount>100.0</amount>"
				+ "</bank:accountDetailsResponse>");

		final RequestCreator creator = RequestCreators.withPayload(requestPayload);
		
		mockWebServiceClient.sendRequest(creator).andExpect(ResponseMatchers.payload(responsePayload));
	}
	
}
