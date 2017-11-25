package org.module.sysadmin.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.module.api.common.dao.base.BasisDAO;
import org.module.sysadmin.dao.SecRoleGroupDAO;
import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecRolegroup;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public class SecRoleGroupDAOImpl extends BasisDAO<SecRolegroup> implements SecRoleGroupDAO {

	@Override
	public SecRolegroup getNewSecRolegroup() {
		return new SecRolegroup();
	}

	@Override
	public List<SecRolegroup> getAllRoleGroups() {
		return getHibernateTemplate().loadAll(SecRolegroup.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecGroup> getGroupByRoles(SecRole secRole) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecGroup.class);
	    detachedCriteria.createAlias("secRolegroupList", "rg");
	    detachedCriteria.add(Restrictions.eq("rg.rolId", secRole));
	
	    Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
	    List<SecGroup> secGroups = (List<SecGroup>) object;
	    
	    return secGroups;
	}

	@Override
	public int getCountAllSecRoleGroups() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM SecRolegroup"));
	}

	@Override
	public boolean isGroupInRole(SecGroup secGroup, SecRole secRole) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRolegroup.class);
		detachedCriteria.add(Restrictions.eq("secGroup", secGroup));
		detachedCriteria.add(Restrictions.eq("secRole", secRole));
		detachedCriteria.setProjection(Projections.rowCount());

        int count = DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(detachedCriteria));
        return count > 0;
	}

	@Override
	public SecRolegroup getRolegroupByRoleAndGroup(SecRole secRole, SecGroup secGroup) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRolegroup.class);
		detachedCriteria.add(Restrictions.eq("rolId", secRole));
		detachedCriteria.add(Restrictions.eq("grpId", secGroup));

        return (SecRolegroup) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(detachedCriteria));
	}
}