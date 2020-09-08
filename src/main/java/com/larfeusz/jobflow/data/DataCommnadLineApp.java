package com.larfeusz.jobflow.data;

import com.larfeusz.jobflow.jpa.JobDailyOfferRepository;
import com.larfeusz.jobflow.jpa.TagRepository;
import com.larfeusz.jobflow.jpa.WebsiteRepository;
import com.larfeusz.jobflow.model.JobDailyOffer;
import com.larfeusz.jobflow.model.Tag;
import com.larfeusz.jobflow.model.Website;
import com.larfeusz.jobflow.service.PracujPLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@Component
public class DataCommnadLineApp implements CommandLineRunner {

    private TagRepository tagRepository;
    private WebsiteRepository websiteRepository;

    private JobDailyOfferRepository jobDailyOfferRepository;

    @Autowired
    private PracujPLService pracujPlService;
    public DataCommnadLineApp(TagRepository tagRepository,
                              WebsiteRepository websiteRepository,
                              JobDailyOfferRepository jobDailyOfferRepository) {
        this.tagRepository = tagRepository;
        this.websiteRepository = websiteRepository;
        this.jobDailyOfferRepository = jobDailyOfferRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Website website;
        Tag tag;
        if (!websiteRepository.findWebsiteBy("pracuj").isPresent()) {
            website = websiteRepository.save(new Website("pracuj", "http://pracuj.pl"));
        } else {
            website = websiteRepository.findWebsiteBy("pracuj").get();
        }
        String[] tags = {"java", "ruby", "project menager", "hr", "sprzątaczka"
                , "programista"};
        String[] cities = {"warszawa", "kraków", "poznań", "gdańsk", "szczecin", "wrocław"};
        for (String tagName : tags) {
            if (!tagRepository.findByName(tagName).isPresent()) {
                tag = tagRepository.save(new Tag(tagName));
            } else {
                tag = tagRepository.findByName(tagName).get();
            }
            for (String city : cities) {
                addJobDailyOffer(tag,website,city);
            }
        }
    }
    private void addJobDailyOffer(Tag tag, Website website, String city){
        try {
            Integer numberOfOffers =
                    pracujPlService.getNumberOfJobs(tag.getName(),city);
            JobDailyOffer jobDailyOffer = new JobDailyOffer();
            jobDailyOffer.setCity(city);
            jobDailyOffer.setDate(LocalDate.now());
            jobDailyOffer.setNumber(numberOfOffers);
            jobDailyOffer.setTag(tag);
            jobDailyOffer.setWebsite(website);
            jobDailyOfferRepository.save(jobDailyOffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
