package com.whatevertech.petfinder.repository;

import com.whatevertech.petfinder.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
