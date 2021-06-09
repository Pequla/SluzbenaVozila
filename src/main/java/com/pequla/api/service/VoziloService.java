package com.pequla.api.service;

import com.pequla.api.entity.PutniNalog;
import com.pequla.api.entity.Servis;
import com.pequla.api.entity.Vozilo;
import com.pequla.api.repository.PutniNalogRepository;
import com.pequla.api.repository.ServisRepository;
import com.pequla.api.repository.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VoziloService {

    @Autowired
    private VoziloRepository repository;

    @Autowired
    private ServisRepository servisRepository;

    @Autowired
    private PutniNalogRepository putniNalogRepository;

    public List<Vozilo> returnAll() {
        return (List<Vozilo>) repository.findAll();
    }

    public ResponseEntity<Vozilo> returnById(int id) {
        Optional<Vozilo> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public Vozilo returnByBrojSasije(String brojSasije) {
        return repository.findOneByBrojSasijeIgnoreCase(brojSasije);
    }

    public List<Vozilo> returnByBrojSasijeContains(String brojSasije) {
        return repository.findOneByBrojSasijeContaining(brojSasije);
    }

    public Vozilo returnByRegistarskaOznaka(String registarskaOznaka) {
        return repository.findOneByRegistarskaOznakaIgnoreCase(registarskaOznaka);
    }

    public List<Vozilo> returnByRegistarskaOznakaContains(String registarskaOznaka) {
        return repository.findByRegistarskaOznakaContaining(registarskaOznaka);
    }

    public Vozilo createOne(Vozilo vozilo) {
        return repository.save(vozilo);
    }

    public ResponseEntity<Vozilo> updateOne(int id, Vozilo vozilo) {
        Optional<Vozilo> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        vozilo.setId(id);
        return ResponseEntity.ok(repository.save(vozilo));
    }

    public void deleteOne(int id) {
        repository.deleteById(id);
    }

    public Set<Vozilo> vozilaZaServis() {
        Set<Vozilo> vozila = new HashSet<>();
        // servis kada predju 45k km od poslednjeg servisa (odnosno ~90%)
        // poenta je da se upozori na vreme, jer auto treba servisirati uvek malo ranije
        List<Servis> sviServisi = (List<Servis>) servisRepository.findAll();
        List<PutniNalog> sviNalozi = (List<PutniNalog>) putniNalogRepository.findAll();
        for (PutniNalog nalog : sviNalozi) {
            if (nalog.getKm() > 45000) {
                long brojServisa = sviServisi.stream()
                        .filter(s -> s.getVozilo().getId() == nalog.getVozilo().getId()).count();
                long doSledeceg = nalog.getKm() - (brojServisa * 50000);
                if (doSledeceg > 45000) {
                    vozila.add(nalog.getVozilo());
                }
            }
        }
        return vozila;
    }

    public Set<Vozilo> vozilaZaProdaju() {
        Set<Vozilo> vozila = new HashSet<>();
        for (PutniNalog nalog : putniNalogRepository.findAll()) {
            if (nalog.getKm() > 300000) {
                vozila.add(nalog.getVozilo());
            }
        }
        return vozila;
    }
}
