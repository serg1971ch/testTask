package com.gridnine.testing;


import com.gridnine.testing.data.Flight;
import com.gridnine.testing.filter.*;
import com.gridnine.testing.data.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightFiltererTest {

    @Test
    void testFilterFlights() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterer filterer = new FlightFilterer();

        List<FlightFilter> filters = Arrays.asList(
                new DepartureInFutureFilter(),
                new ArrivalBeforeDepartureFilter(),
                new MaxGroundTimeDurationFilter(Duration.ofHours(10))
        );

        List<Flight> filteredFlights = filterer.filterFlights(flights, filters);

        assertEquals(4, filteredFlights.size()); // Проверяем, что остался только два рейса после фильтрации

    }
}

