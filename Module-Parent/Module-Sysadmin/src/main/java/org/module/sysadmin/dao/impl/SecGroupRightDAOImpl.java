package org.module.sysadmin.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.module.api.common.dao.base.BasisDAO;
import org.module.sysadmin.dao.SecGroupRightDAO;
import org.module.sysadmin.model.SecGroup;
import org.module.sysadmin.model.SecGroupright;
import org.module.sysadmin.model.SecRight;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public class SecGroupRightDAOImpl extends BasisDAO<SecGroupright> implements SecGroupRightDAO {

	@Override
	public SecGroupright getNewSecGroupRight() {
		return new SecGroupright();
	}

	@Override
	public int getCountAllSecGrouprights() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM SecGroupright"));
	}

	@Override
	public boolean isRightInGroup(SecRight secRight, SecGroup secGroup) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecGroupright.class);
		detachedCriteria.add(Restrictions.eq("secGroup", secGroup));
		detachedCriteria.add(Restrictions.eq("secRight", secRight));
		detachedCriteria.setProjection(Projections.rowCount());

        int count = DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(detachedCriteria));
        return count > 0;
	}
	
	/*Check Lagi*/
	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getRightByGroups(SecGroup secGroup) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRight.class);
        detachedCriteria.createAlias("secGrouprightList", "gr");
        detachedCriteria.add(Restrictions.eq("gr.grpId", secGroup));

        Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
        List<SecRight> secRights = (List<SecRight>) object;
        
        return secRights;
	}

	@Override
	public List<SecGroupright> getAllGroupRights() {
		 return getHibernateTemplate().loadAll(SecGroupright.class);
	}
	
	/*Check Lagi*/
	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getGroupRightByGroups(SecGroup secGroup) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRight.class);
		detachedCriteria.createAlias("secGrouprightList", "secgrouprightlist");
		detachedCriteria.add(Restrictions.eq("secgrouprightlist.grpId", secGroup));

		Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
	    List<SecRight> secRights = (List<SecRight>) object;
	    
	    return secRights;
	}

	@Override
	public SecGroupright getGroupRightByGroupAndRights(SecGroup secGroup, SecRight secRight) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecGroupright.class);
		detachedCriteria.add(Restrictions.eq("grpId", secGroup));
		detachedCriteria.add(Restrictions.eq("rigId", secRight));

        return (SecGroupright) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(detachedCriteria));
	}
}