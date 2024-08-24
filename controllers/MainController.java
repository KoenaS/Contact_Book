package com.interview.projects.controllerClasses;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.interview.projects.daoClasses.ContactDAOInterface;
import com.interview.projects.modelClasses.Contact;

@Controller
public class MainController {

	@Autowired
	private ContactDAOInterface contactDao;

	// Displaying all the available contacts
	@RequestMapping(value = "/")
	public ModelAndView showContactList(ModelAndView mv) {
		List<Contact> contactList = contactDao.list();
		mv.addObject("contactList", contactList);
		mv.setViewName("home");
		return mv;
	}

	// Adding a new contact
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView mv) {
		Contact newContact = new Contact();
		mv.addObject("contact", newContact);
		mv.setViewName("contact_form");
		return mv;
	}

	// Saving the new contact
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactDao.save(contact);
		return new ModelAndView("redirect:/");
	}

	// Updating the edited contact
	@RequestMapping(value = "/updateContact", method = RequestMethod.POST)
	public ModelAndView updateContact(@ModelAttribute Contact contact) {
		contactDao.update(contact);
		return new ModelAndView("redirect:/");
	}

	// Deleting contact
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDao.delete(contactId);
		return new ModelAndView("redirect:/");
	}

	// Editing an existing contact
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDao.get(contactId);
		ModelAndView model = new ModelAndView("update_contact_form");
		model.addObject("contact", contact);
		return model;
	}
}
