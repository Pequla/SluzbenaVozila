package com.pequla.api.controller;

import com.pequla.api.entity.Vrsta;
import com.pequla.api.service.VrstaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class VrstaController {

    @Autowired
    private VrstaService service;

    @GetMapping("/vrsta")
    public List<Vrsta> getAll() {
        return service.findAll();
    }

    @GetMapping("/vrsta/{id}")
    public ResponseEntity<Vrsta> findOne(@PathVariable int id) {
        return service.findOneById(id);
    }

    @GetMapping(path = "/vrsta/opis/{opis}")
    public Vrsta returnByOpis(@PathVariable String opis) {
        return service.findOneByOpis(opis);
    }

    @PostMapping("/vrsta")
    public Vrsta createNew(@RequestBody Vrsta vrsta) {
        return service.saveOne(vrsta);
    }

    @PutMapping(path = "/vrsta/{id}")
    public ResponseEntity<Vrsta> updateOne(@PathVariable int id, @RequestHeader Vrsta vrsta) {
        return service.updateOne(id, vrsta);
    }

    @DeleteMapping("/vrsta/{id}")
    public void deleteOne(@PathVariable int id) {
        service.deleteOne(id);
    }
}
