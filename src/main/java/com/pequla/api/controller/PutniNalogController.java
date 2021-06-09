package com.pequla.api.controller;

import com.pequla.api.entity.PutniNalog;
import com.pequla.api.service.PutniNalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PutniNalogController {

    @Autowired
    private PutniNalogService service;

    @GetMapping(path = "/nalog")
    public List<PutniNalog> returnAll() {
        return service.returnAll();
    }

    @GetMapping(path = "/nalog/{id}")
    public ResponseEntity<PutniNalog> returnById(@PathVariable int id) {
        return service.returnById(id);
    }

    @GetMapping(path = "/nalog/km/{km}")
    public List<PutniNalog> returnByKm(@PathVariable int km) {
        return service.returnByKm(km);
    }

    //Mora zaposleni imati dozvolu da vozi model tog tipa
    //Ako nema baca 400 Bad Request
    @PostMapping(path = "/nalog")
    public ResponseEntity<PutniNalog> createOne(@RequestBody PutniNalog nalog) {
        return service.createOne(nalog);
    }

    @PutMapping(path = "/nalog/{id}")
    public ResponseEntity<PutniNalog> updateOne(@PathVariable int id, @RequestBody PutniNalog nalog) {
        return service.updateOne(id, nalog);
    }

    @DeleteMapping(path = "/nalog/{id}")
    public void deleteOne(@PathVariable int id) {
        service.deleteOne(id);
    }
}
