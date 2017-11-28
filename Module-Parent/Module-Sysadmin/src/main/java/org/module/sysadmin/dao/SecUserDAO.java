package org.module.sysadmin.dao;

import java.util.HashMap;
import java.util.List;

import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface SecUserDAO {
	public SecUser getNewSecUser();
	public void save(SecUser secUser);
    public void update(SecUser secUser);
    public void saveOrUpdate(SecUser secUser);
    public void delete(SecUser secUser);
    public List<SecUser> getAllUsers();
    public List<SecUser> getAllByRequestMapUsers(HashMap<String, Object> hashMap);
    public List<SecUser> getAllUserByLoginNames(String loginname);
    public List<SecUser> getUserLikeLoginNames(String likeloginname);
    public List<SecUser> getUserLikeLastNames(String lastname);
    public List<SecUser> getUserLikeEmails(String email);
    public List<SecUser> getByRequestMap(HashMap<String, Object> hashMap);
    public int getCountAllSecUser();
    public SecUser getUserByID(Long userid);
    public SecUser getUserByLoginNames(String username);	
    public SecUser getUserByNameAndPassword(String username, String password);
    public SecUser getUserByUserCriteria(String username);
}