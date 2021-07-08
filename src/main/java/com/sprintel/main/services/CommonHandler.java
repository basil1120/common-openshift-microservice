package com.sprintel.main.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintel.main.Status;

@Service
public class CommonHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonHandler.class);
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public String getMethod() {
		String responseAsJson = null;
    	Status status = new Status();
		LocalDateTime now = LocalDateTime.now();
		ObjectMapper mapper = new ObjectMapper();
		try {
			status.setStatusCode("000");
			status.setStatusDescription("Success");
			status.setStatusDateTime(dtf.format(now));
			status.setStatusVersion("1.0.1");
			responseAsJson = mapper.writeValueAsString(status);
			logger.info(":::RequestDateTime[{}]:::Payload[{}]",dtf.format(now), responseAsJson);
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return responseAsJson;
	}
	
	public Status getMethod(String number) {
    	Status status = new Status();
		LocalDateTime now = LocalDateTime.now();
		
		status.setStatusCode("000");
		status.setStatusDescription("Success");
		status.setStatusDateTime(dtf.format(now));
		status.setStatusVersion("1.0.2");
		
		return status;
	}
	
	public Status postMethod() {
    	Status status = new Status();
		LocalDateTime now = LocalDateTime.now();
		
		status.setStatusCode("000");
		status.setStatusDescription("Success");
		status.setStatusDateTime(dtf.format(now));
		status.setStatusVersion("1.0.3");
		
		return status;
	}

}
