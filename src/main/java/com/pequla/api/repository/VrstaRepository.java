package com.pequla.api.repository;

import com.pequla.api.entity.Vrsta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrstaRepository extends CrudRepository<Vrsta, Integer> {
    Vrsta findOneByOpisIgnoreCase(String opis);
}
