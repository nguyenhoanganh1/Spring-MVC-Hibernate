package com.mvc.dao;

import java.util.List;

import com.mvc.entities.Contact;

public interface ContactDAO {
		public void addContact(Contact contact);
	 
	    public List<Contact> getAllContacts();
	 
	    public void deleteContact(Integer id);
	 
	    public Contact updateContact(Contact contact);
	 
	    public Contact getContact(int id);
}
