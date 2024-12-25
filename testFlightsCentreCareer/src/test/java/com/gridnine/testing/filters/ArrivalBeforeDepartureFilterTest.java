package com.gridnine.testing.filters;

import com.gridnine.testing.data.Flight;
import com.gridnine.testing.data.FlightBuilder;
import com.gridnine.testing.filter.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class ArrivalBeforeDepartureFilterTest {

    @Test
    void ArrivalBeforeDepartureFilterMatches() {
        Boolean trueArrivalBeforeDepartureFilter = true;
        List<Flight> flights = FlightBuilder.createFlights();

        ArrivalBeforeDepartureFilter arrivalFilterer = new ArrivalBeforeDepartureFilter();

        Boolean actualMatches = arrivalFilterer.matches(flights.get(3));
        Assertions.assertEquals(actualMatches, trueArrivalBeforeDepartureFilter);
    }
}