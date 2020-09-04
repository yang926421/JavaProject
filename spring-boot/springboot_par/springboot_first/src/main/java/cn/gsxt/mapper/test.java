//package BOOT-INF.classes.com.asb.gsxt.repository.impl;
//
//import com.asb.gsxt.config.SessionFactoryProps;
//import com.asb.gsxt.constant.TimeConstant;
//import com.asb.gsxt.repository.BaseRepository;
//import com.asb.gsxt.repository.impl.BaseRepositoryImpl;
//import com.asb.gsxt.util.Pager;
//import com.google.common.base.Preconditions;
//import com.xiaoleilu.hutool.util.StrUtil;
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//import javax.annotation.Resource;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.time.DateUtils;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.annotations.Cache;
//import org.hibernate.criterion.CriteriaSpecification;
//import org.hibernate.criterion.DetachedCriteria;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.ProjectionList;
//import org.hibernate.criterion.Projections;
//import org.hibernate.query.NativeQuery;
//import org.hibernate.query.Query;
//import org.hibernate.transform.AliasToBeanResultTransformer;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//
//
//
//
//
//
//
//
//
//
//abstract class BaseRepositoryImpl<T, PK extends Serializable>
//        extends Object
//        implements BaseRepository<T, PK>
//{
//    @Resource
//    private HibernateTemplate hibernateTemplate;
//    @Resource
//    private SessionFactoryProps sessionFactoryProps;
//    private Class<T> entityClass;
//
//    void setClazz(Class<T> clazzToSet) { this.entityClass = (Class)Preconditions.checkNotNull(clazzToSet); }
//
//
//
//
//
//
//    private Session getSession() { return this.hibernateTemplate.getSessionFactory().getCurrentSession(); }
//
//
//
//
//
//
//    public void save(T entity) throws Exception { this.hibernateTemplate.save(entity); }
//
//
//
//
//
//
//
//    public Collection<T> save(Collection<T> entities) throws Exception {
//        for (T entity : entities) {
//            save(entity);
//        }
//        return entities;
//    }
//
//
//
//
//
//    public void update(T entity) throws Exception { this.hibernateTemplate.saveOrUpdate(entity); }
//
//
//
//
//
//
//    public Collection<T> update(Collection<T> entities) throws Exception {
//        if (entities != null && entities.size() > 0) {
//            for (T entity : entities) {
//                update(entity);
//            }
//        }
//        return entities;
//    }
//
//
//
//
//
//    public void delete(PK pk) throws Exception {
//        T obj = (T)this.hibernateTemplate.get(this.entityClass, pk);
//        this.hibernateTemplate.delete(obj);
//    }
//
//
//
//
//
//
//
//    public void delete(T entity) throws Exception { this.hibernateTemplate.delete(entity); }
//
//
//
//
//
//
//
//    public void delete(List<T> entities) throws Exception {
//        if (entities != null && entities.size() > 0) {
//            for (T entity : entities) {
//                delete(entity);
//            }
//        }
//    }
//
//
//
//
//
//
//    public void delete(DetachedCriteria detachedCriteria) throws Exception {
//        Criteria criteria = getCriteria(detachedCriteria, null);
//        List<T> list = criteria.list();
//        if (list != null && list.size() > 0) {
//            for (T entity : list) {
//                delete(entity);
//            }
//        }
//    }
//
//
//
//
//
//
//    public List<T> find(String name, String value) throws Exception {
//        String sql = "from " + this.entityClass.getSimpleName() + " where " + name + "=:value";
//        Query query = getSession().createQuery(sql);
//        query.setParameter("value", value);
//
//        Cache[] cacheAnnotation = (Cache[])this.entityClass.getAnnotationsByType(Cache.class);
//        if (cacheAnnotation.length > 0 && this.sessionFactoryProps.isUseSecondLevelCache()) {
//            query.setCacheable(true);
//        }
//        return query.list();
//    }
//
//
//
//
//
//
//
//    public List<T> findList(DetachedCriteria detachedCriteria) throws Exception { return findList(detachedCriteria, null); }
//
//
//
//
//
//
//
//
//    public List<T> findList(DetachedCriteria detachedCriteria, List<String> propertyList) throws Exception {
//        Criteria criteria = getCriteria(detachedCriteria, propertyList);
//        return criteria.list();
//    }
//
//
//
//
//
//
//    public List<T> findListLimitRows(DetachedCriteria _criteria, Integer limit) throws Exception {
//        Criteria criteria = getCriteria(_criteria, null);
//
//        criteria.setFirstResult(0);
//        criteria.setMaxResults(limit.intValue());
//        return criteria.list();
//    }
//
//
//
//
//
//
//
//    public List<T> findListGroupBy(DetachedCriteria detachedCriteria, List<String> propertyList) throws Exception {
//        Criteria criteria = getCriteria(detachedCriteria, propertyList);
//        ProjectionList projectionList = Projections.projectionList();
//        for (String p : propertyList) {
//            projectionList.add(Projections.groupProperty(p).as(p));
//        }
//        criteria.setProjection(projectionList);
//        criteria.setResultTransformer(new AliasToBeanResultTransformer(this.entityClass));
//        return criteria.list();
//    }
//
//
//
//
//
//
//
//
//    public List<T> findListPager(DetachedCriteria detachedCriteria, Pager pager) throws Exception { return findListPager(detachedCriteria, pager, null); }
//
//
//
//
//
//
//
//
//
//    public List<T> findListPager(DetachedCriteria detachedCriteria, Pager pager, List<String> propertyList) throws Exception {
//        Criteria criteria = getCriteria(detachedCriteria, propertyList);
//
//        criteria.setProjection(Projections.rowCount());
//        pager.setTotalRecords(Integer.valueOf(criteria.uniqueResult().toString()).intValue());
//        criteria.setProjection(null);
//        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
//
//
//        criteria.setFirstResult((pager.getPage() - 1) * pager.getPageSize());
//        criteria.setMaxResults(pager.getPageSize());
//
//
//        if (StringUtils.isNotBlank(pager.getOrderby()) && pager.getOrderby().split(" ").length == 2) {
//            String[] orderBy = pager.getOrderby().split(" ");
//            pager.setOrderby(orderBy[1]);
//            pager.setOrderbyProperty(orderBy[0]);
//        }
//        if (StrUtil.isNotBlank(pager.getOrderby()) && Pager.Orderby.ASC.name().equalsIgnoreCase(pager.getOrderby()) && StringUtils.isNotBlank(pager.getOrderbyProperty())) {
//            String[] props = pager.getOrderbyProperty().split(",");
//            for (String prop : props) {
//                criteria.addOrder(Order.asc(prop));
//            }
//        } else if (StringUtils.isNotBlank(pager.getOrderby()) && Pager.Orderby.DESC.name().equalsIgnoreCase(pager.getOrderby()) && StringUtils.isNotBlank(pager.getOrderbyProperty())) {
//            String[] props = pager.getOrderbyProperty().split(",");
//            for (String prop : props) {
//                criteria.addOrder(Order.desc(prop));
//            }
//        }
//
//
//        if (propertyList != null && propertyList.size() > 0) {
//            ProjectionList projectionList = Projections.projectionList();
//            for (String prop : propertyList) {
//                projectionList.add(Projections.property(prop).as(prop));
//            }
//            criteria.setProjection(projectionList);
//            criteria.setResultTransformer(new AliasToBeanResultTransformer(this.entityClass));
//        }
//        return criteria.list();
//    }
//
//
//
//
//
//
//    public List<T> findAll() throws Exception { return findList(null, null); }
//
//
//
//
//
//
//
//
//    public T findById(PK pk) throws Exception { return (T)this.hibernateTemplate.get(this.entityClass, pk); }
//
//
//
//
//
//
//
//
//
//    public List<?> findByHql(String hql, Object... params) { return this.hibernateTemplate.find(hql, params); }
//
//
//
//
//
//
//
//
//
//    public List<?> findLimitRowsByHql(String hql, int rows, Object... params) {
//        this.hibernateTemplate.setMaxResults(rows);
//        List<?> list = this.hibernateTemplate.find(hql, params);
//        this.hibernateTemplate.setMaxResults(0);
//        return list;
//    }
//
//
//
//
//
//
//
//
//
//    public List<?> findPagerByHql(String hql, Pager pager, Object... params) throws Exception {
//        String cntHql = "select count(1) " + hql.substring(hql.indexOf("from"));
//        Query cntQuery = getSession().createQuery(cntHql);
//
//        Query query = getSession().createQuery(hql);
//        for (int i = 0; i < params.length; i++) {
//            if (params[i] instanceof String) {
//                query.setParameter(i, params[i].toString());
//                cntQuery.setParameter(i, params[i].toString());
//            } else if (params[i] instanceof Long) {
//                query.setParameter(i, Long.valueOf(params[i].toString()));
//                cntQuery.setParameter(i, Long.valueOf(params[i].toString()));
//            } else if (params[i] instanceof Integer) {
//                query.setParameter(i, Integer.valueOf(params[i].toString()));
//                cntQuery.setParameter(i, Integer.valueOf(params[i].toString()));
//            } else if (params[i] instanceof java.util.Date) {
//                query.setParameter(i, DateUtils.parseDate(params[i].toString(), TimeConstant.Y_M_D_HMS));
//                cntQuery.setParameter(i, DateUtils.parseDate(params[i].toString(), TimeConstant.Y_M_D_HMS));
//            } else if (params[i] instanceof Double) {
//                query.setParameter(i, Double.valueOf(params[i].toString()));
//                cntQuery.setParameter(i, Double.valueOf(params[i].toString()));
//            } else if (params[i] instanceof Float) {
//                query.setParameter(i, Float.valueOf(params[i].toString()));
//                cntQuery.setParameter(i, Float.valueOf(params[i].toString()));
//            } else if (params[i] instanceof Boolean) {
//                query.setParameter(i, Boolean.valueOf(params[i].toString()));
//                cntQuery.setParameter(i, Boolean.valueOf(params[i].toString()));
//            }
//        }
//
//        pager.setTotalRecords(Integer.valueOf(cntQuery.uniqueResult().toString()).intValue());
//
//        query.setFirstResult((pager.getPage() - 1) * pager.getPageSize());
//        query.setMaxResults(pager.getPageSize());
//        return query.list();
//    }
//
//
//
//
//
//
//
//    public List<?> findBySQL(String sql, Object... params) {
//        NativeQuery query = getSession().createNativeQuery(sql);
//        for (int i = 0; i < params.length; i++) {
//            if (params[i] instanceof String) {
//                query.setParameter(i + 1, params[i].toString());
//            } else if (params[i] instanceof Long) {
//                query.setParameter(i + 1, Long.valueOf(params[i].toString()));
//            } else if (params[i] instanceof Integer) {
//                query.setParameter(i + 1, Integer.valueOf(params[i].toString()));
//            } else if (params[i] instanceof java.util.Date) {
//                query.setParameter(i + 1, DateUtils.parseDate(params[i].toString(), TimeConstant.Y_M_D_HMS));
//            } else if (params[i] instanceof Double) {
//                query.setParameter(i + 1, Double.valueOf(params[i].toString()));
//            } else if (params[i] instanceof Float) {
//                query.setParameter(i + 1, Float.valueOf(params[i].toString()));
//            } else if (params[i] instanceof Boolean) {
//                query.setParameter(i + 1, Boolean.valueOf(params[i].toString()));
//            }
//        }
//        return query.list();
//    }
//
//
//
//
//
//    public int executeUpdate(String sql) throws Exception {
//        NativeQuery nativeQuery = getSession().createSQLQuery(sql);
//        return nativeQuery.executeUpdate();
//    }
//
//
//
//
//
//
//
//
//    public int executeUpdate(String hql, Object... params) { return this.hibernateTemplate.bulkUpdate(hql, params); }
//
//
//
//
//
//
//
//    public T findUnique(String name, Object value) throws Exception {
//        String sql = "from " + this.entityClass.getSimpleName() + " where " + name + "=:value";
//        Query query = getSession().createQuery(sql);
//
//        Cache[] cacheAnnotation = (Cache[])this.entityClass.getAnnotationsByType(Cache.class);
//        if (cacheAnnotation.length > 0 && this.sessionFactoryProps.isUseSecondLevelCache()) {
//            query.setCacheable(true);
//        }
//        query.setParameter("value", value);
//        return (T)query.uniqueResult();
//    }
//
//
//
//
//
//
//    public Long count(DetachedCriteria detachedCriteria) throws Exception {
//        Criteria criteria = getCriteria(detachedCriteria, null);
//        criteria.setProjection(Projections.rowCount());
//        return Long.valueOf(criteria.uniqueResult().toString());
//    }
//
//
//    private Criteria getCriteria(DetachedCriteria detachedCriteria, List<String> propertyList) throws Exception {
//        Criteria criteria;
//        if (detachedCriteria != null) {
//            criteria = detachedCriteria.getExecutableCriteria(getSession());
//        } else {
//            criteria = getSession().createCriteria(this.entityClass);
//        }
//
//        if (propertyList != null && propertyList.size() > 0) {
//            ProjectionList projectionList = Projections.projectionList();
//            for (String prop : propertyList) {
//                projectionList.add(Projections.property(prop).as(prop));
//            }
//            criteria.setProjection(projectionList);
//            criteria.setResultTransformer(new AliasToBeanResultTransformer(this.entityClass));
//        }
//
//        Cache[] cacheAnnotation = (Cache[])this.entityClass.getAnnotationsByType(Cache.class);
//        if (cacheAnnotation.length > 0 && this.sessionFactoryProps.isUseSecondLevelCache()) {
//            criteria.setCacheable(true);
//        }
//        return criteria;
//    }
//}
