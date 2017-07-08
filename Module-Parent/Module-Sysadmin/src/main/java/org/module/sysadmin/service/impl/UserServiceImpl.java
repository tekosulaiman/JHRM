package org.module.sysadmin.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.module.sysadmin.dao.SecGroupDAO;
import org.module.sysadmin.dao.SecGroupRightDAO;
import org.module.sysadmin.dao.SecRightDAO;
import org.module.sysadmin.dao.SecRoleDAO;
import org.module.sysadmin.dao.SecRoleGroupDAO;
import org.module.sysadmin.dao.SecUserRoleDAO;
import org.module.sysadmin.dao.SecUserDAO;
import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecRight;
import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecUser;
import org.module.sysadmin.service.UserService;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
@Service
@WebService(serviceName="userService", endpointInterface="service.UserService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private SecUserDAO secUserDAO;
    
    @Autowired
    private SecUserRoleDAO secUserRoleDAO;
    
    @Autowired
    private SecRoleDAO secRoleDAO;
    
    @Autowired
    private SecRoleGroupDAO secRoleGroupDAO;
    
    @Autowired
    private SecGroupDAO secGroupDAO;
    
    @Autowired
    private SecGroupRightDAO secGroupRightDAO;
    
    @Autowired
    private SecRightDAO secRightDAO;
    
    @Override
	public SecUser getNewUser() {
    	return secUserDAO.getNewSecUser();
	}

	@Override
	public void save(SecUser secUser) {
		secUserDAO.save(secUser);
	}

	@Override
	public void update(SecUser secUser) {
		secUserDAO.update(secUser);
	}

	@Override
	public void saveOrUpdate(SecUser secUser) {
		secUserDAO.saveOrUpdate(secUser);
	}

	@Override
	public void delete(SecUser secUser) {
		secUserDAO.delete(secUser);
	}
	
	@Override
	public List<SecUser> getAllUsers() {
		return secUserDAO.getAllUsers();
	}

	@Override
	public List<SecUser> getUserLikeLoginNames(String likeloginname) {
		return secUserDAO.getUserLikeLoginNames(likeloginname);
	}

	@Override
	public List<SecUser> getUserLikeLastNames(String lastnames) {
		return secUserDAO.getUserLikeLastNames(lastnames);
	}

	@Override
	public List<SecUser> getUserLikeEmails(String likeemail) {
		return secUserDAO.getUserLikeEmails(likeemail);
	}
	
	@Override
	public List<SecUser> getRequestMapBySecUser(Map<String, Object> requestMap) {
		return secUserDAO.getByRequestMap(requestMap);
	}

	@Override
	public List<SecRole> getRoleByUsers(SecUser secUser) {
		 return secRoleDAO.getRoleByUsers(secUser);
	}

	@Override
	public List<SecRole> getAllRoles() {
		return secRoleDAO.getAllRoles();
	}

	@Override
	public List<SecGroup> getGroupByUsers(SecUser secUser) {
		List<SecGroup> secGroups = new ArrayList<SecGroup>();
		secGroups = secGroupDAO.getGroupByUsers(secUser);

        return secGroups;
	}

	@Override
	public Collection<SecRight> getRightByUsers(SecUser secUser) {
		return secRightDAO.getRightByUsers(secUser);
	}

	@Override
	public int getCountAllSecUser() {
		return secUserDAO.getCountAllSecUser();
	}
	
	@Override
	public SecUser getUserByLoginNames(String loginname) {
		return secUserDAO.getUserByLoginNames(loginname);
	}

	public SecUserDAO getSecUserDAO() {
		return secUserDAO;
	}

	public void setSecUserDAO(SecUserDAO secUserDAO) {
		this.secUserDAO = secUserDAO;
	}

	public SecUserRoleDAO getSecUserRoleDAO() {
		return secUserRoleDAO;
	}

	public void setSecUserRoleDAO(SecUserRoleDAO secUserRoleDAO) {
		this.secUserRoleDAO = secUserRoleDAO;
	}

	public SecRoleDAO getSecRoleDAO() {
		return secRoleDAO;
	}

	public void setSecRoleDAO(SecRoleDAO secRoleDAO) {
		this.secRoleDAO = secRoleDAO;
	}

	public SecRoleGroupDAO getSecRoleGroupDAO() {
		return secRoleGroupDAO;
	}

	public void setSecRoleGroupDAO(SecRoleGroupDAO secRoleGroupDAO) {
		this.secRoleGroupDAO = secRoleGroupDAO;
	}

	public SecGroupDAO getSecGroupDAO() {
		return secGroupDAO;
	}

	public void setSecGroupDAO(SecGroupDAO secGroupDAO) {
		this.secGroupDAO = secGroupDAO;
	}

	public SecGroupRightDAO getSecGroupRightDAO() {
		return secGroupRightDAO;
	}

	public void setSecGroupRightDAO(SecGroupRightDAO secGroupRightDAO) {
		this.secGroupRightDAO = secGroupRightDAO;
	}

	public SecRightDAO getSecRightDAO() {
		return secRightDAO;
	}

	public void setSecRightDAO(SecRightDAO secRightDAO) {
		this.secRightDAO = secRightDAO;
	}
}