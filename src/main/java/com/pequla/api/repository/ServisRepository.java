package com.pequla.api.repository;

import com.pequla.api.entity.Servis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServisRepository extends CrudRepository<Servis, Integer> {

    List<Servis> findAllByKm(int km);

}
