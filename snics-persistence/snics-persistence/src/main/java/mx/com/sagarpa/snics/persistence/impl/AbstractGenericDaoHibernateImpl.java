package mx.com.sagarpa.snics.persistence.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



import mx.com.sagarpa.snics.persistence.GenericDao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



/**
 * 
 * @author Rotten
 *
 * @param <T>
 * @param <PK>
 */
public abstract class AbstractGenericDaoHibernateImpl<T, PK extends java.io.Serializable> extends HibernateDaoSupport
		implements GenericDao<T, PK> {

	private Class<T> type = null;
	private Logger logger = LoggerFactory.getLogger(AbstractGenericDaoHibernateImpl.class);
	private String name;
	
	public AbstractGenericDaoHibernateImpl(HibernateTemplate t) {
		super.setHibernateTemplate(t);
		setName(getDaoType());
	}

	/**
	 * Gets the dao type via reflection
	 * 
	 * @return the dao type
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class<T> getDaoType() {
		if (type == null) {
			Class clazz = getClass();
			while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
				clazz = clazz.getSuperclass();
			}
			type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
		}

		return type;
	}

	/**
	 * returns the name of the dao's domain object
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	@SuppressWarnings("rawtypes")
	private void setName(Class clazz) {
		String name = clazz.getName();
		name = name.substring(name.lastIndexOf(".") + 1, name.length());
		System.out.println("Created Dao of type[" + name + "]");
		this.name = name;

	}

	public void create(T persistObject) {
		this.getHibernateTemplate().save(persistObject);
	}

	public T read(PK id) {
		return (T) this.getHibernateTemplate().get(getDaoType(), id);
	}

	public void update(T persistObject) {
		this.getHibernateTemplate().update(persistObject);

	}

	public void update(String hql) {
		this.getHibernateTemplate().bulkUpdate(hql);
	}

	public void createOrUpdate(T persistObject) {
		this.getHibernateTemplate().saveOrUpdate(persistObject);

	}
	public void delete(T persistObject) {
		this.getHibernateTemplate().delete(persistObject);

	}

	public void deleteById(PK id) {

		this.getHibernateTemplate().delete(findById(id));

	}

	public boolean exist(PK id) {
		Object o = read(id);
		if (o == null)
			return false;
		else
			return true;
	}

	public boolean exists(T persistObject) {
		T obj = findByCriteria(persistObject);
		if (obj == null)
			return false;
		else
			return true;
	}

	public T findById(PK id) {
		return read(id);
	}

	@SuppressWarnings("unchecked")
	public T findByCriteria(T persistObject) {
		DetachedCriteria dc = DetachedCriteria.forClass(getDaoType());
		List<org.hibernate.criterion.Criterion> criteria = getCriteria(persistObject);
		Iterator<org.hibernate.criterion.Criterion> i = criteria.iterator();
		while (i.hasNext()) {
			dc.add(i.next());
		}

		T obj = null;

		try {
			obj = (T) DataAccessUtils.requiredUniqueResult(this.getHibernateTemplate().findByCriteria(dc));
		} catch (EmptyResultDataAccessException e) {
			logger.info("Got no Results. [" + e.toString() + "]");
			if (logger.isDebugEnabled())
				logger.debug("Got no Results", e);
		}

		return obj;
	}

	@SuppressWarnings("rawtypes")
	public int getTotal() {
		int total = 0;

		DetachedCriteria dc = DetachedCriteria.forClass(getDaoType());
		dc.setProjection(Projections.rowCount());
		List result = this.getHibernateTemplate().findByCriteria(dc);
		if (result.size() > 0) {
			try {
				total = ((Integer) result.get(0)).intValue();
			} catch (Exception e) {
				logger.error("Error getting total[" + getName() + "]", e);
				total = ((Long) result.get(0)).intValue();
			}

		}

		return total;
	}

	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public int getTotalByCriteria(T sample) {
		int total = 0;
		List restrictions = getCriteria(sample);

		DetachedCriteria dc = DetachedCriteria.forClass(getDaoType());
		dc.setProjection(Projections.rowCount());

		if (restrictions != null) {
			logger.info("Looking with restrictions.");
			Iterator it = restrictions.iterator();
			while (it.hasNext()) {
				dc.add((Criterion) it.next());
			}
		}

		List result = this.getHibernateTemplate().findByCriteria(dc);
		if (result.size() > 0) {
			try {
				total = ((Integer) result.get(0)).intValue();
			} catch (Exception e) {
				logger.error("Error getting total", e);
				total = ((Long) result.get(0)).intValue();
			}

		}

		return total;
	}

	/**
	 * returns all objects available.
	 */
	public List<T> listAll() {
		return this.getHibernateTemplate().loadAll(getDaoType());
	}

	/**
	 * returns all objects available based on the sample object to generate
	 * restrictions in the
	 */
	public List<T> listByCriteria(T persistObject) {
		return listByCriteria(persistObject, null, null, null);
	}

	/**
	 * returns all objects available based on the sample object to generate
	 * restrictions in the
	 */
	public List<T> listByCriteria(T persistObject, Map<String, String> orderBy) {
		return listByCriteria(persistObject, null, null, orderBy);
	}

	public List<T> listByCriteria(T persistObject, Integer start, Integer end, Map<String, String> orderBy) {
		return listByCriteria(persistObject, null, start, end, orderBy);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> listByCriteria(T persistObject, Map<String, Object[]> additionalValues, Integer start, Integer end,
			Map<String, String> orderBy) {
		List<T> elements = new ArrayList<T>();
		List restrictions = getCriteria(persistObject);
		StringBuffer s = new StringBuffer("Getting [" + getName() + "]s ");
		DetachedCriteria dc = DetachedCriteria.forClass(getDaoType());
		Criteria c = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(getDaoType());
		if (start != null) {
			s.append(" with first Result start[" + start + "]");
			c.setFirstResult(start);
		}

		if (end != null) {
			s.append(" and last result end[" + end + "]");
			c.setMaxResults(end);
		}

		if (orderBy != null) {
			Set keys = orderBy.keySet();
			Iterator it = keys.iterator();
			String field;
			String orderValue;
			while (it.hasNext()) {
				field = (String) it.next();
				orderValue = orderBy.get(field);
				if (orderValue.equalsIgnoreCase("ASC")) {
					dc.addOrder(Order.asc(field));
					c.addOrder(Order.asc(field));
					s.append("adding order[" + field + "-ASC]");
				} else if (orderValue.equalsIgnoreCase("DESC")) {
					dc.addOrder(Order.desc(field));
					c.addOrder(Order.desc(field));
					s.append("adding order[" + field + "-DESC]");
				}

			}
		}

		if (restrictions != null) {
			s.append("\nLooking with restrictions. ");
			Iterator itR = restrictions.iterator();
			while (itR.hasNext()) {
				Criterion crit = (Criterion) itR.next();
				dc.add(crit);
				c.add(crit);
			}
		}

		if (additionalValues != null) {
			s.append("With Additional Values for: ");
			Set keys = additionalValues.keySet();
			Iterator it = keys.iterator();
			String field;
			Object[] values;
			while (it.hasNext()) {
				field = (String) it.next();
				s.append("\n " + field);
				values = additionalValues.get(field);
				c.add(Restrictions.in(field, values));
				dc.add(Restrictions.in(field, values));
			}
		}

		logger.debug(s.toString());
		elements.addAll(c.list());
		// elements = this.getHibernateTemplate().findByCriteria(dc);
		logger.info("[" + getName() + "] elements found [" + elements.size() + "]");

		return elements;
	}

	public void evict(T entity) {
		this.getHibernateTemplate().evict(entity);

	}

	public void merge(T entity) {
		this.getHibernateTemplate().merge(entity);
	}
	public void initialize(T entity) {
		this.getHibernateTemplate().initialize(entity);
	}
	

	/**
	 * This method must be implemented in any inherited classes, it is intended
	 * to return a List of Hibernate Criterion object representing the
	 * restrictions to be used to find objects of the current dao type. If the
	 * parameter T sample is null, the method must return an empty List
	 * 
	 * @param sample
	 *            sample object from which the criteria will be based.
	 * @return a list of hibernate restrictions (
	 *         org.hibernate.criterion.Criterion objects )
	 */
	public List<org.hibernate.criterion.Criterion> getCriteria(T sample) {
		
		return GenericDaoHelper.getCriteria(sample, getPersistenceClassId(), getPersistenceClassSkippedProperties());
		//return GenericDaoHelper.getCriteria(sample, getPersistenceClassId(), getPersistenceClassSkippedProperties());
	}
	
	public abstract String getPersistenceClassId();

	public abstract List<String> getPersistenceClassSkippedProperties();

}
