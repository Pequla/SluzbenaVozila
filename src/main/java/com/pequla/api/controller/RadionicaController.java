package com.pequla.api.controller;

import com.pequla.api.entity.Radionica;
import com.pequla.api.service.RadionicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RadionicaController {

    @Autowired
    private RadionicaService service;

    @GetMapping(path = "/radionica")
    public List<Radionica> returnAll() {
        return service.returnAll();
    }

    @GetMapping(path = "/radionica/{id}")
    public ResponseEntity<Radionica> returnById(@PathVariable int id) {
        return service.returnById(id);
    }

    @GetMapping(path = "/radionica/pib/{pib}")
    public Radionica returnByPib(@PathVariable int pib) {
        return service.returnByPib(pib);
    }

    @PostMapping(path = "/radionica")
    public Radionica createOne(@RequestBody Radionica radionica) {
        return service.createOne(radionica);
    }

    @PutMapping(path = "/radionica/{id}")
    public ResponseEntity<Radionica> updateOne(@PathVariable int id, @RequestBody Radionica radionica) {
        return service.updateOne(id, radionica);
    }

    @DeleteMapping(path = "/radionica/{id}")
    public void deleteOne(@PathVariable int id) {
        service.deleteOne(id);
    }
}
