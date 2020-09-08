package com.larfeusz.jobflow.jpa;

import com.larfeusz.jobflow.model.Tag;
import com.larfeusz.jobflow.service.PracujPLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Integer> {

    Optional<Tag> findByName(String name);

}
