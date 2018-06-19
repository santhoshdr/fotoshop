package net.drs.fotoshop.api.userdetails;

import java.util.List;

import net.drs.fotoshopbackend.dto.Fotographer;

public interface IFotographerService {

	Fotographer getFotographerbyId(Fotographer fotographer);
	
	boolean updateFotographer(Fotographer fotographer);
	
	boolean activateFotographer(Fotographer fotographer);
	
	
	boolean deactivateFotographer(Fotographer fotographer);
	
	List<Fotographer> getAllActiveFotographers();
	
}
