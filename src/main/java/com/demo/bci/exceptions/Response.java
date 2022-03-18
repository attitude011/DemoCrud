package com.demo.bci.exceptions;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Response {

	public Response() {
	}

	public Response(Date timestamp, String message, int respondeCode, String status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.respondeCode = respondeCode;
		this.status = status;

	}

	private Date timestamp;
	private String message;
	private int respondeCode;
	private String status;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRespondeCode() {
		return respondeCode;
	}

	public void setRespondeCode(int respondeCode) {
		this.respondeCode = respondeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
