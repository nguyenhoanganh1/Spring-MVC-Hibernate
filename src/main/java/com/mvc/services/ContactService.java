package com.mvc.services;

import java.util.List;

import com.mvc.entities.Contact;

public interface ContactService {
	 	public void addContact(Contact contact);
	 
	    public List<Contact> getAllContacts();
	 
	    public void deleteContact(Integer productId);
	 
	    public Contact getContact(int productid);
	 
	    public Contact updateContact(Contact contact);
}
