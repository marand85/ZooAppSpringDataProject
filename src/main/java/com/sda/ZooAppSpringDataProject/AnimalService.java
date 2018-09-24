package com.sda.ZooAppSpringDataProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    private AnimalRepository repository;

    @Autowired
    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public void createAnimal(CreateAnimalRequest request) {
        Animal animal = Animal.builder()
                .age(request.getAge())
                .birth(request.getBirth())
                .country(request.getCountry())
                .height(request.getHeight())
                .name(request.getName())
                .numberOfLegs(request.getNumberOfLegs())
                .species(request.getSpecies())
                .weight(request.getWeight())
                .id(UUID.randomUUID().toString())
                .build();
        repository.save(animal);
    }

    public Page<Animal> getAllAnimals(Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    public Page<Animal> findAnimals1(Pageable pageable, Integer age, String name) {
        return repository.findAllByAgeAndName(pageable, age, name);
    }

    public Page<Animal> findAnimals2(Pageable pageable, Integer ageMin, Integer ageMax, Integer weightMin, Integer weightMax) {
        return repository.findAllByAgeBetweenAndWeightBetween(pageable, ageMin, ageMax, weightMin, weightMax);
    }

    public Page<Animal> findAnimals3(Pageable pageable, Integer weight, Integer height, Integer numberOfLegsMin, Integer numberOfLegsMax) {
        return repository.findAllByWeightAndHeightAndNumberOfLegsBetween(pageable, weight, height, numberOfLegsMin, numberOfLegsMax);
    }

    public Page<Animal> findAnimals4(Pageable pageable, String name, String country) {
        return repository.findAllByNameContainingAndCountry(pageable, name, country);
    }

    public Page<Animal> findAnimals5(Pageable pageable, LocalDate birthMin, LocalDate birthMax) {
        return repository.findAllByBirthBetween(pageable, birthMin, birthMax);
    }

    public Page<Animal> findAnimals6(Pageable pageable, List<String> namesList, String country) {
        return repository.findAllByNameInAndCountry(pageable, namesList, country);
    }

    public Page<Animal> findAnimals7(Pageable pageable, List<Integer> weight, List<Integer> height) {
        return repository.findAllByWeightInAndHeightIn(pageable, weight, height);
    }

    public Page<Animal> findAnimals8(Pageable pageable, String name, String country, Integer height) {
        return repository.findAllByNameOrCountryOrHeight(pageable, name, country, height);
    }

    public Page<Animal> findAnimals9(Pageable pageable, Integer weight, Integer height) {
        return repository.findAllByWeightLessThanOrHeightGreaterThan(pageable, weight, height);
    }

    public Page<Animal> findAnimals10(Pageable pageable, String name, Integer numberOfLegs) {
        return repository.findAllByNameOrNumberOfLegs(pageable, name, numberOfLegs);
    }

    public Page<Animal> findAnimals11(Pageable pageable, LocalDate birthLessEqual, LocalDate birthGraterEqual) {
        return repository.findAllByBirthLessThanEqualOrBirthGreaterThanEqual(pageable, birthLessEqual, birthGraterEqual);
    }

    public Page<Animal> findAnimals12(Pageable pageable, List<String> speciesList) {
        return repository.findAllBySpeciesIn(pageable, speciesList);
    }

}
