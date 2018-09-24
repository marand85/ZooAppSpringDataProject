package com.sda.ZooAppSpringDataProject;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Validated
public class CreateAnimalRequest {

    @NotNull
    private Species species;

    @NotNull
    private Integer age;

    @NotNull
    private String name;

    @NotNull
    private String country;

    @NotNull
    private Integer weight;

    @NotNull
    private Integer height;

    @NotNull
    private Integer numberOfLegs;

    @NotNull
    @JsonDeserialize(using= LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birth;

}
