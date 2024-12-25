package com.gridnine.testing.filters;

import com.gridnine.testing.data.Flight;
import com.gridnine.testing.data.FlightBuilder;
import com.gridnine.testing.filter.MaxGroundTimeDurationFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

public class MaxGroundTimeDurationFilterTest {
    @Test
    public void testMaxFlightDurationFilter() {
        Boolean trueMaxFlightDurationFilter = true;
        List<Flight> flights = FlightBuilder.createFlights();
        Duration durationTwoHours = Duration.ofHours(2);
        MaxGroundTimeDurationFilter maxFlightDurationFilter = new MaxGroundTimeDurationFilter(durationTwoHours);

        Boolean actualMaxFlightDuration4 = maxFlightDurationFilter.matches(flights.get(4));
        Boolean actualMaxFlightDuration5 = maxFlightDurationFilter.matches(flights.get(5));

        Assertions.assertEquals(actualMaxFlightDuration4, trueMaxFlightDurationFilter);
        Assertions.assertEquals(actualMaxFlightDuration5, trueMaxFlightDurationFilter);
    }
}
