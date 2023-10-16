package br.com.josenaldo.catbaskethex.application.port.out;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;

public interface SaveCatPort {
    Cat createCat(Cat cat);
}
