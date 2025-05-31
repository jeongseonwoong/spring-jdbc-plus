package com.navercorp.spring.data.jdbc.plus.repository.guide.common.exception;

public class InvalidValueException extends BusinessException{

	public InvalidValueException(ErrorCode errorCode) {
		super(errorCode);
	}
}
