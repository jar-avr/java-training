package com.training.services;

import com.training.entity.ECode;
import com.training.repository.ECodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ECodeService {
    private final ECodeRepository eCodeRepository;

    @Autowired
    public ECodeService(ECodeRepository eCodeRepository) {
        this.eCodeRepository = eCodeRepository;
    }

    @PostConstruct
    public void init() {
        if (!eCodeRepository.findByECode(12345678).isPresent()) {
            eCodeRepository.save(ECode.builder()
                    .eCode(12345678L)
                    .build());
        }

        if (!eCodeRepository.findByECode(23456789).isPresent()) {
            eCodeRepository.save(ECode.builder()
                    .eCode(23456789L)
                    .build());
        }
    }

    public List<ECode> findAll() {
        return eCodeRepository.findAll();
    }
}
