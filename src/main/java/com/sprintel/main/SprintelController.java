package com.sprintel.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SprintelController {

	private static final Logger logger = LoggerFactory.getLogger(SprintelController.class);
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("hello")
    public String sayHello() throws JsonProcessingException{
    	
    	Status status = new Status();
		LocalDateTime now = LocalDateTime.now();
		ObjectMapper mapper = new ObjectMapper();
		status.setStatusCode("000");
		status.setStatusDescription("Success");
		status.setStatusDateTime(dtf.format(now));
		status.setStatusVersion("1.0.0");
		String responseAsJson = mapper.writeValueAsString(status);
		logger.info("SpringBoot+OpenShit:::RequestDateTime[{}]:::Payload[{}]",dtf.format(now), responseAsJson);
        return (responseAsJson);
    }
    
    @RequestMapping("api/v1/hello")
    public String sayHello2() throws JsonProcessingException{
    	
    	Status status = new Status();
		LocalDateTime now = LocalDateTime.now();
		ObjectMapper mapper = new ObjectMapper();
		status.setStatusCode("000");
		status.setStatusDescription("Success");
		status.setStatusDateTime(dtf.format(now));
		status.setStatusVersion("1.0.1");
		String responseAsJson = mapper.writeValueAsString(status);
		logger.info("SpringBoot+OpenShit:::RequestDateTime[{}]:::Payload[{}]",dtf.format(now), responseAsJson);
        return (responseAsJson);
    }
}