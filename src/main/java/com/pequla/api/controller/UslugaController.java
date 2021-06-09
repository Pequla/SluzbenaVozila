package com.pequla.api.controller;

import com.pequla.api.entity.Usluga;
import com.pequla.api.service.UslugaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UslugaController {

    @Autowired
    private UslugaService service;

    @GetMapping(path = "/usluga")
    public List<Usluga> returnAll() {
        return service.findAll();
    }

    @GetMapping(path = "/usluga/{id}")
    public ResponseEntity<Usluga> returnById(@PathVariable int id) {
        return service.findOneById(id);
    }

    @GetMapping(path = "/usluga/opis/{opis}")
    public Usluga returnByOpis(@PathVariable String opis) {
        return service.findOneByOpis(opis);
    }

    @PostMapping(path = "/usluga")
    public Usluga create(@RequestHeader Usluga usluga) {
        return service.saveOne(usluga);
    }

    @PutMapping(path = "/usluga/{id}")
    public ResponseEntity<Usluga> update(@PathVariable int id, @RequestHeader Usluga usluga) {
        return service.updateOne(id,usluga);
    }

    @DeleteMapping(path = "/usluga/{id}")
    public void delete(@PathVariable int id) {
        service.deleteOne(id);
    }
}
