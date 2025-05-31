package com.navercorp.spring.data.jdbc.plus.repository.guide.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

	INVALID_ADDRESS(400, "C_001","Address Cannot be blank");

	private final int status;
	private final String code;
	private final String message;

	ErrorCode(int status, String code, String message){
		this.status = status;
		this.code = code;
		this.message = message;
	}

}
