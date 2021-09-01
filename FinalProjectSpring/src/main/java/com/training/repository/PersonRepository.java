package com.training.repository;

import com.training.entity.Person;
import com.training.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("update Person p set p.eCode = :eCode where p.id = :id")
    void updateECodeWherePersonId(long id, long eCode);
}
