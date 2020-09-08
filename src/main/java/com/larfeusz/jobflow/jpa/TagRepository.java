package com.larfeusz.jobflow.jpa;

import com.larfeusz.jobflow.model.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Integer> {
}
