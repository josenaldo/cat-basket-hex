package br.com.josenaldo.catbaskethex.main;

import br.com.josenaldo.catbaskethex.adapter.out.persistence.CatPersistenceAdapter;
import br.com.josenaldo.catbaskethex.adapter.out.persistence.SpringDataCatRepository;
import br.com.josenaldo.catbaskethex.application.domain.service.RegisterCatService;
import br.com.josenaldo.catbaskethex.application.port.out.CreateCatPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatBasketConfig {

    @Bean
    RegisterCatService registerCatService(CreateCatPort createCatPort) {
        return new RegisterCatService(createCatPort);
    }

    @Bean
    CreateCatPort createCatPort(SpringDataCatRepository repository) {
        return new CatPersistenceAdapter(repository);
    }

}
