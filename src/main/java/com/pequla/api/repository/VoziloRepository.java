package com.pequla.api.repository;

import com.pequla.api.entity.Vozilo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoziloRepository extends CrudRepository<Vozilo, Integer> {

    // broj sasije i tablice je jednistven za svako vozilo
    Vozilo findOneByBrojSasijeIgnoreCase(String brojSasije);

    List<Vozilo> findOneByBrojSasijeContaining(String brojSasije);

    Vozilo findOneByRegistarskaOznakaIgnoreCase(String registarskaOznaka);

    List<Vozilo> findByRegistarskaOznakaContaining(String registarskaOznaka);

}
