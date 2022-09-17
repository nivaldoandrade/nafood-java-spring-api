package com.nasa.nafood.api.exceptionhandler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiError {
	
	private LocalDateTime timestamp;
	
	private String message;

}
