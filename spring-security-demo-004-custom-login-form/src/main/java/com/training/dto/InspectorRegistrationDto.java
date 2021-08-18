package com.training.dto;

import com.training.constraint.PasswordMatches;
import com.training.constraint.ValidEmail;
import com.training.entity.PersonType;
import com.training.entity.Role;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@PasswordMatches
public class InspectorRegistrationDto {
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private Role role;
}
