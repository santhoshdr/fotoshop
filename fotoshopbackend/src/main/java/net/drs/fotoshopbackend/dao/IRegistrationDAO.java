package net.drs.fotoshopbackend.dao;

import java.util.List;

import net.drs.fotoshopbackend.dto.Fotographer;
import net.drs.fotoshopbackend.dto.User;

public interface IRegistrationDAO {

	// normal User
	boolean addUser(User user);
	
	
	boolean addFotographer(Fotographer fotographer);

	
}

