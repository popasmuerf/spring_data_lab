package io.thirdplanet.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.thirdplanet.domain.Contact;
import io.thirdplanet.domain.ContactDTO;

/*
    void delete(Contact contact) ;
    Contact findOne(Long id) ;
    Contact fidnById(Long id) ;
    List<Contact> findAll() ;
    Contact save(Contact contact)

*/
public interface IContactRepositoryFoo extends JpaRepository<ContactDTO, Long> {

	public Contact save(Contact contact) ;
}