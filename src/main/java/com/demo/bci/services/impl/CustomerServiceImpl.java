package com.demo.bci.services.impl;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bci.dao.CustomerRepository;
import com.demo.bci.entity.EntityUpdate;
import com.demo.bci.entity.EntityUser;
import com.demo.bci.entity.InsertEntity;
import com.demo.bci.services.CustomerServices;
import com.demo.bci.to.Convert;

@Service
public class CustomerServiceImpl implements CustomerServices {

	@Autowired
	CustomerRepository customerRepository;

	Convert converted = new Convert();

	static final String UPDATED = "record updated";
	static final String NOT_UPDATED = "record not updated, please look at log";

	// Returning one entity by ID
	@Override
	public InsertEntity getRecordById(long id) {
		return customerRepository.findById(id);
	}

	// Insert user
	@Override
	public Object insertRecord(EntityUser table) {
		if (!isValid(table.getEmail())) {
			converted.setMessage(" Bad request parameter for email");
			converted.setSuccess(false);
			return converted;
		}
		return customerRepository.insert(table);
	}

	// Updete
	@Override
	public Convert updateRecord(EntityUpdate records) {
		boolean resultUpdate = customerRepository.updateRecord(records);
		if (resultUpdate) {
			converted.setMessage(UPDATED);
			converted.setSuccess(true);

		} else {
			converted.setMessage(NOT_UPDATED);
			converted.setSuccess(false);
		}
		return converted;
	}

	// Email format validator
	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
