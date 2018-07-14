package net.drs.fotoshop.restcontroller;
// usefull link : http://websystique.com/spring-boot/spring-boot-rest-api-example/


import java.util.Map;

import net.drs.fotoshop.api.userdetails.IUserDetails;
import net.drs.fotoshop.error.CustomErrorType;
import net.drs.fotoshopbackend.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {



	
	// Query Params :
	   @RequestMapping(value="/query", method=RequestMethod.GET)
	   public void queryMethod(@RequestParam String id,
	            @RequestParam Map<String, String> queryParameters,
	            @RequestParam MultiValueMap<String, String> multiMap) {
	    System.out.println("id=" + id);
	        System.out.println(queryParameters);
	        System.out.println(multiMap);
	   }
	
	
	// usefull link :http://atmarkplant.com/spring-boot-request-parameters/s 
	
	// Path Parameter
	
	//http://localhost:8085/name/abc/123
	@RequestMapping(path="/{name}/{age}")
    public String getMessage(@PathVariable("name") String name, 
            @PathVariable("age") String age) {
        String msg = String.format("%s is %s years old", name, age);
        return msg;
    }
	
	
	
	// POST params
/*	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	   public void getBody(@RequestBody String body) {
	        System.out.println("body:" + body);
	   }
*/
	
}


