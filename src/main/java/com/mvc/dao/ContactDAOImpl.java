package com.mvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.entities.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void addContact(Contact employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Contact").list();
	}
	
	@Override
	public void deleteContact(Integer productId) {
		Contact employee = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, productId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }

	}

	@Override
	public Contact updateContact(Contact contact) {
		sessionFactory.getCurrentSession().update(contact);
        return contact;
	}

	@Override
	public Contact getContact(int contactid) {
		return (Contact) sessionFactory.getCurrentSession().get(
				Contact.class, contactid);
	}

}
