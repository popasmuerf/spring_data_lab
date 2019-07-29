package io.thirdplanet.repos;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.thirdplanet.domain.BaseEntity;

import java.lang.reflect.*;
import java.util.List;


/*
 * This example shows use of @PresistenceContext
 * to have an EntityManager with an EXTENDED persistence
 * context injected inot a @Stateful bean.
 * A JPA @Entity bean is used with the EntityManager to
 * create, persist and merge data to a database.
 */

public abstract class BaseRepositoryImpl<T extends BaseEntity, ID extends Serializable>
        implements BaseRepository<T, ID> {

    private Class<T> entityClass;

    @PersistenceContext(unitName = "pu")
    private EntityManager em ;

    public void BaseDAOImpl() {
        this.entityClass = ((Class<T>) ((ParameterizedType) getClass()
        .getGenericSuperclass())
        .getActualTypeArguments()[0]);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T deleteById(ID id){
        T entity = findById(id);
        if(entity != null){
            em.remove(entity);
        }
        return entity ;
    }


    @Override
    public List<T> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        return em.createQuery(query).getResultList() ;        
    }


    @Override
    public T findById(ID id){
        return em.find(getEntityClass(), id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void persist(T entity){
        em.persist(entity);
    }

    protected Class<T> getEntityClass(){
        return entityClass;
    }
    
    protected EntityManager gEntityManager(){
        return em ;
    }

}