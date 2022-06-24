package com.mvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.ContactDAO;
import com.mvc.entities.Contact;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	
	@Autowired
    private ContactDAO contactDAO;
    

	public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }
	
	@Override
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		 return contactDAO.getAllContacts();
	}

	@Override
	public void deleteContact(Integer productId) {
		contactDAO.deleteContact(productId);
		
	}

	@Override
	public Contact getContact(int productid) {
		return contactDAO.getContact(productid);
	}

	@Override
	public Contact updateContact(Contact contact) {
		 return contactDAO.updateContact(contact);
	}

}
