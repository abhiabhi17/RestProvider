package com.example.exceptions;

import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


import org.springframework.http.HttpStatus;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse {
	
	private Integer Statuscode;
	private String StatusMessage;
	private final HttpStatus httpStatus = null;
	public Integer getStatuscode() {
		return Statuscode;
	}
	public void setStatuscode(Integer statuscode) {
		Statuscode = statuscode;
	}
	public String getStatusMessage() {
		return StatusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		StatusMessage = statusMessage;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	@Override
	public String toString() {
		return "ErrorResponse [Statuscode=" + Statuscode + ", StatusMessage=" + StatusMessage + ", httpStatus="
				+ httpStatus + "]";
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
