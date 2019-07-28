package io.thirdplanet.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


/*
    Designates a class whose mapping information is applied to the
    entities that inherit from it.

    A mapped superclass has no separate table defined for it.
    
    A Class designaed with the MappedSuperclass annotation can be mapped in the same way
    as an entity execpt that the mappings will apply only to its
    subclasses since no table exists for the mapped
    superclass itself.  When applied to the
    subclasses the inherited mappings  will apply in th econtext
    of the subclass tables.  Mapping information may be
    overridden in such subclasses by using the AttributedOverride
    and AssoicateonOverride annotations or corresponding XML
    elements...


    So long story short....annotating a class with
    @MappedSuperclass is a designation such that all
    subclasses will adher to the mappings found in their
    parent class.

    Below..it is stipulated within this code
    that all subclasses of BaseEntity<ID> shall 
    posses  a mapping for version.
*/
@MappedSuperclass
public abstract class BaseEntity<ID> {
    

    @Version 
    private Long version ;

    public abstract ID getId() ;


}