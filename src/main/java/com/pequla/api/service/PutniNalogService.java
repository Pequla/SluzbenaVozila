package com.pequla.api.service;

import com.pequla.api.entity.PutniNalog;
import com.pequla.api.repository.PutniNalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PutniNalogService {

    @Autowired
    private PutniNalogRepository repository;

    public List<PutniNalog> returnAll() {
        return (List<PutniNalog>) repository.findAll();
    }

    public ResponseEntity<PutniNalog> returnById(int id) {
        Optional<PutniNalog> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public List<PutniNalog> returnByKm(int km) {
        return repository.findByKm(km);
    }

    public ResponseEntity<PutniNalog> createOne(PutniNalog nalog) {
        int zaposleni = nalog.getZaposleni().getOvlascenje();
        int vozilo = nalog.getVozilo().getModel().getVrsta().getId();

        if (zaposleni >= vozilo) {
            return ResponseEntity.ok(repository.save(nalog));
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<PutniNalog> updateOne(int id, PutniNalog nalog) {
        Optional<PutniNalog> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        nalog.setId(id);
        return ResponseEntity.ok(repository.save(nalog));
    }

    public void deleteOne(int id) {
        repository.deleteById(id);
    }
}
