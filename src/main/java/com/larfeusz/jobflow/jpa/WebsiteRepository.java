package com.larfeusz.jobflow.jpa;

import com.larfeusz.jobflow.model.Website;
import org.springframework.data.repository.CrudRepository;

public interface WebsiteRepository extends CrudRepository<Website,Integer> {
}
