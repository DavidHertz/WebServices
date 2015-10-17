package com.softtek.java.academy.soap.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.softtek.java.academy.soap.domain.model.ClientDataResponse;

@Service
public class OrderService {

	public ClientDataResponse order(String clientId, String productId, int quantity) throws DatatypeConfigurationException {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 9, 26);		
		
		ClientDataResponse response = new ClientDataResponse();
		response.setConfirmationId("GHKG34L");
		response.setAmount(12);
		response.setOrderDate(convertDate(cal.getTime()));
		
		return response;
	}
	
	private XMLGregorianCalendar convertDate(Date serviceDate) throws DatatypeConfigurationException{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(serviceDate);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}
}
