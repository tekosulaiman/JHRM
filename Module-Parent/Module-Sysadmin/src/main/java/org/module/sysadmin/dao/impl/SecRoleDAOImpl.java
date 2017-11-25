package org.module.sysadmin.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.module.api.common.dao.base.BasisDAO;
import org.module.sysadmin.dao.SecRoleDAO;
import org.module.sysadmin.model.SecRole;
import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public class SecRoleDAOImpl extends BasisDAO<SecRole> implements SecRoleDAO {

	@Override
	public SecRole getNewSecRole() {
		return new SecRole();
	}

	@Override
	public List<SecRole> getAllRoles() {
		return getHibernateTemplate().loadAll(SecRole.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRole> getRoleByUsers(SecUser secUser) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRole.class);
        detachedCriteria.createAlias("secUserroleList", "rol");
        detachedCriteria.add(Restrictions.eq("rol.usrId", secUser));

        Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
        List<SecRole> secRoles = (List<SecRole>) object;
        
        return secRoles;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRole> getRoleLikeRoleNames(String rolename) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRole.class);
		detachedCriteria.add(Restrictions.ilike("rolShortdescription", rolename, MatchMode.ANYWHERE));

        return (List<SecRole>) getHibernateTemplate().findByCriteria(detachedCriteria).listIterator();
	}

	@Override
	public int getCountAllSecRoles() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM SecRole"));
	}

	@Override
	public SecRole getRoleById(Long roleid) {
		return get(SecRole.class, roleid);
	}
}