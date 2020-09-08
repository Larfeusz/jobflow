package com.larfeusz.jobflow.jpa;

import com.larfeusz.jobflow.model.Website;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WebsiteRepository extends CrudRepository<Website, Integer> {

    @Query(value = "SELECT*FROM website Where name=?1 LIMIT 1",nativeQuery = true)
        // oznacza "UŻYJ SQLa zamiast HSQL <- HibernateSQL
        // name=?1 -

    Optional<Website> findWebsiteBy(String name);

}
