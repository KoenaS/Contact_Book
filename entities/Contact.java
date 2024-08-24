package com.interview.projects.modelClasses;

public class Contact {
	private int contact_id;
	private String name;
	private String email;
	private String address;
	private String phone;

	public Contact(int contact_id, String name, String email, String address, String phone) {
		super();
		this.contact_id = contact_id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public Contact() {
		super();
	}

	public int getContact_id() {
		return contact_id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
