package com.gridnine.testing.filter;

import com.gridnine.testing.data.Flight;
import java.time.LocalDateTime;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public boolean matches(Flight flight) {
        LocalDateTime start = flight.getSegments().get(0).getDepartureDate();
        LocalDateTime end = flight.getSegments().get(0).getArrivalDate();
        return end.isBefore(start);
    }
}
