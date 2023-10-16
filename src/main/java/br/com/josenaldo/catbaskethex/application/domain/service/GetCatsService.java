package br.com.josenaldo.catbaskethex.application.domain.service;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;
import br.com.josenaldo.catbaskethex.application.port.in.GetCatsQuery;
import br.com.josenaldo.catbaskethex.application.port.in.GetCatsUseCase;
import br.com.josenaldo.catbaskethex.application.port.out.QueryCatsPort;

import java.util.List;

public class GetCatsService implements GetCatsUseCase {

    private final QueryCatsPort queryCatsPort;

    public GetCatsService(QueryCatsPort queryCatsPort) {
        this.queryCatsPort = queryCatsPort;
    }

    @Override
    public List<Cat> getCats(GetCatsQuery query) {
        return queryCatsPort.getCats(query);
    }
}
