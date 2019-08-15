package io.thirdplanet.service;

import java.util.List;

import javax.annotation.Resource;

import com.google.common.collect.ImmutableBiMap.Builder;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.thirdplanet.domain.Contact;
import io.thirdplanet.domain.ContactDTO;
import io.thirdplanet.repos.ContactRepository;

import io.thirdplanet.repos.IContactRepositoryFoo;

@Service
public class ContactServiceFooImpl implements ContactService {

    @Resource
    private IContactRepositoryFoo repoFoo ;

    @Transactional
    @Override
    public Contact add(ContactDTO newContact) {
        String firstName = newContact.getFirstName() ;
        String lastName = newContact.geLastName();


        Contact contact = Contact.getBuilder(firstName, lastName)
       .address(newContact.getStreetAddress(), 
                newContact.getPostCode(), 
                newContact.getPostCode(), 
                newContact.getState(), 
                newContact.getCountry()).build();

        return repoFoo.save(contact);
       
       


        
    }

    @Transactional
    @Override
    public Contact deleteById(Long id) throws NotFoundException {
        return null;
    }

    @Transactional
    @Override
    public List<ContactDTO> findAll() {
        return null;
    }

    @Transactional
    @Override
    public Contact findById(Long id) {
        return null;
    }

    @Transactional
	@Override
	public Contact update(ContactDTO updated) throws javassist.NotFoundException {
		return null;
	}

}