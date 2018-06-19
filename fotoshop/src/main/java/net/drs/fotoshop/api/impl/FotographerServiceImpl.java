package net.drs.fotoshop.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.drs.fotoshop.api.userdetails.IFotographerService;
import net.drs.fotoshopbackend.dao.IFotographerDAO;
import net.drs.fotoshopbackend.dao.IRegistrationDAO;
import net.drs.fotoshopbackend.dto.Fotographer;


@Repository("fotographerService")
@Transactional
public class FotographerServiceImpl implements IFotographerService {

	
	@Autowired
	private IFotographerDAO fotographerDAO;
	
	@Override
	public Fotographer getFotographerbyId(Fotographer fotographer) {
		return fotographerDAO.getFotographerbyId(fotographer);
	}

	@Override
	public boolean updateFotographer(Fotographer fotographer) {
		fotographerDAO.updateFotographer(fotographer);
		return false;
	}

	@Override
	public boolean activateFotographer(Fotographer fotographer) {
		return fotographerDAO.activateFotographer(fotographer);
	}

	@Override
	public boolean deactivateFotographer(Fotographer fotographer) {
		return fotographerDAO.deactivateFotographer(fotographer);
	}

	@Override
	public List<Fotographer> getAllActiveFotographers() {
		return fotographerDAO.getAllActiveFotographers();
	}


}
