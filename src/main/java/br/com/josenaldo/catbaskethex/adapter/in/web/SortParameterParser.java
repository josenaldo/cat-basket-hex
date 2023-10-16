package br.com.josenaldo.catbaskethex.adapter.in.web;

import br.com.josenaldo.catbaskethex.application.port.in.SortDirection;
import br.com.josenaldo.catbaskethex.application.port.in.SortRequest;

import java.util.ArrayList;
import java.util.List;

public class SortParameterParser {

    private final List<String> possibleFieldNames;

    public SortParameterParser(List<String> possibleFieldNames) {
        this.possibleFieldNames = possibleFieldNames;
    }

    public List<SortRequest> parse(String sortParameter)  {
        List<SortRequest> sortRequests = new ArrayList<>();

        if (sortParameter != null && !sortParameter.isEmpty()) {
            String[] sortFields = sortParameter.split("\\|");

            for (String sortField : sortFields) {
                String[] parts = sortField.split(",");

                if (parts.length == 2) {
                    String field = parts[0];
                    String direction = parts[1].toUpperCase();

                    if (isValidSortField(field, possibleFieldNames) && isValidSortDirection(direction)) {
                        SortRequest sortRequest = new SortRequest(field, SortDirection.valueOf(direction));
                        sortRequests.add(sortRequest);
                    }
                }
            }
        }

        return sortRequests;
    }

    private boolean isValidSortDirection(String direction) {
        try{
            SortDirection.valueOf(direction);
        }catch (IllegalArgumentException | NullPointerException exception) {
            return false;
        }

        return true;
    }

    private boolean isValidSortField(String field, List<String> possibleFieldNames) {
        return possibleFieldNames.contains(field);
    }
}
