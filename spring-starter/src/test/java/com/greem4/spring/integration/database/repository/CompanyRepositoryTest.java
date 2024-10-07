package com.greem4.spring.integration.database.repository;

import com.greem4.spring.database.entity.Company;
import com.greem4.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
//@Commit
class CompanyRepositoryTest {

    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;

    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx -> {
                var company = entityManager.find(Company.class, 1);
                assertNotNull(company);
                assertThat(company.getLocales()).hasSize(2);
        });
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple descriptions"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}