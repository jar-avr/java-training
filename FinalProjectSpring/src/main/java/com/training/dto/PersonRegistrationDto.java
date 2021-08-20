package com.training.dto;

import com.training.constraint.PasswordMatches;
import com.training.entity.PersonType;
import lombok.*;

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
public class PersonRegistrationDto extends InspectorRegistrationDto {
    @Enumerated(EnumType.STRING)
    private PersonType personType;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String street;
}
