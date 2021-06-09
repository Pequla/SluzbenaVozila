package com.pequla.api.repository;

import com.pequla.api.entity.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends CrudRepository<Model, Integer> {
    //Pronalazi po tipu vozila, ovo je jednistvena vrednost u bazi
    Model findOneByTipIgnoreCase(String tip);
}
