package br.com.josenaldo.catbaskethex.main;

import br.com.josenaldo.catbaskethex.adapter.out.persistence.CatPersistenceAdapter;
import br.com.josenaldo.catbaskethex.adapter.out.persistence.SpringDataCatRepository;
import br.com.josenaldo.catbaskethex.application.domain.service.GetCatsService;
import br.com.josenaldo.catbaskethex.application.domain.service.RegisterCatService;
import br.com.josenaldo.catbaskethex.application.port.out.QueryCatsPort;
import br.com.josenaldo.catbaskethex.application.port.out.SaveCatPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatBasketHexConfig {

    @Bean
    RegisterCatService registerCatService(SaveCatPort saveCatPort) {
        return new RegisterCatService(saveCatPort);
    }


    @Bean
    GetCatsService getCatsService(QueryCatsPort queryCatsPort) {
        return new GetCatsService(queryCatsPort);
    }

    @Bean
    CatPersistenceAdapter catPersistenceAdapter(SpringDataCatRepository repository) {
        return new CatPersistenceAdapter(repository);
    }

}
