package com.pequla.api.service;

import com.pequla.api.entity.Radionica;
import com.pequla.api.repository.RadionicaReposiotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RadionicaService {

    @Autowired
    private RadionicaReposiotory repository;

    public List<Radionica> returnAll() {
        return (List<Radionica>) repository.findAll();
    }

    public ResponseEntity<Radionica> returnById(int id) {
        Optional<Radionica> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public Radionica returnByPib(int pib) {
        return repository.findOneByPib(pib);
    }

    public Radionica createOne(Radionica radionica) {
        return repository.save(radionica);
    }

    public ResponseEntity<Radionica> updateOne(int id, Radionica radionica) {
        Optional<Radionica> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        radionica.setId(id);
        return ResponseEntity.ok(repository.save(radionica));
    }

    public void deleteOne(int id) {
        repository.deleteById(id);
    }
}
