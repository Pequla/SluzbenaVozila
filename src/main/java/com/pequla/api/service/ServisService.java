package com.pequla.api.service;

import com.pequla.api.entity.Servis;
import com.pequla.api.repository.ServisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServisService {

    @Autowired
    private ServisRepository repository;

    public List<Servis> returnAll() {
        return (List<Servis>) repository.findAll();
    }

    public ResponseEntity<Servis> returnById(int id) {
        Optional<Servis> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public List<Servis> returnByKm(int km) {
        return repository.findAllByKm(km);
    }

    public Servis createOne(Servis servis) {
        return repository.save(servis);
    }

    public ResponseEntity<Servis> updateOne(int id, Servis servis) {
        Optional<Servis> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        servis.setId(id);
        return ResponseEntity.ok(repository.save(servis));
    }

    public void deleteOne(int id) {
        repository.deleteById(id);
    }

}
