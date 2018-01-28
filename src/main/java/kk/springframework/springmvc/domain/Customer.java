package kk.springframework.springmvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer implements DomainObject{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Version
    private Integer version;
    private String firstName;

    private String lastName;

    /**
     * TODO
     * Removing address as a separate class and thus a separate table created by JPA
     * Will add this back once learned about mapping relationship using JPA
     */
    //private Address address;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private Integer zipcode;

    public Customer(
            String firstName, String lastName, String addressLine1, String addressLine2, String city,
            String state, Integer zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    @Data
    @NoArgsConstructor
    @Entity
    public static class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        private String addressLine1;

        private String addressLine2;

        private String city;

        private String state;

        private Integer zipcode;

        public Address(String addressLine1, String addressLine2, String city, String state, Integer zipcode) {
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
            this.state = state;
            this.zipcode = zipcode;
        }
    }
}
