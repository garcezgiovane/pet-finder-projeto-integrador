package com.whatevertech.petfinder.controller;

import com.whatevertech.petfinder.domain.Animal;
import com.whatevertech.petfinder.request.AnimalRequest;
import com.whatevertech.petfinder.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animais")
@CrossOrigin(origins = "*")
public class AnimalController {


    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> listAll() {
        return ResponseEntity.ok(animalService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable long id) {
        return ResponseEntity.ok(animalService.finById(id));
    }

    @PostMapping
    public  ResponseEntity<Animal> save(@RequestBody AnimalRequest animalRequest) {
        return new ResponseEntity<>(animalService.save(animalRequest), HttpStatus.CREATED);
    }


}
