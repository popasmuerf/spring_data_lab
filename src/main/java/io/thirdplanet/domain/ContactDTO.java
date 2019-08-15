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

//Entity
//@Table(name="contacts")
public class ContactDTO extends BaseEntity<Long>{
    //private static final String GeneratedType = null;

  
    @Getter @Setter
    private Long id ;

    @Getter @Setter
    private Address address ;
    
    @Getter @Setter
    private String emailAddress ;

    @Getter @Setter
    private String firstName ;

    @Getter @Setter
    private String lastName ;

    @Getter @Setter
    private String phoneNumber ;

    //@Getter @Setter
    //@Version
    //private long version ;
    //getters and setters...


    //builder method
    public static  Contact builder(){
        return new  Contact() ;
    }

    @Override
    public Long getId() {
        return null;
    }

	public String getFirstName() {
		return  firstName;
	}

	public String geLastName() {
		return lastName;
	}

	public String getStreetAddress() {
		return null;
	}

	public String getPostCode() {
		return null;
	}

	public String getState() {
		return null;
	}

	public String getCountry() {
		return null;
	}

    /*
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

    @Override
    public Long getId() {
        return null;
    }
 */

}