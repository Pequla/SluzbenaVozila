package com.pequla.api.repository;

import com.pequla.api.entity.Usluga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UslugaRepository extends CrudRepository<Usluga, Integer> {
    Usluga findOneByOpisIgnoreCase(String opis);
}
