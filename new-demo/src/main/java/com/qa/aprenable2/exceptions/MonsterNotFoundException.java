package com.qa.aprenable2.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Monster does not exist with that ID")
public class MonsterNotFoundException extends NoSuchElementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}