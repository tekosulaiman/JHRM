package org.module.sysadmin.dao;

import java.util.List;
import java.util.Map;

import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecRolegroup;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface SecRoleGroupDAO {
    public SecRolegroup getNewSecRolegroup();
    public void save(SecRolegroup secRolegroup);
    public void update(SecRolegroup secRolegroup);
    public void saveOrUpdate(SecRolegroup secRolegroup);
    public void delete(SecRolegroup secRolegroup);
    public List<SecRolegroup> getAllRoleGroups();
    public List<SecRolegroup> getByRequestMap(Map<String, Object> requestMap);
    public List<SecGroup> getGroupByRoles(SecRole secRole);
    public int getCountAllSecRoleGroups();
    public boolean isGroupInRole(SecGroup secGroup, SecRole secRole);
    public SecRolegroup getRolegroupByRoleAndGroup(SecRole secRole, SecGroup secGroup);
}