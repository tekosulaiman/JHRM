package org.module.sysadmin.dao;

import java.util.HashMap;
import java.util.List;

import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecGroupright;
import org.module.sysadmin.model.SecRight;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface SecGroupRightDAO {
    public SecGroupright getNewSecGroupRight();
    public void save(SecGroupright secGroupright);
    public void update(SecGroupright secGroupright);
    public void saveOrUpdate(SecGroupright secGroupright);
    public void delete(SecGroupright secGroupright);
    public int getCountAllSecGrouprights();
    public boolean isRightInGroup(SecRight secRight, SecGroup secGroup);
    public List<SecGroupright> getAllGroupRights();
    public List<SecGroupright> getByRequestMap(HashMap<String, Object> hashMap);
    public List<SecRight> getRightByGroups(SecGroup secGroup);
    public List<SecRight> getGroupRightByGroups(SecGroup secGroup);
    public SecGroupright getGroupRightByGroupAndRights(SecGroup secGroup, SecRight secRight);
}