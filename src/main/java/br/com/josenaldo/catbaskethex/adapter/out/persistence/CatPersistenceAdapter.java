package br.com.josenaldo.catbaskethex.adapter.out.persistence;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;
import br.com.josenaldo.catbaskethex.application.port.in.GetCatsQuery;
import br.com.josenaldo.catbaskethex.application.port.in.SortDirection;
import br.com.josenaldo.catbaskethex.application.port.in.SortRequest;
import br.com.josenaldo.catbaskethex.application.port.out.QueryCatsPort;
import br.com.josenaldo.catbaskethex.application.port.out.SaveCatPort;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CatPersistenceAdapter implements SaveCatPort, QueryCatsPort {

    private final SpringDataCatRepository repository;

    public CatPersistenceAdapter(SpringDataCatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cat createCat(Cat cat) {
        CatEntity catEntity = toEntity(cat);
        CatEntity savedCatEntity = repository.save(catEntity);
        return toCat(savedCatEntity);
    }

    @Override
    public List<Cat> getCats(GetCatsQuery query) {
        List<CatEntity> entityResults;

        Optional<String> nameParam = query.byName().filter(Predicate.not(String::isBlank));
        Sort sort = toSort(query.sortRequestList());

        if (nameParam.isEmpty()) {
            entityResults = repository.findAll(sort);
        }else {
            entityResults = repository.findByNameLike("%%%s%%".formatted(nameParam), sort);
        }

        return entityResults.stream().map(this::toCat).toList();
    }

    private CatEntity toEntity(Cat cat) {
        CatEntity catEntity = new CatEntity();
        catEntity.setId(cat.getId());
        catEntity.setName(cat.getName());
        catEntity.setGender(cat.getGender());
        catEntity.setBirthDate(cat.getBirthDate());

        return catEntity;
    }

    private Cat toCat(CatEntity catEntity) {
        return new Cat(
                catEntity.getId(),
                catEntity.getName(),
                catEntity.getGender(),
                catEntity.getBirthDate());
    }

    public Sort toSort(List<SortRequest> sortRequestList) {
        if (sortRequestList == null || sortRequestList.isEmpty() ) {
            return Sort.unsorted();
        }

        List<Sort.Order> orders = sortRequestList.stream().map(sortRequest -> {
            if (sortRequest.direction() == SortDirection.ASC) {
                return Sort.Order.asc(sortRequest.field());
            }
            return  Sort.Order.desc(sortRequest.field());
        }).toList();


        return Sort.by(orders);
    }
}
