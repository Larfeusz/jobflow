package com.larfeusz.jobflow.dto;


// DTO klasa, odpowiedzialna za zwracanie JSONa (DTO = Data Transfer Object - wzorzec obiektowy)


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDailyOfferDto {

    private String tagName;

    private String city;

    private Integer quantity;

    public JobDailyOfferDto(String tagName, String city, Integer quantity) {
        this.tagName = tagName;
        this.city = city;
        this.quantity = quantity;
    }

}
