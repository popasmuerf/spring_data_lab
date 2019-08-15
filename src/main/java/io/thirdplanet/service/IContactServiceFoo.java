
package io.thirdplanet.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import io.thirdplanet.domain.Contact;
import io.thirdplanet.domain.ContactDTO;

public interface IContactServiceFoo {

    public Contact add(ContactDTO added) ;
    public Contact deleteById(Long id ) throws NotFoundException; 
    public List<ContactDTO> findAll() ;
    public Contact findById(Long id) ;
    public Contact update(ContactDTO updated) throws javassist.NotFoundException ;
    

}