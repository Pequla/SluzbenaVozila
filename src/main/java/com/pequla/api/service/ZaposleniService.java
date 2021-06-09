package com.pequla.api.service;

import com.pequla.api.entity.Zaposleni;
import com.pequla.api.repository.ZaposleniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZaposleniService {

    @Autowired
    private ZaposleniRepository repository;

    public List<Zaposleni> findAll() {
        return (List<Zaposleni>) repository.findAll();
    }

    public ResponseEntity<Zaposleni> findOneById(int id) {
        Optional<Zaposleni> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public Zaposleni saveOne(Zaposleni zaposleni) {
        return repository.save(zaposleni);
    }

    public void deleteOne(int id) {
        repository.deleteById(id);
    }

    public ResponseEntity<Zaposleni> updateOne(int id, Zaposleni zaposleni) {
        Optional<Zaposleni> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        zaposleni.setId(id);
        return ResponseEntity.ok(repository.save(zaposleni));
    }

    public Zaposleni findOneByIme(String ime) {
        return repository.findOneByImeIgnoreCase(ime);
    }

    public Zaposleni findOneByPrezime(String prezime) {
        return repository.findOneByPrezimeIgnoreCase(prezime);
    }

    public Zaposleni findOneByJmbg(String jmbg) {
        return repository.findOneByJmbg(jmbg);
    }
}
