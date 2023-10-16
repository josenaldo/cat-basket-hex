package br.com.josenaldo.catbaskethex.application.domain.model;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class Cat {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private Gender gender;

    @NotNull
    private LocalDate birthDate;

    public Cat(UUID id, String name, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Cat(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
