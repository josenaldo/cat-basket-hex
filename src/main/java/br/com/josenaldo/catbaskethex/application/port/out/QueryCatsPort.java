package br.com.josenaldo.catbaskethex.application.port.out;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;
import br.com.josenaldo.catbaskethex.application.port.in.GetCatsQuery;

import java.util.List;

public interface QueryCatsPort {
    List<Cat> getCats(GetCatsQuery query);
}
