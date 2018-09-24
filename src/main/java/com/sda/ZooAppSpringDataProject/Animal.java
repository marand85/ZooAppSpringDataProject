package com.sda.ZooAppSpringDataProject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "animals")
@Data
@AllArgsConstructor
@Builder
public class Animal {

    @Id
    private String id;

    private Species species;

    private Integer age;

    private String name;

    private String country;

    private Integer weight;

    private Integer height;

    private Integer numberOfLegs;

    @JsonDeserialize(using= LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birth;
}
