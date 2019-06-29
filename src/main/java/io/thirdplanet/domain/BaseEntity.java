package io.thirdplanet.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity<ID> {
    

    @Version 
    private Long version ;

    public abstract ID getId() ;


}