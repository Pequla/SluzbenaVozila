package com.pequla.api.controller;

import com.pequla.api.entity.Model;
import com.pequla.api.entity.Vrsta;
import com.pequla.api.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ModelController {

    @Autowired
    private ModelService service;

    @GetMapping(path = "/model")
    public List<Model> returnAll() {
        return service.findAll();
    }

    @GetMapping(path = "/model/{id}")
    public ResponseEntity<Model> returnById(@PathVariable int id) {
        return service.findOneById(id);
    }

    @GetMapping(path = "/model/{id}/vrsta")
    public ResponseEntity<Vrsta> returnVrstaById(@PathVariable int id) {
        return service.findVrstaByModelId(id);
    }

    @GetMapping(path = "/model/tip/{tip}")
    public Model returnByTip(@PathVariable String tip) {
        return service.findOneByTip(tip);
    }

    @GetMapping(path = "/model/tip/{tip}/vrsta")
    public Vrsta returnVrstaByTip(@PathVariable String tip) {
        return service.findVrstaByModelTip(tip);
    }

    @PostMapping(path = "/model")
    public Model createOne(@RequestBody Model model) {
        return service.createOne(model);
    }

    @PutMapping(path = "/model/{id}")
    public ResponseEntity<Model> updateOne(@PathVariable int id, @RequestBody Model model) {
        return service.updateOne(id, model);
    }

    @DeleteMapping(path = "/model/{id}")
    public void deleteOne(@PathVariable int id) {
        service.deleteOne(id);
    }
}
