package br.com.josenaldo.catbaskethex.application.port.in;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;

import java.util.List;

public interface GetCatsUseCase {
    List<Cat> getCats(GetCatsQuery query);
}
