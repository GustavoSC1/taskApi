package com.gustavo.taskApi.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;	 
	
	public FieldMessage() {
		
	}

	public FieldMessage(String fildName, String message) {
		super();
		this.fieldName = fildName;
		this.message = message;
	}	

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fildName) {
		this.fieldName = fildName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
