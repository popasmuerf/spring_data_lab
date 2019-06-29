package io.thirdplanet.repos;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.thirdplanet.domain.BaseEntity;

import java.lang.reflect.*;

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

}