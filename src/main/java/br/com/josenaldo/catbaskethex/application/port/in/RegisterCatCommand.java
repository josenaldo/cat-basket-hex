package br.com.josenaldo.catbaskethex.application.port.in;

import br.com.josenaldo.catbaskethex.application.domain.model.Gender;
import br.com.josenaldo.catbaskethex.common.validation.Validator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record RegisterCatCommand(
        @NotBlank String name,
        @NotNull Gender gender,
        @PastOrPresent LocalDate birthDate) {

    public RegisterCatCommand(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        Validator.validate(this);
    }
}
