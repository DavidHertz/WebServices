package com.softtek.java.academy.soap.controller;

import javax.xml.transform.Source;

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
	
	@Test
	public void testValidOrderRequest() {
		Source requestPayload = new StringSource(
			      "<clientDataRequest xmlns='http://www.xpadro.spring.samples.com/orders' " +
			        "clientId='123' productId='XA-55' quantity='5'/>");
		
		Source responsePayload = new StringSource(
			      "<clientDataResponse xmlns='http://www.xpadro.spring.samples.com/orders' " +
			        "amount='12' confirmationId='GHKG34L' orderDate='2013-10-26+02:00'/>");
		
		RequestCreator creator = RequestCreators.withPayload(requestPayload);
		
		mockWebServiceClient = MockWebServiceClient.createClient(applicationContext);
		mockWebServiceClient.sendRequest(creator).andExpect(ResponseMatchers.payload(responsePayload));
	}
}
