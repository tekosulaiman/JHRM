package org.module.sysadmin.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.sysadmin.dao.SecGroupDAO;
import org.module.sysadmin.dao.SecGroupRightDAO;
import org.module.sysadmin.dao.SecRightDAO;
import org.module.sysadmin.dao.SecRoleDAO;
import org.module.sysadmin.dao.SecRoleGroupDAO;
import org.module.sysadmin.dao.SecUserDAO;
import org.module.sysadmin.dao.SecUserRoleDAO;
import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecGroupright;
import org.module.sysadmin.model.SecRight;
import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecRolegroup;
import org.module.sysadmin.model.SecUser;
import org.module.sysadmin.model.SecUserrole;
import org.module.sysadmin.model.dto.SecType;
import org.module.sysadmin.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
@Service
public class SecurityServiceImpl implements SecurityService {
    
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
	public SecUserrole getNewSecUserrole() {
		return secUserRoleDAO.getNewSecUserrole();
	}

	@Override
	public void save(SecUserrole secUserrole) {
		secUserRoleDAO.save(secUserrole);
	}

	@Override
	public void update(SecUserrole secUserrole) {
		secUserRoleDAO.update(secUserrole);
	}

	@Override
	public void saveOrUpdate(SecUserrole secUserrole) {
		secUserRoleDAO.saveOrUpdate(secUserrole);
	}

	@Override
	public void delete(SecUserrole secUserrole) {
		secUserRoleDAO.delete(secUserrole);
	}

	@Override
	public List<SecUserrole> getAllUserRoles() {
		return secUserRoleDAO.getAllUserRoles();
	}

	@Override
	public List<SecUserrole> getRequestMapBySecUserrole(HashMap<String, Object> hashMap) {
		return secUserRoleDAO.getByRequestMap(hashMap);
	}
	
	@Override
	public int getCountAllSecUserRoles() {
		return secUserRoleDAO.getCountAllSecUserRoles();
	}

	@Override
	public boolean isUserInRole(SecUser secUser, SecRole secRole) {
		return secUserRoleDAO.isUserInRole(secUser, secRole);
	}

	@Override
	public SecUserrole getUseRoleByUserAndRole(SecUser secUser, SecRole secRole) {
		return secUserRoleDAO.getUseRoleByUserAndRole(secUser, secRole);
	}

	@Override
	public SecRole getNewSecRole() {
		return secRoleDAO.getNewSecRole();
	}

	@Override
	public void save(SecRole secRole) {
		secRoleDAO.save(secRole);
	}

	@Override
	public void update(SecRole secRole) {
		secRoleDAO.update(secRole);
	}

	@Override
	public void saveOrUpdate(SecRole secRole) {
		secRoleDAO.saveOrUpdate(secRole);
	}

	@Override
	public void delete(SecRole secRole) {
		secRoleDAO.delete(secRole);
	}

	@Override
	public List<SecRole> getAllRoles() {
		return secRoleDAO.getAllRoles();
	}
	
	@Override
	public List<SecRole> getRequestMapBySecRole(HashMap<String, Object> hashMap) {
		return secRoleDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<SecRole> getRoleByUsers(SecUser secUser) {
		return secRoleDAO.getRoleByUsers(secUser);
	}

	@Override
	public List<SecRole> getRoleLikeRoleNames(String rolename) {
		return secRoleDAO.getRoleLikeRoleNames(rolename);
	}

	@Override
	public int getCountAllSecRoles() {
		return secRoleDAO.getCountAllSecRoles();
	}

	@Override
	public SecRole getRoleById(Long roleid) {
		return secRoleDAO.getRoleById(roleid);
	}

	@Override
	public SecRolegroup getNewSecRolegroup() {
		return secRoleGroupDAO.getNewSecRolegroup();
	}

	@Override
	public void save(SecRolegroup secRolegroup) {
		secRoleGroupDAO.save(secRolegroup);
	}

	@Override
	public void update(SecRolegroup secRolegroup) {
		secRoleGroupDAO.update(secRolegroup);
	}

	@Override
	public void saveOrUpdate(SecRolegroup secRolegroup) {
		secRoleGroupDAO.saveOrUpdate(secRolegroup);
	}

	@Override
	public void delete(SecRolegroup secRolegroup) {
		secRoleGroupDAO.delete(secRolegroup);
	}

	@Override
	public List<SecRolegroup> getAllRoleGroups() {
		return secRoleGroupDAO.getAllRoleGroups();
	}
	
	@Override
	public List<SecRolegroup> getRequestMapBySecRolegroup(HashMap<String, Object> hashMap) {
		return secRoleGroupDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<SecGroup> getGroupByRoles(SecRole secRole) {
		return secRoleGroupDAO.getGroupByRoles(secRole);
	}

	@Override
	public int getCountAllSecRoleGroups() {
		return secRoleGroupDAO.getCountAllSecRoleGroups();
	}

	@Override
	public boolean isGroupInRole(SecGroup secGroup, SecRole secRole) {
		return secRoleGroupDAO.isGroupInRole(secGroup, secRole);
	}

	@Override
	public SecRolegroup getRolegroupByRoleAndGroup(SecRole secRole, SecGroup secGroup) {
		return secRoleGroupDAO.getRolegroupByRoleAndGroup(secRole, secGroup);
	}

	@Override
	public SecGroup getNewSecGroup() {
		return secGroupDAO.getNewSecGroup();
	}

	@Override
	public void save(SecGroup secGroup) {
		secGroupDAO.save(secGroup);
	}

	@Override
	public void update(SecGroup secGroup) {
		secGroupDAO.update(secGroup);
	}

	@Override
	public void saveOrUpdate(SecGroup secGroup) {
		secGroupDAO.saveOrUpdate(secGroup);
	}

	@Override
	public void delete(SecGroup secGroup) {
		secGroupDAO.delete(secGroup);
	}

	@Override
	public List<SecGroup> getAllGroups() {
		return secGroupDAO.getAllGroups();
	}
	
	@Override
	public List<SecGroup> getRequestMapBySecGroup(HashMap<String, Object> hashMap) {
		return secGroupDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<SecGroup> getGroupByUsers(SecUser secUser) {
		return secGroupDAO.getGroupByUsers(secUser);
	}

	@Override
	public List<SecGroup> getGroupLikeGroupNames(String groupname) {
		return secGroupDAO.getGroupLikeGroupNames(groupname);
	}

	@Override
	public int getCountAllSecGroups() {
		return secGroupDAO.getCountAllSecGroups();
	}

	@Override
	public SecGroup getSecGroupById(Long groupid) {
		return secGroupDAO.getSecGroupById(groupid);
	}

	@Override
	public SecGroup getGroupByGroupRight(SecGroupright secGroupright) {
		return secGroupDAO.getGroupByGroupRight(secGroupright);
	}

	@Override
	public SecGroup getGroupByRoleGroup(SecRolegroup secRolegroup) {
		return secGroupDAO.getGroupByRoleGroup(secRolegroup);
	}

	@Override
	public SecGroupright getNewSecGroupRight() {
		return secGroupRightDAO.getNewSecGroupRight();
	}

	@Override
	public void save(SecGroupright secGroupright) {
		secGroupRightDAO.save(secGroupright);
	}

	@Override
	public void update(SecGroupright secGroupright) {
		secGroupRightDAO.update(secGroupright);
	}

	@Override
	public void saveOrUpdate(SecGroupright secGroupright) {
		secGroupRightDAO.saveOrUpdate(secGroupright);
	}

	@Override
	public void delete(SecGroupright secGroupright) {
		secGroupRightDAO.delete(secGroupright);
	}

	@Override
	public int getCountAllSecGrouprights() {
		return secGroupRightDAO.getCountAllSecGrouprights();
	}

	@Override
	public boolean isRightInGroup(SecRight secRight, SecGroup secGroup) {
		return secGroupRightDAO.isRightInGroup(secRight, secGroup);
	}

	@Override
	public List<SecRight> getRightByGroups(SecGroup secGroup) {
		return secGroupRightDAO.getGroupRightByGroups(secGroup);
	}

	@Override
	public List<SecGroupright> getAllGroupRights() {
		return secGroupRightDAO.getAllGroupRights();
	}
	
	@Override
	public List<SecGroupright> getRequestMapBySecGroupright(HashMap<String, Object> hashMap) {
		return secGroupRightDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<SecRight> getGroupRightByGroups(SecGroup secGroup) {
		return secGroupRightDAO.getGroupRightByGroups(secGroup);
	}

	@Override
	public SecGroupright getGroupRightByGroupAndRights(SecGroup secGroup,SecRight secRight) {
		return secGroupRightDAO.getGroupRightByGroupAndRights(secGroup, secRight);
	}
	
	@Override
	public SecRight getNewSecRight() {
		return secRightDAO.getNewSecRight();
	}

	@Override
	public void save(SecRight secRight) {
		secRightDAO.save(secRight);
	}

	@Override
	public void update(SecRight secRight) {
		secRightDAO.update(secRight);
	}

	@Override
	public void saveOrUpdate(SecRight secRight) {
		secRightDAO.saveOrUpdate(secRight);
	}

	@Override
	public void delete(SecRight secRight) {
		secRightDAO.delete(secRight);
	}

	@Override
	public List<SecRight> getAllRights() {
		return secRightDAO.getAllRights();
	}

	@Override
	public List<SecRight> getAllRights(int type) {
		return secRightDAO.getAllRights();
	}

	@Override
	public int getCountAllSecRights() {
		return secRightDAO.getCountAllSecRights();
	}

	@Override
	public List<SecRight> getRightLikeRightNames(String rightname) {
		return secRightDAO.getRightLikeRightNames(rightname);
	}

	@Override
	public List<SecRight> getRightLikeRightNameAndTypes(String rightname, int righttype) {
		return secRightDAO.getRightLikeRightNameAndTypes(rightname, righttype);
	}

	@Override
	public List<SecRight> getRightLikeRightNameAndTypes(String rightname, List<Integer> listofrighttype) {
		return secRightDAO.getRightLikeRightNameAndTypes(rightname, listofrighttype);
	}

	@Override
	public List<SecRight> getAllRights(List<Integer> listofrighttype) {
		return secRightDAO.getAllRights(listofrighttype);
	}

	@Override
	public List<SecRight> getRightByGroupRights(SecGroupright secGroupright) {
		return secRightDAO.getRightByGroupRights(secGroupright);
	}

	@Override
	public List<SecRight> getRightByUsers(SecUser secUser) {
		return secRightDAO.getRightByUsers(secUser);
	}
	
	@Override
	public List<SecRight> getRequestMapBySecRight(HashMap<String, Object> hashMap) {
		return secRightDAO.getByRequestMap(hashMap);
	}

	@Override
	public SecRight getRightById(Long rightid) {
		return secRightDAO.getRightById(rightid);
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

	@Override
	public List<SecType> getAllTypes() {
		return SecType.getAllTypes();
	}

	@Override
	public SecType getTypeById(int id) {
		return SecType.getTypById(id);
	}
}