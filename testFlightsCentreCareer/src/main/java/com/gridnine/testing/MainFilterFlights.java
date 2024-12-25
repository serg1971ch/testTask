package com.gridnine.testing;

import com.gridnine.testing.data.Flight;
import com.gridnine.testing.data.FlightBuilder;
import com.gridnine.testing.filter.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MainFilterFlights {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterer filterer = new FlightFilterer();

        Duration durationTwoHours = Duration.ofHours(2);
        List<FlightFilter> filtersCategory = Arrays.asList(
                new DepartureInFutureFilter(),
                new ArrivalBeforeDepartureFilter(),
                new MaxGroundTimeDurationFilter(durationTwoHours)
        );

        List<Flight> filteredFlights = filterer.filterFlights(flights, filtersCategory);

        System.out.println("\nFiltered flights:\n");
        filteredFlights.forEach(System.out::println);
    }
}