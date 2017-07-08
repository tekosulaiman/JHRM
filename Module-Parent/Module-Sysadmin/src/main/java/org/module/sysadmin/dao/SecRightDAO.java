package org.module.sysadmin.dao;

import java.util.List;
import java.util.Map;

import org.module.sysadmin.model.SecGroupright;
import org.module.sysadmin.model.SecRight;
import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface SecRightDAO {
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
    public List<SecRight> getByRequestMap(Map<String, Object> requestMap);
    public SecRight getRightById(Long rightid);
}