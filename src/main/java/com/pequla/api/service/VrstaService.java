package com.pequla.api.service;

import com.pequla.api.entity.Vrsta;
import com.pequla.api.repository.VrstaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VrstaService {

    @Autowired
    private VrstaRepository repository;

    public List<Vrsta> findAll() {
        return (List<Vrsta>) repository.findAll();
    }

    public ResponseEntity<Vrsta> findOneById(int id) {
        Optional<Vrsta> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public Vrsta saveOne(Vrsta vrsta) {
        return repository.save(vrsta);
    }

    public void deleteOne(int id) {
        repository.deleteById(id);
    }

    public ResponseEntity<Vrsta> updateOne(int id, Vrsta vrsta) {
        Optional<Vrsta> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        vrsta.setId(id);
        return ResponseEntity.ok(repository.save(vrsta));
    }

    public Vrsta findOneByOpis(String opis) {
        return repository.findOneByOpisIgnoreCase(opis);
    }
}
