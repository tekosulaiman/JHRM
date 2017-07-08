package org.module.sysadmin.service;

import java.util.List;
import java.util.Map;

import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecGroupright;
import org.module.sysadmin.model.SecRight;
import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecRolegroup;
import org.module.sysadmin.model.SecUser;
import org.module.sysadmin.model.SecUserrole;
import org.module.sysadmin.model.dto.SecType;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface SecurityService {

    /* +++++ Security: Userroles +++++++ */
    public SecUserrole getNewSecUserrole();
    public void save(SecUserrole secUserrole);
    public void update(SecUserrole secUserrole);
    public void saveOrUpdate(SecUserrole secUserrole);
    public void delete(SecUserrole secUserrole);
    public List<SecUserrole> getAllUserRoles();
    public List<SecUserrole> getRequestMapBySecUserrole(Map<String, Object> requestMap);
    public int getCountAllSecUserRoles();
    public boolean isUserInRole(SecUser secUser, SecRole secRole);
    public SecUserrole getUseRoleByUserAndRole(SecUser secUser, SecRole secRole);
    
    /* +++++ Security: Roles +++++++ */
    public SecRole getNewSecRole();
    public void save(SecRole secRole);
    public void update(SecRole secRole);
    public void saveOrUpdate(SecRole secRole);
    public void delete(SecRole secRole);
    public List<SecRole> getAllRoles();
    public List<SecRole> getRoleByUsers(SecUser secUser);
    public List<SecRole> getRoleLikeRoleNames(String rolename);
    public List<SecRole> getRequestMapBySecRole(Map<String, Object> requestMap);
    public int getCountAllSecRoles();
    public SecRole getRoleById(Long roleid);
   
    /* +++++ Security: RoleGroups +++++++ */
    public SecRolegroup getNewSecRolegroup();
    public void save(SecRolegroup secRolegroup);
    public void update(SecRolegroup secRolegroup);
    public void saveOrUpdate(SecRolegroup secRolegroup);
    public void delete(SecRolegroup secRolegroup);
    public List<SecRolegroup> getAllRoleGroups();
    public List<SecRolegroup> getRequestMapBySecRolegroup(Map<String, Object> requestMap);
    public List<SecGroup> getGroupByRoles(SecRole secRole);
    public int getCountAllSecRoleGroups();
    public boolean isGroupInRole(SecGroup secGroup, SecRole secRole);
    public SecRolegroup getRolegroupByRoleAndGroup(SecRole secRole, SecGroup secGroup);
    
    /* +++++ Security: Groups +++++++ */
    public SecGroup getNewSecGroup();
    public void save(SecGroup secGroup);
    public void update(SecGroup secGroup);
    public void saveOrUpdate(SecGroup secGroup);
    public void delete(SecGroup secGroup);
    public List<SecGroup> getAllGroups();
    public List<SecGroup> getGroupByUsers(SecUser secUser);
    public List<SecGroup> getGroupLikeGroupNames(String groupname);  
    public List<SecGroup> getRequestMapBySecGroup(Map<String, Object> requestMap);
    public int getCountAllSecGroups();
    public SecGroup getSecGroupById(Long groupid);
    public SecGroup getGroupByGroupRight(SecGroupright secGroupright);
    public SecGroup getGroupByRoleGroup(SecRolegroup secRolegroup); 

    /* +++++ Security: Grouprights +++++++ */
    public SecGroupright getNewSecGroupRight();
    public void save(SecGroupright secGroupright);
    public void update(SecGroupright secGroupright);
    public void saveOrUpdate(SecGroupright secGroupright);
    public void delete(SecGroupright secGroupright);
    public int getCountAllSecGrouprights();
    public boolean isRightInGroup(SecRight secRight, SecGroup secGroup);
    public List<SecGroupright> getAllGroupRights();
    public List<SecGroupright> getRequestMapBySecGroupright(Map<String, Object> requestMap);
    public List<SecRight> getGroupRightByGroups(SecGroup secGroup);
    public List<SecRight> getRightByGroups(SecGroup secGroup);
    public SecGroupright getGroupRightByGroupAndRights(SecGroup secGroup, SecRight secRight);
    
    /* +++++ Security: Rights +++++++ */
    public SecRight getNewSecRight();
    public void save(SecRight secRight);
    public void update(SecRight secRight);
    public void saveOrUpdate(SecRight secRight);
    public void delete(SecRight secRight);
    public List<SecRight> getAllRights();
    public List<SecRight> getAllRights(int type);
    public int getCountAllSecRights();
    public List<SecRight> getRightLikeRightNames(String rightname);
    public List<SecRight> getRightLikeRightNameAndTypes(String rightname, int righttype);
    public List<SecRight> getRightLikeRightNameAndTypes(String rightname, List<Integer> listofrighttype);
    public List<SecRight> getAllRights(List<Integer> listofrighttype);
    public List<SecRight> getRightByGroupRights(SecGroupright secGroupright);
    public List<SecRight> getRightByUsers(SecUser secUser);
    public List<SecRight> getRequestMapBySecRight(Map<String, Object> requestMap);
    public SecRight getRightById(Long rightid);
    
    /* +++++ Security: Security Typs +++++++ */
	public List<SecType> getAllTypes();
	public SecType getTypeById(int id);
}