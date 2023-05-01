package com.example.demo.repository;

import com.example.demo.model.DictionaryUaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DictionaryUaRepository extends JpaRepository<DictionaryUaModel, UUID> {

    @Query("""
            from DictionaryUaModel d
            where d.caption ilike :caption
            order by d.caption
            """)
    List<DictionaryUaModel> findAllByCaptionILike(String caption);

    List<DictionaryUaModel> findAllByCaptionStartsWithIgnoreCaseOrderByCaption(String caption);

}
