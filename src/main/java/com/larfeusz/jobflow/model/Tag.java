package com.larfeusz.jobflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Tag {
    // klasa wyszukująca oferty pracy po danym tagu -> słowie kluczowym, nazwie stnowiska

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // sposób generowania id i nie beda wspoldzielone przez kilka modeli
    private Integer id;

    public Tag(String name) {
        this.name = name;
    }

    @JsonProperty("nazwa") // jaka nazwa ma być wyświetlana w Jsonie
    private String name;

    @JsonIgnore
    private String description;


}
