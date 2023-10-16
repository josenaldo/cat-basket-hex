package br.com.josenaldo.catbaskethex.adapter.in.web;

import br.com.josenaldo.catbaskethex.application.domain.model.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterCatRequest(
        @NotBlank(message = "Name is mandatory") String name,
        @NotNull(message = "Gender is mandatory") Gender gender,
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) LocalDate birthDate) {
}
