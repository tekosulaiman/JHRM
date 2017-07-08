package org.module.sysadmin.dao;

import java.util.List;
import java.util.Map;

import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecGroupright;
import org.module.sysadmin.model.SecRolegroup;
import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface SecGroupDAO {
    public SecGroup getNewSecGroup();
    public void save(SecGroup secGroup);
    public void update(SecGroup secGroup);
    public void saveOrUpdate(SecGroup secGroup);
    public void delete(SecGroup secGroup);
    public List<SecGroup> getAllGroups();
    public List<SecGroup> getGroupByUsers(SecUser secUser);
    public List<SecGroup> getGroupLikeGroupNames(String groupname);  
    public List<SecGroup> getByRequestMap(Map<String, Object> requestMap);
    public int getCountAllSecGroups();
    public SecGroup getSecGroupById(Long groupid);
    public SecGroup getGroupByGroupRight(SecGroupright secGroupright);
    public SecGroup getGroupByRoleGroup(SecRolegroup secRolegroup); 
}