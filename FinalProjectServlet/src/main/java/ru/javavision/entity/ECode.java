package ru.javavision.entity;

import java.util.Set;

public class ECode {
    private Long eCode;

    private Set<Person> persons;

    public ECode(Long eCode, Set<Person> persons) {
        this.eCode = eCode;
        this.persons = persons;
    }

    public ECode() { }


    public Long getECode() {
        return eCode;
    }

    public void setECode(Long eCode) {
        this.eCode = eCode;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
