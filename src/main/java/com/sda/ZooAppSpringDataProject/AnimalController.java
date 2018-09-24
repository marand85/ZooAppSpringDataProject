package com.sda.ZooAppSpringDataProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAnimal(@RequestBody CreateAnimalRequest request) {
        animalService.createAnimal(request);
    }

    // Request example: http://localhost:8080/all
    @GetMapping("/all")
    public Page<Animal> findAllAnimals(@PageableDefault(size = 5) Pageable pageable) {
        return animalService.getAllAnimals(pageable);
    }

    // Request example: http://localhost:8080/findAnimals1?age=2&name=Tweety
    @GetMapping("/findAnimals1")
    public Page<Animal> findAnimals1(@PageableDefault(size = 5) Pageable pageable,
                                     @RequestParam Integer age, String name) {
        return animalService.findAnimals1(pageable, age, name);
    }

    // Request example: http://localhost:8080/findAnimals2?ageMin=10&ageMax=30&weightMin=20&weightMax=40
    @GetMapping("/findAnimals2")
    public Page<Animal> findAnimals2(@PageableDefault(size = 5) Pageable pageable, @RequestParam Integer ageMin, Integer ageMax,
                                     Integer weightMin, Integer weightMax) {
        return animalService.findAnimals2(pageable, ageMin, ageMax, weightMin, weightMax);
    }

    // Request example: http://localhost:8080/findAnimals3?weight=2&height=20&numberOfLegsMin=3&numberOfLegsMax=5
    @GetMapping("/findAnimals3")
    public Page<Animal> findAnimals3(@PageableDefault(size = 5) Pageable pageable, @RequestParam Integer weight, Integer height,
                                     Integer numberOfLegsMin, Integer numberOfLegsMax) {
        return animalService.findAnimals3(pageable, weight, height, numberOfLegsMin, numberOfLegsMax);
    }

    // Request example: http://localhost:8080/findAnimals4?name=To&country=Poland
    @GetMapping("/findAnimals4")
    public Page<Animal> findAnimals4(@PageableDefault(size = 5) Pageable pageable, @RequestParam String name, String country) {
        return animalService.findAnimals4(pageable, name, country);
    }

    // Request example:  http://localhost:8080/findAnimals5?birthMin=2000-01-01&birthMax=2009-12-31
    @GetMapping("/findAnimals5")
    public Page<Animal> findAnimals5(@PageableDefault(size = 5) Pageable pageable, @RequestParam String birthMin, String birthMax) {
        //default, ISO_LOCAL_DATE
        LocalDate localDateBirthMin = LocalDate.parse(birthMin);
        LocalDate localDateBirthMax = LocalDate.parse(birthMax);
        return animalService.findAnimals5(pageable, localDateBirthMin, localDateBirthMax);
    }

    // Request example: http://localhost:8080/findAnimals6?name=Barry,Goofy&country=USA
    @GetMapping("/findAnimals6")
    public Page<Animal> findAnimals6(@PageableDefault(size = 5) Pageable pageable, @RequestParam String name, String country) {
        String[] stringArray = name.split(",");
        List<String> namesList = Arrays.asList(stringArray);
        return animalService.findAnimals6(pageable, namesList, country);
    }

    // Request example: http://localhost:8080/findAnimals7?weight=1,30,700&height=1,200
    @GetMapping("/findAnimals7")
    public Page<Animal> findAnimals7(@PageableDefault(size = 5) Pageable pageable, @RequestParam String weight, String height) {

        String[] weightStringArray = weight.split(",");
        String[] heightStringArray = height.split(",");

        List<String> weightStringList = Arrays.asList(weightStringArray);
        List<Integer> weightList;
        weightList = weightStringList.stream()
                .map(w -> Integer.valueOf(w))
                .collect(toList());

        List<String> heightStringList = Arrays.asList(heightStringArray);
        List<Integer> heightList;
        heightList = heightStringList.stream()
                .map(h -> Integer.valueOf(h))
                .collect(toList());

        return animalService.findAnimals7(pageable, weightList, heightList);
    }

    // Request example: http://localhost:8080/findAnimals8?name=Chupacabra&country=Germany&height=200
    @GetMapping("/findAnimals8")
    public Page<Animal> findAnimals8(@PageableDefault(size = 5) Pageable pageable, @RequestParam String name, String country, Integer height) {
        return animalService.findAnimals8(pageable, name, country, height);
    }

    // Request example: http://localhost:8080/findAnimals9?weight=2&height=199&page=0
    @GetMapping("/findAnimals9")
    public Page<Animal> findAnimals9(@PageableDefault(size = 5) Pageable pageable, @RequestParam Integer weight, Integer height) {
        return animalService.findAnimals9(pageable, weight, height);
    }

    // Request example: http://localhost:8080/findAnimals10?name=Gecko&numberOfLegs=2
    @GetMapping("/findAnimals10")
    public Page<Animal> findAnimals10(@PageableDefault(size = 5) Pageable pageable, @RequestParam String name, Integer numberOfLegs) {
        return animalService.findAnimals10(pageable, name, numberOfLegs);
    }

    //  Request example: http://localhost:8080/findAnimals11?birthLessEqual=2001-12-31&birthGreaterEqual=2018-01-01
    @GetMapping("/findAnimals11")
    public Page<Animal> findAnimals11(@PageableDefault(size = 5) Pageable pageable, @RequestParam String birthLessEqual, String birthGreaterEqual) {
        //default, ISO_LOCAL_DATE
        LocalDate localDateBirthLessEqual = LocalDate.parse(birthLessEqual);
        LocalDate localDateBirthGreaterEqual = LocalDate.parse(birthGreaterEqual);
        return animalService.findAnimals11(pageable, localDateBirthLessEqual, localDateBirthGreaterEqual);
    }

    // Request example: http://localhost:8080/findAnimals12?species=MAMMAL,BIRD
    @GetMapping("/findAnimals12")
    public Page<Animal> findAnimals12(@PageableDefault(size = 5) Pageable pageable, @RequestParam String species) {
        String[] speciesStringArray = species.split(",");
        List<String> speciesList = Arrays.asList(speciesStringArray);
        return animalService.findAnimals12(pageable, speciesList);
    }
}
