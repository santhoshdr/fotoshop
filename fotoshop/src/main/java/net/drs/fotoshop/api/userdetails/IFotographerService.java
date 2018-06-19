package net.drs.fotoshop.api.userdetails;

import net.drs.fotoshopbackend.dto.Fotographer;

public interface IFotographerService {

	Fotographer getFotographerbyId(Fotographer fotographer);
	
	boolean updateFotographer(Fotographer fotographer);
	
}
