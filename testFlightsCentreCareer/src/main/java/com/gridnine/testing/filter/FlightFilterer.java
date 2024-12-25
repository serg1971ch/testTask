package com.gridnine.testing.filter;

import com.gridnine.testing.data.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterer {
    public List<Flight> filterFlights(List<Flight> flights, List<FlightFilter> filters) {
        return flights.stream()
                .filter(flight -> filters.stream().noneMatch(filter -> filter.matches(flight)))
                .collect(Collectors.toList());
    }
}
