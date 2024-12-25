package com.gridnine.testing.filter;

import com.gridnine.testing.data.*;

public interface FlightFilter {
    boolean matches(Flight flight);
}
