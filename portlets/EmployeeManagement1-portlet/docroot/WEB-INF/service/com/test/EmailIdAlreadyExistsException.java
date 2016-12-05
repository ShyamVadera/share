package com.knowarth.employee.customExceptions;

public class EmailIdAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	 public EmailIdAlreadyExistsException()
	 {
	 }

	 public EmailIdAlreadyExistsException(String message)
	 {
	  super(message);
	 }

	 public EmailIdAlreadyExistsException(Throwable cause)
	 {
	  super(cause);

	 }

	 public EmailIdAlreadyExistsException(String message, Throwable cause)

	 {
	  super(message, cause);
	 }

	 public EmailIdAlreadyExistsException(String message, Throwable cause,
	   boolean enableSuppression, boolean writableStackTrace)
	 {
	  super(message, cause, enableSuppression, writableStackTrace);

	 }

	}

