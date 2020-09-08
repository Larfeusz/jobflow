package com.larfeusz.jobflow.data;

import com.larfeusz.jobflow.jpa.JobDailyOfferRepository;
import com.larfeusz.jobflow.jpa.TagRepository;
import com.larfeusz.jobflow.jpa.WebsiteRepository;
import com.larfeusz.jobflow.model.Tag;
import com.larfeusz.jobflow.model.Website;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataCommnadLineApp implements CommandLineRunner {

    private TagRepository tagRepository;
    private WebsiteRepository websiteRepository;

    private JobDailyOfferRepository jobDailyOfferRepository;

    public DataCommnadLineApp(TagRepository tagRepository,
                              WebsiteRepository websiteRepository,
                              JobDailyOfferRepository jobDailyOfferRepository) {
        this.tagRepository = tagRepository;
        this.websiteRepository = websiteRepository;
        this.jobDailyOfferRepository = jobDailyOfferRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if ( !websiteRepository.findWebsiteBy("pracuj").isPresent()){
            websiteRepository.save(new Website("pracuj","http://pracuj.pl"));
        }
        String[] tags = {"java","ruby","project manager","hr","sprzataczka","progrmista"};

        for (String tag : tags) {
            if ( !tagRepository.findByName(tag).isPresent()){
                tagRepository.save(new Tag(tag));
            }
        }
    }
}
