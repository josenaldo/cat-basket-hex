package br.com.josenaldo.catbaskethex.adapter.in.web;

import br.com.josenaldo.catbaskethex.application.port.in.RegisterCatUseCase;

public class RegisterCatController {

    private final RegisterCatUseCase registerCatUseCase;

    public RegisterCatController(RegisterCatUseCase registerCatUseCase) {
        this.registerCatUseCase = registerCatUseCase;
    }
}
