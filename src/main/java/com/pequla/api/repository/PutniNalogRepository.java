package com.pequla.api.repository;

import com.pequla.api.entity.PutniNalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PutniNalogRepository extends CrudRepository<PutniNalog, Integer> {

    List<PutniNalog> findByKm(int km);
}
