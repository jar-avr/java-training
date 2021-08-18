package com.training.repository;

import com.training.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "select * from users u " +
            "join persons p on u.id = p.user_id where e_code is null", nativeQuery = true)
    List<User> findAllByECodeIsNull();

//    @Modifying
//    @Query("update persons p set p.e_code = * from users u join persons p on u.id = p.user_id where e_code is null")
//    int setECode(@Param("ECode") int companyId, @Param("address") String address);
//    Optional<User> findByUsername(String username);
}
