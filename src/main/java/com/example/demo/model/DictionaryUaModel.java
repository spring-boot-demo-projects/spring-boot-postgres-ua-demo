package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.domain.Persistable;

import java.util.UUID;

import static java.util.Objects.isNull;

@Entity
@SuppressWarnings("unused")
@Table(name = "dictionary_ua")
public class DictionaryUaModel implements Persistable<UUID> {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "number")
    private Long number;
    @Column(name = "caption")
    private String caption;

    @Override
    public boolean isNew() {
        return isNull(id);
    }

    /* Getters and setters */
    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    /* To String */
    @Override
    public String toString() {
        return "DictionaryUaModel{" +
               "id=" + id +
               ", number=" + number +
               ", caption='" + caption + '\'' +
               '}';
    }

}
