package org.module.api.common.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
@Repository
public abstract class BasisDAO<T> {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    private Class<T> genericType;
    
    @SuppressWarnings("unchecked")
	protected BasisDAO() {
    	this.setGenericType((Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BasisDAO.class));
    }
    
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Hibernate
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(T entity) throws DataAccessException {
        hibernateTemplate.save(entity);
    }

    public void saveOrUpdate(T entity) throws DataAccessException {
        hibernateTemplate.saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<T> entities) throws DataAccessException {
        for (T entity : entities) {
            saveOrUpdate(entity);
        }
    }

    public void update(T entity) throws DataAccessException {
        hibernateTemplate.update(entity);
    }

    public void delete(T entity) throws DataAccessException {
        hibernateTemplate.delete(entity);
    }

    protected void deleteAll(Collection<T> entities) throws DataAccessException {
        hibernateTemplate.deleteAll(entities);
    }
    
    @SuppressWarnings("unchecked")
	public List<T> getByRequestMap(HashMap<String, Object> hashMap) {
		
    	final StringBuffer queryString = new StringBuffer();
		
		queryString.append(" FROM "+ genericType.getSimpleName());

		Object params[] = new Object[hashMap.size()];
    	
		int a = 0;
		
    	if ((hashMap != null) && !hashMap.isEmpty()){
    		queryString.append(" WHERE ");
            
            for (final Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator(); it.hasNext();){
                
            	final Map.Entry<String,Object> entry = it.next(); 
                
            	if (entry.getValue() instanceof Class) {
            		queryString.append(entry.getKey()).append(" = ").append("?");
            		params[a] = entry.getValue();
				
				} else if (entry.getValue() instanceof String) {                	
					queryString.append(entry.getKey()).append(" like ").append("'%"+entry.getValue()+"%'");
				} else if (entry.getValue() instanceof Boolean) {
					queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
				}
				
				if (it.hasNext()) {
					queryString.append(" AND ");
				}
            }
        }
        
    	System.out.println("Query : "+queryString);
		/*return (List<T>) hibernateTemplate.find(queryString.toString(), params);*/
		return (List<T>) hibernateTemplate.find(queryString.toString());
    }
    
        
    @SuppressWarnings("unchecked")
    public List<T> getByRequestMapWithSortingForPaging(HashMap<String, Object> hashMap, List<String> orderByList, String ASCorDESC, int offset, int limit) {

        final StringBuffer queryString = new StringBuffer();

        queryString.append(" FROM " + genericType.getSimpleName());

        Object params[] = new Object[hashMap.size()];

        int a = 0;

        if ((hashMap != null) && !hashMap.isEmpty()) {
            queryString.append(" WHERE ");

            for (final Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator(); it.hasNext();) {

                final Map.Entry<String, Object> entry = it.next();

                if (entry.getValue() instanceof Class) {
                    queryString.append(entry.getKey()).append(" = ").append("?");
                    params[a] = entry.getValue();

                } else if (entry.getValue() instanceof String) {
                    queryString.append(entry.getKey()).append(" like ").append("'%" + entry.getValue() + "%'");
                } else if (entry.getValue() instanceof Boolean) {
                    queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
                }

                if (it.hasNext()) {
                    queryString.append(" AND ");
                }
            }
        }

        if ((orderByList != null) && !orderByList.isEmpty()) {
            queryString.append(" ORDER BY ");

            for (final Iterator<String> is = orderByList.iterator(); is.hasNext();) {
                String coloumn = is.next();
                queryString.append(coloumn + " ");

                if (is.hasNext()) {
                    queryString.append(" AND ");
                }
            }

            queryString.append(ASCorDESC);
        }
        
        Query query = sessionFactory.getCurrentSession().createQuery(queryString.toString());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        
        System.out.println("Query : " + queryString);
        /*return (List<T>) hibernateTemplate.find(queryString.toString(), params);*/
        return (List<T>) query.list();
    }

    //tambahan byrequestmap for count (filtering count)
    @SuppressWarnings("unchecked")
    public List<T> getByRequestMapCount(HashMap<String, Object> hashMap) {

        final StringBuffer queryString = new StringBuffer();

        queryString.append("SELECT COUNT(*) FROM " + genericType.getSimpleName());

        Object params[] = new Object[hashMap.size()];

        int a = 0;

        if ((hashMap != null) && !hashMap.isEmpty()) {
            queryString.append(" WHERE ");

            for (final Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator(); it.hasNext();) {

                final Map.Entry<String, Object> entry = it.next();

                if (entry.getValue() instanceof Class) {
                    queryString.append(entry.getKey()).append(" = ").append("?");
                    params[a] = entry.getValue();

                } else if (entry.getValue() instanceof String) {
                    queryString.append(entry.getKey()).append(" like ").append("'%" + entry.getValue() + "%'");
                } else if (entry.getValue() instanceof Boolean) {
                    queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
                }

                if (it.hasNext()) {
                    queryString.append(" AND ");
                }
            }
        }

        System.out.println("Query : " + queryString);
        /*return (List<T>) hibernateTemplate.find(queryString.toString(), params);*/
        return (List<T>) hibernateTemplate.find(queryString.toString());
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Persistence
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    protected void persist(T entity) throws DataAccessException {
        hibernateTemplate.persist(entity);
    }
    
    protected T merge(T entity) throws DataAccessException {
        return (T) hibernateTemplate.merge(entity);
    }

    public void refresh(T entity) throws DataAccessException {
        hibernateTemplate.refresh(entity);
    }
    
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Other
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    protected void initialize(final Object proxy) throws DataAccessException {
        hibernateTemplate.initialize(proxy);
    }

    protected T get(Class<T> entityClass, Serializable id) throws DataAccessException {
        return (T) hibernateTemplate.get(entityClass, id);
    }
    
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

	public Class<T> getGenericType() {
		return genericType;
	}

	public void setGenericType(Class<T> genericType) {
		this.genericType = genericType;
	}
}