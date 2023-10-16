package br.com.josenaldo.catbaskethex.adapter.out.persistence;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;
import br.com.josenaldo.catbaskethex.application.port.out.CreateCatPort;

public class CatPersistenceAdapter implements CreateCatPort {

    private final SpringDataCatRepository repository;

    public CatPersistenceAdapter(SpringDataCatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cat createCat(Cat cat) {
        //mapping

        CatEntity catEntity = new CatEntity();

        CatEntity save = repository.save(catEntity);
        //mapping

        return new Cat(null, null, null);
    }
}
