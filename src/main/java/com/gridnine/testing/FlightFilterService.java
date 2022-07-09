package com.gridnine.testing;

import java.util.List;

/**
 * Interface for filter Flights.
 */
public interface FlightFilterService {

    /**
     * Filter for departure time and current time .
     *
     * @param list of Flights
     * @return List of Flights after filter
     */
    List<Flight> flightsWithoutCurrentTime(List<Flight> list);

    /**
     * Filter for wrong departure and arrival time .
     *
     * @param list of Flights
     * @return List of Flights after filter
     */
    List<Flight> flightsWithoutArrivalBeforeDeparture(List<Flight> list);

    /**
     * Filter for land time more then 2 hours .
     *
     * @param list of Flights
     * @return List of Flights after filter
     */
    List<Flight> flightsWithoutLandTimeMoreTwoHours(List<Flight> list);
}
