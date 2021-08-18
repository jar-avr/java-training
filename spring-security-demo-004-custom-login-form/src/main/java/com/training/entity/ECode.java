package com.training.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="e_codes")
public class ECode {
    @Id
    @Column(name = "e_code", nullable = false)
    private Long eCode;

    @OneToMany(mappedBy="eCode")
    private Set<Person> persons;
}
