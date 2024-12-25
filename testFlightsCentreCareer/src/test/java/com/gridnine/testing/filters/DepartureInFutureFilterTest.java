package com.gridnine.testing.filters;

import com.gridnine.testing.data.Flight;
import com.gridnine.testing.data.FlightBuilder;
import com.gridnine.testing.filter.DepartureInFutureFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DepartureInFutureFilterTest {

    @Test
    public void testDepartureInFutureFilter() {
        DepartureInFutureFilter filter = new DepartureInFutureFilter();
        Boolean trueDepartureInFuture = true;
        List<Flight> flights = FlightBuilder.createFlights();

        //A flight departing in the past
        Boolean actualDepartureInFuture = filter.matches(flights.get(2));

        Assertions.assertEquals(actualDepartureInFuture, trueDepartureInFuture);
    }
}
