package net.javaguiders.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resoursename;
	private String fieldname;
	private Object fieldvalue;
	public ResourseNotFoundException(String resoursename, String fieldname, Object fieldvalue) {
		super(String.format("%s not found with %s : '%s'",resoursename,fieldname,fieldvalue));
		this.resoursename = resoursename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
	public String getResoursename() {
		return resoursename;
	}
	
	public String getFieldname() {
		return fieldname;
	}
	public Object getFieldvalue() {
		return fieldvalue;
	}
	
	

}
