package net.drs.fotoshop.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.drs.fotoshop.api.userdetails.IRegistrationService;
import net.drs.fotoshopbackend.dao.IRegistrationDAO;
import net.drs.fotoshopbackend.dto.Fotographer;
import net.drs.fotoshopbackend.dto.User;


@Repository("registrationService")
@Transactional
public class RegistrationServiceImpl implements IRegistrationService {

	
	@Autowired
	private IRegistrationDAO registrationDAO;
	
	@Override
	public boolean adduser(User user) {
		return registrationDAO.addUser(user);	
	}

	@Override
	public boolean addFotographer(Fotographer fotographer) {
		registrationDAO.addFotographer(fotographer);
		return true;
	}

}
