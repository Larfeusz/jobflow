package com.larfeusz.jobflow.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PracujPLService {


    public Integer getNumberOfJobs(String tagName, String city) throws IOException {
        String url = "https://www.pracuj.pl/praca/" +tagName+
                ";kw/"+city+";wp?rd=30";
        String numberText = Jsoup.connect(url).get().getElementsByClass("results-header__offer-count-text-number").first().text();

        return Integer.parseInt(numberText);
    }
    // Takie tam sprawdzenie czy faktycznie wyszukalo odpowiednia ilosc ogloszen
//    public static void main(String[] args) {
//        PracujPLService pracujPLService = new PracujPLService();
//        try {
//            System.out.println(pracujPLService.getNumberOfJobs("sprzątaczka", "warszawa"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
