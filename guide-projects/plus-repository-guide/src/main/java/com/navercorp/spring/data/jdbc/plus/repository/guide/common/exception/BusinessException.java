package com.navercorp.spring.data.jdbc.plus.repository.guide.common.exception;


public class BusinessException extends RuntimeException{
	private final ErrorCode errorCode;

	public BusinessException(ErrorCode errorCode){
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
