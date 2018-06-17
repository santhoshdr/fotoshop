package net.drs.fotoshop.api.userdetails;

import net.drs.fotoshopbackend.dto.Fotographer;
import net.drs.fotoshopbackend.dto.User;

public interface IRegistrationService {
	
	boolean adduser(User user);
	
	
	boolean addFotographer(Fotographer fotographer);
	

}
