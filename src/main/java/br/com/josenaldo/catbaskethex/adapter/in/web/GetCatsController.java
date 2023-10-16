package br.com.josenaldo.catbaskethex.adapter.in.web;

import br.com.josenaldo.catbaskethex.application.domain.model.Cat;
import br.com.josenaldo.catbaskethex.application.port.in.GetCatsQuery;
import br.com.josenaldo.catbaskethex.application.port.in.GetCatsUseCase;
import br.com.josenaldo.catbaskethex.application.port.in.SortRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GetCatsController {

    private final GetCatsUseCase getCatsUseCase;


    public GetCatsController(GetCatsUseCase getCatsUseCase) {
        this.getCatsUseCase = getCatsUseCase;
    }

    @GetMapping("/cats")
    public List<CatResponse> getCats(@RequestParam(name = "sort", defaultValue = "name,ASC", required = false) String sortParameters,
                                     @RequestParam(name = "byName", required = false) String byName) {
        SortParameterParser sortParameterParser = new SortParameterParser(List.of("name", "gender", "birthDate"));
        List<SortRequest> sortRequests = sortParameterParser.parse(sortParameters);

        GetCatsQuery query = new GetCatsQuery(Optional.ofNullable(byName), sortRequests);
        List<Cat> cats = getCatsUseCase.getCats(query);

        return toResponse(cats);
    }

    private List<CatResponse> toResponse(List<Cat> cats) {
        return cats.stream().map(cat -> new CatResponse(
                        cat.getId(),
                        cat.getName(),
                        cat.getGender(),
                        cat.getBirthDate())
                ).toList();
    }
}
