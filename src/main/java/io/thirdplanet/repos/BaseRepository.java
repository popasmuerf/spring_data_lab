package io.thirdplanet.repos;

import java.io.Serializable;
import java.util.List;

import io.thirdplanet.domain.BaseEntity;

/*


*/

public interface BaseRepository<T extends BaseEntity, ID extends Serializable> {
    public T deleteById(ID id);
    public List<T> findAll() ;
    public T findById(ID id);
    public void persist(T entity);

}