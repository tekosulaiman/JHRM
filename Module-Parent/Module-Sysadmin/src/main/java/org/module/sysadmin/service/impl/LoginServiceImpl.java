package org.module.sysadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.module.sysadmin.dao.SecUserDAO;
import org.module.sysadmin.model.SecUser;
import org.module.sysadmin.service.LoginService;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private SecUserDAO secUserDAO;

    @Override
    public SecUser getLoginUser(String usrLoginName, String usrPassword) {
        return secUserDAO.getUserByNameAndPassword(usrLoginName, usrPassword);
    }

	public SecUserDAO getSecUserDAO() {
		return secUserDAO;
	}

	public void setSecUserDAO(SecUserDAO secUserDAO) {
		this.secUserDAO = secUserDAO;
	}
}