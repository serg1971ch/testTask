package com.gridnine.testing.filter;

import com.gridnine.testing.data.Flight;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureInFutureFilter implements FlightFilter {
    @Override
    public boolean matches(Flight flight) {
        LocalDateTime start = flight.getSegments().get(0).getDepartureDate();
        LocalDateTime end = LocalDateTime.now();
        return end.isAfter(start);
    }
}

