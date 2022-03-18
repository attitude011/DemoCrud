package com.demo.bci.to;

import org.springframework.stereotype.Component;

@Component
public class Convert {

	public Convert() {
	}

	public Convert(String message, Boolean success) {
		super();
		this.message = message;
		this.success = success;

	}

	String message;
	Boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
