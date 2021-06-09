package com.pequla.api.service;

import com.pequla.api.entity.Usluga;
import com.pequla.api.repository.UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UslugaService {

    @Autowired
    private UslugaRepository repository;

    public List<Usluga> findAll() {
        return (List<Usluga>) repository.findAll();
    }

    public ResponseEntity<Usluga> findOneById(int id) {
        Optional<Usluga> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public Usluga saveOne(Usluga usluga) {
        return repository.save(usluga);
    }

    public void deleteOne(int id) {
        repository.deleteById(id);
    }

    public ResponseEntity<Usluga> updateOne(int id, Usluga usluga) {
        Optional<Usluga> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usluga.setId(id);
        return ResponseEntity.ok(repository.save(usluga));
    }

    public Usluga findOneByOpis(String opis) {
        return repository.findOneByOpisIgnoreCase(opis);
    }

}
