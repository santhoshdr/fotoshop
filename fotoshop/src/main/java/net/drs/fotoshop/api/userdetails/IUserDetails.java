package net.drs.fotoshop.api.userdetails;

import java.util.List;

import net.drs.fotoshopbackend.dto.User;


/**
 * 
 * This service operates on list of registered users...
 * 
 * @author srajanna
 *
 */


public interface IUserDetails  {

	
	// this will get all the users
	List<User> getAllUsers();
	
	// get the information of specific user - based on user id
	User getUserById(int userid);
	
	// get all Active users
	List<User> getAllActiveUsers();
	
	//check if the user is active or not, based on userid
	boolean isUserActive(int userId);
	
	// Activate User
	boolean activeteUser(int userId);
	
	// Deactivate User / Delete User
	boolean deactiveUser(int userId);
	
	
	//if the user need to update the details.. 
	boolean updateUserDetails(User user);	
}
