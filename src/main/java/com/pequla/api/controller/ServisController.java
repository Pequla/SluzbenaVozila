package com.pequla.api.controller;

import com.pequla.api.entity.Servis;
import com.pequla.api.service.ServisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ServisController {

    @Autowired
    private ServisService service;

    @GetMapping(path = "/servis")
    public List<Servis> returnAll() {
        return service.returnAll();
    }

    @GetMapping(path = "/servis/{id}")
    public ResponseEntity<Servis> returnById(@PathVariable int id) {
        return service.returnById(id);
    }

    @GetMapping(path = "/servis/km/{km}")
    public List<Servis> returnByKm(@PathVariable int km) {
        return service.returnByKm(km);
    }

    @PostMapping(path = "/servis")
    public Servis createOne(@RequestBody Servis servis) {
        return service.createOne(servis);
    }

    @PutMapping(path = "/servis/{id}")
    public ResponseEntity<Servis> updateOne(@PathVariable int id, @RequestBody Servis servis) {
        return service.updateOne(id, servis);
    }

    @DeleteMapping(path = "/servis/{id}")
    public void deleteOne(@PathVariable int id) {
        service.deleteOne(id);
    }
}
