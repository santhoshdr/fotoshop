package net.drs.fotoshop.restcontroller;

import java.util.List;

import net.drs.fotoshop.api.userdetails.IRegistrationService;
import net.drs.fotoshop.api.userdetails.IUserDetails;
import net.drs.fotoshop.error.CustomErrorType;
import net.drs.fotoshopbackend.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private IUserDetails userDetails;
	
	@Autowired
	private IRegistrationService registrationService;
	
	
	// Get User
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        User user = userDetails.getUserById(new Long(1));
        if (user == null) {
            return new ResponseEntity(new CustomErrorType("User with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
	
	
//curl -H "Content-Type: application/json" -X POST -d {\"firstName\":\"firstName\",\"lastName\":\"lastName\"} http://localhost:8085/user/addUser
//curl -H "Content-Type: application/json" -X POST -d {\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"mobileNumber\":\"mobileNumber\",\"emailAddress\":\"emailAddress@emailAddress.com\",\"address\":\"address\",\"password\":\"password\"}  http://localhost:8085/user/addUser
	
	// Add User
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	//@PostMapping(value = "/addUser")
	   public void addUser(@RequestBody User user) {
		try{
			registrationService.adduser(user);
	   }catch(Exception e){
		   new ResponseEntity(new CustomErrorType("Unable to handle the request.."), HttpStatus.NOT_FOUND);
	   }
		
	}
		
		// Get All Users
		//@PostMapping(value = "/getAllUsers") can also be used
		@RequestMapping(value="/getAllUsers", method=RequestMethod.GET)
		public ResponseEntity<List<User>> getAllUsers() {
			List<User> user = null;
			try{
				user = userDetails.getAllUsers();
		   }catch(Exception e){
			   new ResponseEntity(new CustomErrorType("Unable to handle the request.."), HttpStatus.NOT_FOUND);
		   }
		  return new ResponseEntity<List<User>>(user, HttpStatus.OK);
		}
		
		
		@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<List<User>> deleteUser(@PathVariable("id") long id) {
	        List<User> user = null; 
	        userDetails.deactiveUser(id);
	        user = userDetails.getAllActiveUsers();
	        return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	    }
		
		@RequestMapping(value="/getAllActiveUsers", method=RequestMethod.GET)
		public ResponseEntity<List<User>> getAllActiveUsers() {
			List<User> user = null;
			try{
				user = userDetails.getAllActiveUsers();
		   }catch(Exception e){
			   new ResponseEntity(new CustomErrorType("Unable to handle the request.."), HttpStatus.NOT_FOUND);
		   }
		  return new ResponseEntity<List<User>>(user, HttpStatus.OK);
		}
}
