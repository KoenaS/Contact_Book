package com.interview.projects.daoClasses;

import java.util.List;

import com.interview.projects.modelClasses.Contact;

public interface ContactDAOInterface {
	
	public int save(Contact contact);

	public boolean update(Contact contact);

	public boolean delete(int id);

	public Contact get(int id);

	public List<Contact> list();
}
