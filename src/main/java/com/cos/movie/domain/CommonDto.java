package com.cos.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonDto<T> {
	private int statusCode;
	private String msg;
	private T data;
	
	public CommonDto(int statusCode, String msg) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
	}
	public CommonDto(int statusCode, String msg, T data) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
		this.data = data;
	}
	
}

