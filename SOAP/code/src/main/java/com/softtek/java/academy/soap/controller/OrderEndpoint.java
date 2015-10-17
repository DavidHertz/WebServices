package com.softtek.java.academy.soap.controller;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.softtek.java.academy.soap.domain.model.ClientDataRequest;
import com.softtek.java.academy.soap.domain.model.ClientDataResponse;
import com.softtek.java.academy.soap.service.OrderService;

@Endpoint
public class OrderEndpoint {

	@Autowired
	private OrderService orderService;
	
	@PayloadRoot(localPart="clientDataRequest", namespace="http://www.xpadro.spring.samples.com/orders")
	public @ResponsePayload ClientDataResponse order(ClientDataRequest request) throws DatatypeConfigurationException {
		return orderService.order(request.getClientId(), request.getProduct(), request.getQuantity());
	}
}
