package com.captain.orderService.external.decoder;

import java.io.IOException;

import com.captain.orderService.exception.CustomException;
import com.captain.orderService.external.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String st, Response response) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		log.info("::{}", response.request().url());
		log.info("::{}", response.request().headers());
		
		try {
			ErrorResponse errorResponse = 
					mapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			
			return new CustomException(errorResponse.getErrorMessage(), response.status(), errorResponse.getErrorCode());
			
		} catch (IOException e) {
			return new CustomException("Internal Server Error", 500, "INTERNAL_SERVER_ERROR");
		}
	}

}
