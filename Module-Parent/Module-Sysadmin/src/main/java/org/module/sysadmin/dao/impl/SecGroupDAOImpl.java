package org.module.sysadmin.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import org.module.sysadmin.dao.SecGroupDAO;
import org.module.sysadmin.dao.base.BasisDAO;
import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecGroupright;
import org.module.sysadmin.model.SecRolegroup;
import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public class SecGroupDAOImpl extends BasisDAO<SecGroup> implements SecGroupDAO {

	@Override
	public SecGroup getNewSecGroup() {
		return new SecGroup();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecGroup> getAllGroups() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecGroup.class);
		detachedCriteria.addOrder(Order.asc("grpShortdescription"));

        Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
        List<SecGroup> groups = (List<SecGroup>) object;
        
        return groups;
	}

	/*Check Lagi*/
	@Override
	@SuppressWarnings("unchecked")
	public List<SecGroup> getGroupByUsers(SecUser secUser) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecGroup.class);
		detachedCriteria.createAlias("secRolegroups", "secrolegroups");
		detachedCriteria.createAlias("secRoles", "secroles");
		detachedCriteria.add(Restrictions.eq("secrolegroups.secroles.secUser", secUser));

        return (List<SecGroup>) getHibernateTemplate().findByCriteria(detachedCriteria).listIterator();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecGroup> getGroupLikeGroupNames(String groupname) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecGroup.class);
		detachedCriteria.add(Restrictions.ilike("grpShortdescription", groupname, MatchMode.ANYWHERE));

        return (List<SecGroup>) getHibernateTemplate().findByCriteria(detachedCriteria).listIterator();
	}
	
	@Override
	public int getCountAllSecGroups() {
		 return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM SecGroup"));
	}

	@Override
	public SecGroup getSecGroupById(Long groupid) {
		return get(SecGroup.class, groupid);
	}

	/*Check Lagi*/
	@Override
	public SecGroup getGroupByGroupRight(SecGroupright secGroupright) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecGroup.class);
		detachedCriteria.createAlias("secGrouprights", "secgrouprights");
		detachedCriteria.add(Restrictions.eq("secgrouprights.grp_id", Long.valueOf(secGroupright.getGriId())));

        return (SecGroup) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(detachedCriteria));
	}

	/*Check Lagi*/
	@Override
	public SecGroup getGroupByRoleGroup(SecRolegroup secRolegroup) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecGroup.class);
		detachedCriteria.createAlias("secRolegroups", "rg");
		detachedCriteria.add(Restrictions.eq("rg.id", Long.valueOf(secRolegroup.getRlgId())));

        return (SecGroup) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(detachedCriteria));
	}
}