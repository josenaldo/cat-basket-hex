package br.com.josenaldo.catbaskethex.application.port.in;

import java.util.List;
import java.util.Optional;

public record GetCatsQuery(Optional<String> byName, List<SortRequest> sortRequestList ) {
}
