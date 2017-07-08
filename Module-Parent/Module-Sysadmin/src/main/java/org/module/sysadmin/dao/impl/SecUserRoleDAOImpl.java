package org.module.sysadmin.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import org.module.sysadmin.dao.SecUserRoleDAO;
import org.module.sysadmin.dao.base.BasisDAO;
import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecUser;
import org.module.sysadmin.model.SecUserrole;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public class SecUserRoleDAOImpl extends BasisDAO<SecUserrole> implements SecUserRoleDAO {

	@Override
	public SecUserrole getNewSecUserrole() {
		return new SecUserrole();
	}

	@Override
	public List<SecUserrole> getAllUserRoles() {
		return getHibernateTemplate().loadAll(SecUserrole.class);
	}

	@Override
	public int getCountAllSecUserRoles() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM SecUserrole"));
	}

	@Override
	public boolean isUserInRole(SecUser secUser, SecRole secRole) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUserrole.class);
		detachedCriteria.add(Restrictions.eq("secUser", secUser));
		detachedCriteria.add(Restrictions.eq("secRole", secRole));
		detachedCriteria.setProjection(Projections.rowCount());

        int count = DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(detachedCriteria));
        return count > 0;
	}

	@Override
	public SecUserrole getUseRoleByUserAndRole(SecUser secUser, SecRole secRole) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUserrole.class);
		detachedCriteria.add(Restrictions.eq("rolId", secRole));
		detachedCriteria.add(Restrictions.eq("usrId", secUser));
		
		return (SecUserrole) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(detachedCriteria));
	}
}