package com.training.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="persons")
public class Person {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PersonType personType;

    @ManyToOne
    @JoinColumn(name="e_code")
    private ECode eCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy="person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Report> reports;
}
