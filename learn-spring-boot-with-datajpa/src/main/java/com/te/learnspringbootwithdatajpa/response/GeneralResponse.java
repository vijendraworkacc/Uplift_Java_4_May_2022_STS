package com.te.learnspringbootwithdatajpa.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GeneralResponse {
	private String path;
	private HttpStatus status;
	private String error;
	private String message;
	private LocalDateTime timestamp = LocalDateTime.now();
	private Object data;

	public GeneralResponse(String path, HttpStatus status, String error, String message, Object data) {
		super();
		this.path = path;
		this.status = status;
		this.error = error;
		this.message = message;
		this.data = data;
	}
}
