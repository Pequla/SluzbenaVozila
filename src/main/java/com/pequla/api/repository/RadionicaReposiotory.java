package com.pequla.api.repository;

import com.pequla.api.entity.Radionica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadionicaReposiotory extends CrudRepository<Radionica, Integer> {

    // Svaka firma ima jednistveni pib u Republici Srbiji
    Radionica findOneByPib(int pib);
}
