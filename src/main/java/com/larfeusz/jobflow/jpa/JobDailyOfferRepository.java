package com.larfeusz.jobflow.jpa;

import com.larfeusz.jobflow.model.JobDailyOffer;
import org.springframework.data.repository.CrudRepository;

public interface JobDailyOfferRepository extends CrudRepository<JobDailyOffer,Integer> {
}
