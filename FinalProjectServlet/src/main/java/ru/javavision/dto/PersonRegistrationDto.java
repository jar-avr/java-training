package ru.javavision.dto;

import ru.javavision.constraint.PasswordMatches;
import ru.javavision.entity.PersonType;

@PasswordMatches
public class PersonRegistrationDto extends InspectorRegistrationDto {
    private PersonType personType;
    private String city;
    private String street;

    public PersonRegistrationDto(String firstName, String lastName, String personType, String city, String street, String email, String pass, String matchingPass) {
        super(firstName, lastName, pass, matchingPass, email);
        this.personType = PersonType.valueOf(personType);
        this.city = city;
        this.street = street;

    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
