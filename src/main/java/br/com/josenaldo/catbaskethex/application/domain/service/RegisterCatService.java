package br.com.josenaldo.catbaskethex.application.domain.service;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;
import br.com.josenaldo.catbaskethex.application.port.in.RegisterCatCommand;
import br.com.josenaldo.catbaskethex.application.port.in.RegisterCatUseCase;
import br.com.josenaldo.catbaskethex.application.port.out.SaveCatPort;
import jakarta.transaction.Transactional;

@Transactional
public class RegisterCatService implements RegisterCatUseCase {
    private final SaveCatPort saveCatPort;

    public RegisterCatService(SaveCatPort saveCatPort) {
        this.saveCatPort = saveCatPort;
    }

    @Override
    public Cat registerCat(RegisterCatCommand catCommand) {
        Cat cat = toCat(catCommand);
        return saveCatPort.createCat(cat);
    }

    private Cat toCat(RegisterCatCommand catCommand) {
        return new Cat(catCommand.name(), catCommand.gender(), catCommand.birthDate());
    }
}
