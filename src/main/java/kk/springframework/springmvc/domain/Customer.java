package kk.springframework.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer implements DomainObject{

    private Integer id;

    private String firstName;

    private String lastName;

    private Address address;

    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String addressLine1;

        private String addressLine2;

        private String city;

        private String state;

        private Integer zipcode;

    }
}
