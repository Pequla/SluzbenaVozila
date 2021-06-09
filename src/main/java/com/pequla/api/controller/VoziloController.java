package com.pequla.api.controller;

import com.pequla.api.entity.Vozilo;
import com.pequla.api.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
public class VoziloController {

    @Autowired
    private VoziloService service;

    // mapirano na /vozila takodje jer je mnogo prirodnije
    @GetMapping(path = {"/vozilo", "/vozila"})
    public List<Vozilo> returnAll() {
        return service.returnAll();
    }

    @GetMapping(path = "/vozilo/{id}")
    public ResponseEntity<Vozilo> returnById(@PathVariable int id) {
        return service.returnById(id);
    }

    @GetMapping(path = "/vozilo/sasija/{sasija}")
    public Vozilo returnByBrojSasije(@PathVariable String sasija) {
        return service.returnByBrojSasije(sasija);
    }

    @GetMapping(path = "/vozilo/sasija/contains/{sasija}")
    public List<Vozilo> returnByBrojSasijeContains(@PathVariable String sasija) {
        return service.returnByBrojSasijeContains(sasija);
    }

    @GetMapping(path = "/vozilo/regoz/{regoz}")
    public Vozilo returnByregistarskaOznaka(@PathVariable String regoz) {
        return service.returnByRegistarskaOznaka(regoz);
    }

    @GetMapping(path = "/vozilo/regoz/contains/{regoz}")
    public List<Vozilo> returnByregistarskaOznakaContains(@PathVariable String regoz) {
        return service.returnByRegistarskaOznakaContains(regoz);
    }

    @GetMapping(path = "/vozilo/za/servis")
    public Set<Vozilo> zaServis() {
        return service.vozilaZaServis();
    }

    @GetMapping(path = "/vozilo/za/prodaju")
    public Set<Vozilo> zaProdaju() {
        return service.vozilaZaProdaju();
    }

    @PostMapping(path = "/vozilo")
    public Vozilo createOne(@RequestBody Vozilo vozilo) {
        return service.createOne(vozilo);
    }

    @PutMapping(path = "/vozilo/{id}")
    public ResponseEntity<Vozilo> updateOne(@PathVariable int id, @RequestBody Vozilo vozilo) {
        return service.updateOne(id, vozilo);
    }

    @DeleteMapping(path = "/vozilo/{id}")
    public void deleteOne(@PathVariable int id) {
        service.deleteOne(id);
    }
}
