package com.gridnine.testing.filter;

import com.gridnine.testing.data.Flight;
import com.gridnine.testing.data.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MaxGroundTimeDurationFilter implements FlightFilter {
    private final Duration maxGroundTime;

    public MaxGroundTimeDurationFilter(Duration maxGroundTime) {
        this.maxGroundTime = maxGroundTime;
    }

    @Override
    public boolean matches(Flight flight) {
        LocalDateTime departure;
        LocalDateTime arrival;
        long hoursBetween = 0;
        List<Segment> segments = flight.getSegments();
        int segmentCount = segments.size();
        for (int i = 0; i < segmentCount; i++) {
            if (segmentCount > 1) {
                hoursBetween += hoursBetween;
                arrival = segments.get(i).getArrivalDate();
                departure = segments.get(i + 1).getDepartureDate();
                hoursBetween = ChronoUnit.HOURS.between(arrival, departure);

                segmentCount--;
            }
        }
        long parseMaxGroundTime = parseDuration(maxGroundTime.toString());
        return parseMaxGroundTime - hoursBetween <= 0;
    }

    public long parseDuration(String duration) {
        Duration durationParse = Duration.parse(duration);
        return durationParse.toHours();
    }
}
