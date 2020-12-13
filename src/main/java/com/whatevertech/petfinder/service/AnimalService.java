package com.whatevertech.petfinder.service;

import com.whatevertech.petfinder.domain.Animal;
import com.whatevertech.petfinder.mapper.AnimalMapper;
import com.whatevertech.petfinder.repository.AnimalRepository;
import com.whatevertech.petfinder.request.AnimalRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> listAll() {
        return animalRepository.findAll();
    }

    public Animal finById(long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Animal não encontrado."));
    }

    public Animal save(AnimalRequest animalRequest) {

        return animalRepository.save(AnimalMapper.INSTANCE.toAnimal(animalRequest));
    }
}
