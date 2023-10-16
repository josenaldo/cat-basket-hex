package br.com.josenaldo.catbaskethex.application.domain.service;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;
import br.com.josenaldo.catbaskethex.application.port.in.RegisterCatUseCase;
import br.com.josenaldo.catbaskethex.application.port.out.CreateCatPort;
import jakarta.transaction.Transactional;

@Transactional
public class RegisterCatService implements RegisterCatUseCase {
    private final CreateCatPort createCatPort;

    public RegisterCatService(CreateCatPort createCatPort) {
        this.createCatPort = createCatPort;
    }

    @Override
    public Cat registerCat(Cat cat) {

        return createCatPort.createCat(cat);
    }
}
