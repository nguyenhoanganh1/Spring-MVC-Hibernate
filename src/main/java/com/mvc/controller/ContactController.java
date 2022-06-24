package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entities.Contact;
import com.mvc.services.ContactService;

@Controller
public class ContactController {

	
	@Autowired
	private ContactService contactService;
	

	@RequestMapping("/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Contact> list = contactService.getAllContacts();
        model.addObject("contacts", list);
        model.setViewName("table");
        return model;
    }
	
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("form", newContact);
		model.setViewName("form");
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView newContact(ModelAndView model , @ModelAttribute Contact form) {
		Contact pro = contactService.getContact(form.getContact_id());
		if (pro == null) {
			contactService.addContact(form);
        } else {
        	contactService.updateContact(form);
        }
		return new ModelAndView("redirect:/");

    }
	
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public ModelAndView editContact(ModelAndView model,@PathVariable("id") int productId) {
	        Contact employee = contactService.getContact(productId);
	        model.addObject("form", employee);
	        model.setViewName("form");

	        return model;
	    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(ModelAndView model,@PathVariable("id") int productId) {
        contactService.deleteContact(productId);
		return new ModelAndView("redirect:/");
    }
}
