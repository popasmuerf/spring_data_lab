package io.thirdplanet.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="contacts")
public class Contact {
    private static final String GeneratedType = null;
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Getter @Setter
    private Long id ;

    @Getter @Setter
    private Address address ;
    
    @Getter @Setter
    @Column(name = "email_address",length = 100)
    private String emailAddress ;

    @Getter @Setter
    @Column(name = "first_name", nullable=false, length = 50)
    private String firstName ;

    @Getter @Setter
    @Column(name = "last_name", nullable=false, length = 100)
    private String lastName ;

    @Getter @Setter
    @Column(name = "phone_number",  length = 30)
    private String phoneNumber ;

    @Getter @Setter
    @Version
    private long version ;
    //getters and setters...


    //builder method
    public static  Contact builder(){
        return new  Contact() ;
    }

    
    public static class Builder{
        private Contact built  ;

        public Builder(String firstName, String lastName){
            built = new Contact() ;
            built.firstName = firstName ;
            built.lastName = lastName ;
        }

        public Builder address(String streetAddress, 
                                String postCode,
                                String postOffice,
                                String state,
                                String country){

                                Address address = Address.getBuilder(streetAddress
                                , postCode
                                , postOffice)
                                .state(state)
                                .country(country)
                                .build();
                                built.address = address ; 
                                  return this ;  
                                }


        public Builder emailAddress(String emailAddress){
            built.emailAddress = emailAddress ;
            return this ;
        }

        public Builder phoneNumber(String phoneNumber){
            built.phoneNumber = phoneNumber ;
            return this ;
        }

        public Contact build(){
            return built ;
        }
    }


    public static Builder getBuilder(String firstName, String lastName){
        return new Builder(firstName, lastName);
    }


    public void update(final String firstName, 
    final String lastName, 
    final String emailAddress, 
    final String phoneNumber){
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.emailAddress = emailAddress ;
        this.phoneNumber = phoneNumber ;
    }
    
    public void updateAddress(final String streetAddress,
    final String postCode,
    final String postOffice,
    final String state,
    final String country){
        if(address == null){
            address = new Address() ;
        }
        address.update(streetAddress,postCode,postOffice,state, country);
    }


}