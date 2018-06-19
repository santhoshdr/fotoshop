package net.drs.fotoshop.api.impl;

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
		// TODO Auto-generated method stub
		return false;
	}

}
