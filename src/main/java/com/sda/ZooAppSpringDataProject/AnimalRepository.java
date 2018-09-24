package com.sda.ZooAppSpringDataProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends MongoRepository<Animal, String> {

    Page<Animal> findAllBy(Pageable pageable);

    Page<Animal> findAllByAgeAndName(Pageable pageable, Integer age, String name);

    Page<Animal> findAllByAgeBetweenAndWeightBetween(Pageable pageable, Integer ageMin, Integer ageMax, Integer weightMin,
                                                     Integer weightMax);

    Page<Animal> findAllByWeightAndHeightAndNumberOfLegsBetween(Pageable pageable, Integer weight, Integer height,
                                                                Integer numberOfLegsMin, Integer numberOfLegsMax);

    Page<Animal> findAllByNameContainingAndCountry(Pageable pageable, String name, String country);

    Page<Animal> findAllByBirthBetween(Pageable pageable, LocalDate birthMin, LocalDate birthMax);

    Page<Animal> findAllByNameInAndCountry(Pageable pageable, List<String> namesList, String country);

    Page<Animal> findAllByWeightInAndHeightIn(Pageable pageable, List<Integer> weight, List<Integer> height);

    Page<Animal> findAllByNameOrCountryOrHeight(Pageable pageable, String name, String country, Integer height);

    Page<Animal> findAllByWeightLessThanOrHeightGreaterThan(Pageable pageable, Integer weight, Integer height);

    Page<Animal> findAllByNameOrNumberOfLegs(Pageable pageable, String name, Integer numberOfLegs);

    Page<Animal> findAllByBirthLessThanEqualOrBirthGreaterThanEqual(Pageable pageable, LocalDate birthLessEqual, LocalDate birthGreaterEqual);

    Page<Animal> findAllBySpeciesIn(Pageable pageable, List<String> speciesList);
}
