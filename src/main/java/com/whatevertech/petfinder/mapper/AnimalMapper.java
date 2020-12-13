package com.whatevertech.petfinder.mapper;

import com.whatevertech.petfinder.domain.Animal;
import com.whatevertech.petfinder.request.AnimalRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimalMapper {

    public static final  AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    public abstract Animal toAnimal(AnimalRequest animalRequest);
}
