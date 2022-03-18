package com.demo.bci.entity;

import org.springframework.stereotype.Component;

@Component
public class CustomerEntity {

	private Long id;
	private String first_name;
	private String last_name;
	private String city;
	private String address;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(Long id, String first_name, String last_name, String city, String address) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.address = address;

	}

	public CustomerEntity(String first_name, String last_name, String city, String address) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.address = address;

	}

	public CustomerEntity(Long id, String first_name, String last_name) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;

	}

	public CustomerEntity(Long id, String first_name) {
		super();
		this.id = id;
		this.first_name = first_name;

	}

	public CustomerEntity(Long id) {
		super();
		this.id = id;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Table [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", city=" + city
				+ ", address=" + address + "]";
	}

}
