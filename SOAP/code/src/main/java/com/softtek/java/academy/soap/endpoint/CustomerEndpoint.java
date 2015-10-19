package com.softtek.java.academy.soap.endpoint;

import org.jdom2.Element;
import org.jdom2.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.softtek.java.academy.soap.domain.model.Customer;
import com.softtek.java.academy.soap.service.CustomerService;

@Endpoint
public class CustomerEndpoint {

	private static final String NAME_SPACE = "http://www.academy-softtek.com/soap";
	
	@Autowired
	private CustomerService customerService;
	
	@PayloadRoot(namespace = NAME_SPACE, localPart = "getCustomerByIdRequest")
	@ResponsePayload
	public Element findCustomerById(@RequestPayload final Element request) {
		Element idElement = request.getChild("id");
		String id = idElement.getText();
		
		final Customer customerFound = customerService.findCustomerById(id);
		
		Element response = new Element("getCustomerByIdResponse");
		response.addNamespaceDeclaration(Namespace.getNamespace("tns", NAME_SPACE));
		
		Element customer = new Element("customer");
		
		Element customerId = new Element("id");		
		Element companyName = new Element("companyName");
		Element email = new Element("email");
		Element notes = new Element("notes");
		Element phone = new Element("phone");
		
		customerId.setText(customerFound.getId());
		companyName.setText(customerFound.getCompanyName());
		email.setText(customerFound.getEmail());
		notes.setText(customerFound.getNotes());
		phone.setText(customerFound.getPhone());
		
		customer.addContent(customerId);
		customer.addContent(companyName);
		customer.addContent(email);
		customer.addContent(notes);
		customer.addContent(phone);
		
		response.addContent(customer);
		
		return response;
	}
}
