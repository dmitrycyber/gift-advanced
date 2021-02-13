package com.epam.esm.jpa.impl;

import com.epam.esm.jpa.GiftCertificateRepository;
import com.epam.esm.jpa.criteria.GiftCriteriaBuilder;
import com.epam.esm.model.entity.GiftCertificateEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        GiftCertificateRepositoryImpl.class,
        GiftCriteriaBuilder.class
})
@ExtendWith(SpringExtension.class)
class GiftCertificateRepositoryImplTest {
    @Autowired
    private GiftCertificateRepository giftCertificateRepository;

    @Test
    void findAll() {
        List<GiftCertificateEntity> allGifts = giftCertificateRepository.findAll(1, 2);
        Assertions.assertNotNull(allGifts);
        Assertions.assertEquals(5, allGifts.size());
        allGifts
                .forEach(giftCertificateEntity -> {
                    Assertions.assertTrue(giftCertificateEntity.getName().contains("name"));
                    Assertions.assertTrue(giftCertificateEntity.getDescription().contains("description"));
                    Assertions.assertNotNull(giftCertificateEntity.getId());
                    Assertions.assertNull(giftCertificateEntity.getCreateDate());
                    Assertions.assertNotNull(giftCertificateEntity.getPrice());
                    Assertions.assertNotNull(giftCertificateEntity.getDuration());
                });
    }

    @Test
    void findAndSortGifts() {
    }

    @Test
    void findById() {
    }

    @Test
    void createGift() {
    }

    @Test
    void updateGift() {
    }

    @Test
    void deleteGift() {
    }
}