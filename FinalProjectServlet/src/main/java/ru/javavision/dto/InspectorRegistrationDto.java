package ru.javavision.dto;

import ru.javavision.constraint.PasswordMatches;
import ru.javavision.constraint.ValidEmail;

@PasswordMatches
public class InspectorRegistrationDto {
    private String firstName;

    private String lastName;

    private String password;
    private String matchingPassword;

    @ValidEmail
    private String email;

    public InspectorRegistrationDto() {
    }

    public InspectorRegistrationDto(String firstName, String lastName, String password, String matchingPassword, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private Role role;
}
