package org.module.sysadmin.dao;

import java.util.List;
import java.util.Map;

import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecUser;
import org.module.sysadmin.model.SecUserrole;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface SecUserRoleDAO {
	public SecUserrole getNewSecUserrole();
    public void save(SecUserrole secUserrole);
    public void update(SecUserrole secUserrole);
    public void saveOrUpdate(SecUserrole secUserrole);
    public void delete(SecUserrole secUserrole);
    public List<SecUserrole> getAllUserRoles();
    public List<SecUserrole> getByRequestMap(Map<String, Object> requestMap);
    public int getCountAllSecUserRoles();
    public boolean isUserInRole(SecUser secUser, SecRole secRole);
    public SecUserrole getUseRoleByUserAndRole(SecUser secUser, SecRole secRole);
}