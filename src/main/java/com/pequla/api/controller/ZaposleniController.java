package com.pequla.api.controller;

import com.pequla.api.entity.Zaposleni;
import com.pequla.api.service.ZaposleniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ZaposleniController {

    @Autowired
    private ZaposleniService service;

    @GetMapping(path = "/zaposleni")
    public List<Zaposleni> returnAll() {
        return service.findAll();
    }

    @GetMapping(path = "/zaposleni/{id}")
    public ResponseEntity<Zaposleni> returnById(@PathVariable int id) {
        return service.findOneById(id);
    }

    @GetMapping(path = "/zaposleni/ime/{ime}")
    public Zaposleni returnByIme(@PathVariable String ime) {
        return service.findOneByIme(ime);
    }

    @GetMapping(path = "/zaposleni/prezime/{prezime}")
    public Zaposleni returnByPrezime(@PathVariable String prezime) {
        return service.findOneByPrezime(prezime);
    }

    @GetMapping(path = "/zaposleni/jmbg/{jmbg}")
    public Zaposleni returnByJmbg(@PathVariable String jmbg) {
        return service.findOneByJmbg(jmbg);
    }

    @PostMapping(path = "/zaposleni")
    public Zaposleni create(@RequestHeader Zaposleni zaposleni) {
        return service.saveOne(zaposleni);
    }

    @PutMapping(path = "/zaposleni/{id}")
    public ResponseEntity<Zaposleni> update(@PathVariable int id, @RequestHeader Zaposleni zaposleni) {
        return service.updateOne(id, zaposleni);
    }

    @DeleteMapping(path = "/zaposleni/{id}")
    public void delete(@PathVariable int id) {
        service.deleteOne(id);
    }
}
