package com.training.repository;

import com.training.entity.ECode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ECodeRepository extends JpaRepository<ECode, Long> {
    Optional<ECode> findByECode(long eCode);
}
