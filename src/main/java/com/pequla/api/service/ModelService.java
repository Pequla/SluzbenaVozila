package com.pequla.api.service;

import com.pequla.api.entity.Model;
import com.pequla.api.entity.Vrsta;
import com.pequla.api.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepository repository;

    public List<Model> findAll() {
        return (List<Model>) repository.findAll();
    }

    public ResponseEntity<Model> findOneById(int id) {
        Optional<Model> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public Model findOneByTip(String tip) {
        return repository.findOneByTipIgnoreCase(tip);
    }

    public ResponseEntity<Vrsta> findVrstaByModelId(int id) {
        Optional<Model> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get().getVrsta());
    }

    public Vrsta findVrstaByModelTip(String tip) {
        return findOneByTip(tip).getVrsta();
    }

    public Model createOne(Model model) {
        return repository.save(model);
    }

    public ResponseEntity<Model> updateOne(int id, Model model) {
        Optional<Model> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        model.setId(id);
        return ResponseEntity.ok(repository.save(model));
    }

    public void deleteOne(int id) {
        repository.deleteById(id);
    }

}
