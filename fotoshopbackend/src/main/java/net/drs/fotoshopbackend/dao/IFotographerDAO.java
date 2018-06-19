package net.drs.fotoshopbackend.dao;

import java.util.List;

import net.drs.fotoshopbackend.dto.Fotographer;

public interface IFotographerDAO {

	
	Fotographer getFotographerbyId(Fotographer fotographer);
	
	boolean updateFotographer(Fotographer fotographer);
	
	List<Fotographer> getAllFotographers();
	
	List<Fotographer> getAllActiveFotographers();
	
	boolean activateFotographer(Fotographer fotographer);
	
	boolean deactivateFotographer(Fotographer fotographer);
	
	
}
