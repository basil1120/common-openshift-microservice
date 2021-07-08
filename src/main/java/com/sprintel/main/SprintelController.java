package com.sprintel.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintel.main.services.CommonHandler;

@RestController
public class SprintelController {

	private static final Logger logger = LoggerFactory.getLogger(SprintelController.class);
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	CommonHandler commonHandler;

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
    
    @RequestMapping(value = "api/v1/hello", method = RequestMethod.GET, produces = { "application/json"})
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
    
    @RequestMapping(value = "api/v1/hello1", method = RequestMethod.GET, produces = { "application/json"})
    public String service1(){
        return commonHandler.getMethod();
    }
    
    @RequestMapping(value = "api/v1/hello2", method = RequestMethod.GET, produces = { "application/json"})
    public ResponseEntity<String> service2(){
    	return ResponseEntity.ok().body(commonHandler.getMethod());
    }
    
    @RequestMapping(value = "api/v1/hello3", method = RequestMethod.GET, produces = { "application/json"})
    public Status service3(){
    	return commonHandler.getMethod(null);
    }
    
    @RequestMapping(value = "api/v1/hello4", method = RequestMethod.POST, produces = { "application/json"})
    public Status service4(){
        return commonHandler.postMethod();
    }
    
}