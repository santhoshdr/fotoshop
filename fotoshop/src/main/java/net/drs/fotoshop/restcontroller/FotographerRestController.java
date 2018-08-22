package net.drs.fotoshop.restcontroller;

import net.drs.fotoshop.api.userdetails.IRegistrationService;
import net.drs.fotoshop.error.CustomErrorType;
import net.drs.fotoshopbackend.dto.Address;
import net.drs.fotoshopbackend.dto.Fotographer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fotographer")
public class FotographerRestController {

	@Autowired
	IRegistrationService  registrationService;
	
	@RequestMapping(value="/addFotographer", method=RequestMethod.POST)
	//@PostMapping(value = "/addUser")
	   public void addUser(@RequestBody Fotographer fotographer) {
		try{
			registrationService.addFotographer(fotographer);
	   }catch(Exception e){
		   new ResponseEntity(new CustomErrorType("Unable to handle the request.."), HttpStatus.NOT_FOUND);
	   }
		
	}
}