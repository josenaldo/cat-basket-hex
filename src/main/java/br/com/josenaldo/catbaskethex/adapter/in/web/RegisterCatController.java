package br.com.josenaldo.catbaskethex.adapter.in.web;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;
import br.com.josenaldo.catbaskethex.application.port.in.RegisterCatCommand;
import br.com.josenaldo.catbaskethex.application.port.in.RegisterCatUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterCatController {

    private final RegisterCatUseCase registerCatUseCase;

    public RegisterCatController(RegisterCatUseCase registerCatUseCase) {
        this.registerCatUseCase = registerCatUseCase;
    }

    @PostMapping("/cats")
    public CatResponse registerCat(@Valid @RequestBody RegisterCatRequest request) {

        RegisterCatCommand registerCatCommand = toCommand(request);

        Cat registeredCat = registerCatUseCase.registerCat(registerCatCommand);

        return toResponse(registeredCat);

    }

    private RegisterCatCommand toCommand(RegisterCatRequest request) {
        return new RegisterCatCommand(request.name(), request.gender(), request.birthDate());
    }

    private CatResponse toResponse(Cat cat) {
        return new CatResponse(cat.getId(), cat.getName(), cat.getGender(), cat.getBirthDate() );
    }
}

