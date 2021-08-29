package org.sid.cinema.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;
@ControllerAdvice
public class ApiExceptinHandling extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestExceptin (ApiRequestException e){
		HttpStatus badRequest=HttpStatus.BANDWIDTH_LIMIT_EXCEEDED;
		ApiException apiException = new ApiException( 
				e.getMessage(),
				e,
				badRequest,
				ZonedDateTime.now(ZoneId.of("Z"))
			);
		return new ResponseEntity<>(apiException,badRequest);
	}

	
}
