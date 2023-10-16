package br.com.josenaldo.catbaskethex.adapter.in.web;

import br.com.josenaldo.catbaskethex.application.domain.model.Gender;

import java.time.LocalDate;
import java.util.UUID;

public record CatResponse(UUID id, String name, Gender gender, LocalDate birthDate) {
}
