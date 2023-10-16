package br.com.josenaldo.catbaskethex.application.port.in;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;

public interface RegisterCatUseCase {
    Cat registerCat(Cat cat);

}
