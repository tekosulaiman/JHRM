package org.module.sysadmin.dao;

import java.util.List;
import java.util.Map;

import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface SecRoleDAO {
    public SecRole getNewSecRole();
    public void save(SecRole secRole);
    public void update(SecRole secRole);
    public void saveOrUpdate(SecRole secRole);
    public void delete(SecRole secRole);
    public List<SecRole> getAllRoles();
    public List<SecRole> getRoleByUsers(SecUser secUser);
    public List<SecRole> getRoleLikeRoleNames(String rolename);
    public List<SecRole> getByRequestMap(Map<String, Object> requestMap);
    public int getCountAllSecRoles();
    public SecRole getRoleById(Long roleid);
}