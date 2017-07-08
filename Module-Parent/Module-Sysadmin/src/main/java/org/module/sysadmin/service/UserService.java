package org.module.sysadmin.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecRight;
import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
@WebService
public interface UserService {
    public SecUser getNewUser();
    public void save(SecUser secUser);
    public void update(SecUser secUser);
    public void saveOrUpdate(SecUser secUser);
    public void delete(SecUser secUser);
    public List<SecUser> getAllUsers();
    public List<SecUser> getUserLikeLoginNames(String likeloginname);
    public List<SecUser> getUserLikeLastNames(String lastnames);
    public List<SecUser> getUserLikeEmails(String likeemail);
    public List<SecUser> getRequestMapBySecUser(Map<String, Object> requestMap);
    public List<SecRole> getRoleByUsers(SecUser secUser);
    public List<SecRole> getAllRoles();
    public List<SecGroup> getGroupByUsers(SecUser secUser);
    public Collection<SecRight> getRightByUsers(SecUser secUser);
    public int getCountAllSecUser();
    public SecUser getUserByLoginNames(String loginname);
}