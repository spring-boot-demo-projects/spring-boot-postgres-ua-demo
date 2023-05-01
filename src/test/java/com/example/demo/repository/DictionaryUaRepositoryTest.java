package com.example.demo.repository;

import com.example.demo.model.DictionaryUaModel;
import core.base.BaseIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@DataJpaTest
class DictionaryUaRepositoryTest extends BaseIntegrationTest {

    @Autowired
    DictionaryUaRepository repository;

    @Test
    void findAllOrderByCaptionAscTest() {
        final List<DictionaryUaModel> dictionaryItems = repository.findAll(Sort.by("caption"));
        Assertions.assertEquals("Аа", dictionaryItems.get(0).getCaption());
        Assertions.assertEquals("Аб", dictionaryItems.get(1).getCaption());
        Assertions.assertEquals("Га", dictionaryItems.get(2).getCaption());
        Assertions.assertEquals("Гб", dictionaryItems.get(3).getCaption());
        Assertions.assertEquals("Ґа", dictionaryItems.get(4).getCaption());
        Assertions.assertEquals("Ґб", dictionaryItems.get(5).getCaption());
        Assertions.assertEquals("Еа", dictionaryItems.get(6).getCaption());
        Assertions.assertEquals("Еб", dictionaryItems.get(7).getCaption());
        Assertions.assertEquals("Єа", dictionaryItems.get(8).getCaption());
        Assertions.assertEquals("Єб", dictionaryItems.get(9).getCaption());
        Assertions.assertEquals("Іа", dictionaryItems.get(10).getCaption());
        Assertions.assertEquals("Іб", dictionaryItems.get(11).getCaption());
        Assertions.assertEquals("Їа", dictionaryItems.get(12).getCaption());
        Assertions.assertEquals("Їб", dictionaryItems.get(13).getCaption());
        Assertions.assertEquals("Яа", dictionaryItems.get(14).getCaption());
        Assertions.assertEquals("Яб", dictionaryItems.get(15).getCaption());
    }

    @Test
    void findAllByCaptionILikeTest() {
        final List<DictionaryUaModel> result = repository.findAllByCaptionILike("ґ%");
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Ґа", result.get(0).getCaption());
        Assertions.assertEquals("Ґб", result.get(1).getCaption());
    }

    @Test
    void findAllByCaptionStartsWithIgnoreCaseOrderByCaptionTest() {
        final List<DictionaryUaModel> result = repository.findAllByCaptionStartsWithIgnoreCaseOrderByCaption("ґ");
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Ґа", result.get(0).getCaption());
        Assertions.assertEquals("Ґб", result.get(1).getCaption());
    }

}
