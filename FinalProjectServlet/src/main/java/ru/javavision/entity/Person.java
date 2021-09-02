package ru.javavision.entity;

import java.util.Set;

public class Person {
    private Long id;
    private PersonType personType;
    private ECode eCode;
    private String city;
    private String street;
    private User user;
    private Set<Report> reports;

    public Person() { }

    public Person(Long id) {
        this.id = id;
    }

    public Person(Long id, PersonType personType, ECode eCode, String city, String street, User user, Set<Report> reports) {
        this.id = id;
        this.personType = personType;
        this.eCode = eCode;
        this.city = city;
        this.street = street;
        this.user = user;
        this.reports = reports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public ECode getECode() {
        return eCode;
    }

    public void setECode(ECode eCode) {
        this.eCode = eCode;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }
}
