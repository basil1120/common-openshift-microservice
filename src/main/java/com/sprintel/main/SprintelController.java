package com.sprintel.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprintel.main.entities.Status;
import com.sprintel.main.services.CommonHandler;

@RestController
public class SprintelController {

	@Autowired
	CommonHandler commonHandler;
    
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