package io.thirdplanet.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/*

The Address class is an embedded class that is used
to store address information.  An embedded class is a clas that
can be presisted only with its parent class.  Embedded
dlasses are typically used to present the common concepts
of the domain model  and to emphasize its object-oriented 
nature.  The source code of the Address class is given as
follows:


*/








@Embeddable
public class Address{


    @Getter @Setter
    @Column(name = "country", length = 20)
    private String country ;


    @Getter @Setter
    @Column(name = "street_address", length = 150)
    private String streetAddress ;


    @Getter @Setter
    @Column(name = "post_code", length = 10)
    private String postCode ;


    @Getter @Setter
    @Column(name = "post_office", length = 40)
    private String postOffice ;

    @Getter @Setter
    @Column(name = "state", length = 20)
    private String state ;


    public Address(){}
    public Address(String country,
                    String streetAddress,
                    String postCode,
                    String postOffice,
                    String state ){
                        this.country = country ;
                        this.streetAddress = streetAddress;
                        this.postCode = postCode;
                        this.postOffice = postOffice ;
                        this.state = state ;
                    }


    public static Builder getBuilder(String streetAddress,
                                    String postCode,
                                    String postOffice ){
        Builder builder = new Builder(streetAddress,
                                      postCode,
                                      postOffice);

        return builder ;
    }

    public  static class  Builder{
        private Address built ;

        public Builder(
        String streetAddress,
        String postCode,
        String postOffice ){
            built = new Address() ;
            built.streetAddress = streetAddress ;
            built.postCode = postCode ;
            built.postOffice = postOffice ;
        }//end builder constructor


        public Builder country(String country){
            built.country = country ;
            return this  ;
        }

        public Builder state(String state){
            built.state = state ;
            return this  ;
        }

        public Address build(){
            return built ;
        }

    } //end inner-Builder class             

   public void update(final String streetAddress,
                      final String postCode,
                      final String postOffice,
                      final String state,
                      final String country ){

            this.streetAddress = streetAddress ;
            this.postCode = postCode ;
            this.postOffice = postOffice ;
            this.state = state ;
            this.country = country ;

    }

}//end class