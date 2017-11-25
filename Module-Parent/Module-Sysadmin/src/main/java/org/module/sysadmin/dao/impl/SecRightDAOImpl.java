package org.module.sysadmin.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.module.api.common.dao.base.BasisDAO;
import org.module.sysadmin.dao.SecRightDAO;
import org.module.sysadmin.model.SecGroupright;
import org.module.sysadmin.model.SecRight;
import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public class SecRightDAOImpl extends BasisDAO<SecRight> implements SecRightDAO {

	@Override
	public SecRight getNewSecRight() {
		return new SecRight();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getAllRights() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRight.class);
		detachedCriteria.addOrder(Order.asc("rigName"));

        Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
        List<SecRight> secRights = (List<SecRight>) object;
        
        return secRights;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getAllRights(int type) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRight.class);
		detachedCriteria.addOrder(Order.asc("rigName"));

        if (type != -1) {
        	detachedCriteria.add(Restrictions.eq("rigType", Integer.valueOf(type)));
        }

        return (List<SecRight>) getHibernateTemplate().findByCriteria(detachedCriteria).listIterator();
	}

	@Override
	public int getCountAllSecRights() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM SecRight"));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getRightLikeRightNames(String rightname) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRight.class);
		detachedCriteria.add(Restrictions.ilike("rigName", rightname, MatchMode.ANYWHERE));

        return (List<SecRight>) getHibernateTemplate().findByCriteria(detachedCriteria).listIterator();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getRightLikeRightNameAndTypes(String rightname, int righttype) {
		if(righttype == -1){
            return getRightLikeRightNames(rightname);
	    }
	
	    DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
	    criteria.add(Restrictions.and(Restrictions.ilike("rigName", rightname, MatchMode.ANYWHERE), Restrictions.eq("rigType", Integer.valueOf(righttype))));
	
	    return (List<SecRight>) getHibernateTemplate().findByCriteria(criteria).listIterator();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getRightLikeRightNameAndTypes(String rightname, List<Integer> listofrighttype) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRight.class);
		detachedCriteria.addOrder(Order.asc("rigName"));

        List<SecRight> result = null;

        String hqlFrom = "";
        String hqlWhere = "";
        String hqlAdd = "";

        for (final Integer integer : listofrighttype) {
            if (integer.equals(new Integer(-1))) {
                if (rightname.isEmpty()) {
                    return getAllRights(integer.intValue());
                } else if (!rightname.isEmpty()) {

                    hqlFrom = " FROM SecRight AS secRight WHERE ";
                    hqlWhere = " secRight.rigName LIKE '%" + rightname + "%'";
                    final String hqlQuery = hqlFrom + hqlWhere;

                    return (List<SecRight>) getHibernateTemplate().find(hqlQuery).listIterator();
                }
            }
        }

        if (listofrighttype.size() == 1) {
            int i = listofrighttype.get(0).intValue();
            
            if(rightname.isEmpty()) {
                    return getAllRights(i);
            }
        }

        hqlFrom = " FROM SecRight AS secRight WHERE ";
        hqlWhere = " secRight.rigType = " + listofrighttype.get(0);

        for(int i = 1; i < listofrighttype.size(); i++) {
            hqlWhere = hqlWhere + " OR secRight.rigType = " + listofrighttype.get(i);
        }

        String hqlQuery = hqlFrom + hqlWhere;

        if (!rightname.isEmpty()) {
            hqlAdd = " AND secRight.rigName LIKE '%" + rightname + "%'";
            hqlQuery = hqlQuery + hqlAdd;
        }

        result = (List<SecRight>) getHibernateTemplate().find(hqlQuery).listIterator();

        return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getAllRights(List<Integer> listofrighttype) {
		List<SecRight> result = null;

        if(listofrighttype.contains(Integer.valueOf(-1))) {
            return getAllRights(-1);
        }

        if(listofrighttype.size() == 1) {
            final int i = listofrighttype.get(0).intValue();
            return getAllRights(i);
        }

        String hqlFrom = " FROM SecRight AS secRight WHERE ";
        String hqlWhere = " secRight.rigType = " + listofrighttype.get(0);

        for(int i = 1; i < listofrighttype.size(); i++) {
            hqlWhere = hqlWhere + " OR secRight.rigType = " + listofrighttype.get(i);
        }

        final String hqlQuery = hqlFrom + hqlWhere;

        result = (List<SecRight>) getHibernateTemplate().find(hqlQuery).listIterator();

        return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getRightByGroupRights(SecGroupright secGroupright) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecRight.class);
		detachedCriteria.createAlias("secGrouprights", "gr");
		detachedCriteria.add(Restrictions.eq("gr.id", Long.valueOf(secGroupright.getGriId())));

        return (List<SecRight>) getHibernateTemplate().findByCriteria(detachedCriteria).listIterator();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecRight> getRightByUsers(SecUser secUser) {
		Object object = getHibernateTemplate().findByNamedQuery("allRightFromUserSqlQuery", Long.valueOf(secUser.getUsrId()));
        List<SecRight> secRights = (List<SecRight>) object;
        
        return secRights;
	}

	@Override
	public SecRight getRightById(Long rightid) {
		return get(SecRight.class, rightid);
	}
}