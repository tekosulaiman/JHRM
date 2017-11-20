package org.module.sysadmin.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.module.api.common.dao.base.BasisDAO;
import org.module.sysadmin.dao.SecUserDAO;
import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public class SecUserDAOImpl extends BasisDAO<SecUser> implements SecUserDAO {

	@Override
	public SecUser getNewSecUser() {
		return new SecUser();
	}

	@Override
	public List<SecUser> getAllUsers() {
		return getHibernateTemplate().loadAll(SecUser.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SecUser> getAllUserByLoginNames(String loginname) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.add(Restrictions.like("usrLoginname", loginname, MatchMode.ANYWHERE));

        Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
        List<SecUser> secUsers = (List<SecUser>) object;
        
        return secUsers;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecUser> getUserLikeLoginNames(String likeloginname) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.add(Restrictions.like("usrLoginname", likeloginname, MatchMode.ANYWHERE));

        Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
        List<SecUser> secUsers = (List<SecUser>) object;
        
        return secUsers;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecUser> getUserLikeLastNames(String lastname) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.add(Restrictions.like("usrLastname", lastname, MatchMode.ANYWHERE));

        Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
        List<SecUser> secUsers = (List<SecUser>) object;
        
        return secUsers;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SecUser> getUserLikeEmails(String email) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.add(Restrictions.like("usrEmail", email, MatchMode.ANYWHERE));

        Object object = getHibernateTemplate().findByCriteria(detachedCriteria);
        List<SecUser> secUsers = (List<SecUser>) object;
        
        return secUsers;
	}

	@Override
	public int getCountAllSecUser() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM SecUser"));
	}

	@Override
	public SecUser getUserByID(Long usrid) {
		return get(SecUser.class, usrid);
	}

	@Override
	public SecUser getUserByLoginNames(String username) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.add(Restrictions.eq("usrLoginname", username));
        return (SecUser) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(detachedCriteria));
	}

	@Override
	public SecUser getUserByNameAndPassword(String username, String password) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.add(Restrictions.eq("usrLoginname", username));
		detachedCriteria.add(Restrictions.eq("usrPassword", password));

        return (SecUser) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(detachedCriteria));
	}

	@Override
	public SecUser getUserByUserCriteria(String username) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.add(Restrictions.eq("usrLoginname", username));

        return (SecUser) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(detachedCriteria));
	}
}