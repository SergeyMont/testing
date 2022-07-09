package com.gridnine.testing;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class FlightFilterServiceImplTest extends TestCase {
    FlightFilterService flightFilterService = new FlightFilterServiceImpl();
    List<Flight> list = FlightBuilder.createFlights();

    @Test
    public void testAllFlights() {
        assertEquals(list.size(), 6);
    }

    @Test
    public void testFlightsWithoutCurrentTime() {
        assertEquals(flightFilterService.flightsWithoutCurrentTime(list).size(), 5);
    }

    @Test
    public void testFlightsWithoutArrivalBeforeDeparture() {
        assertEquals(flightFilterService.flightsWithoutArrivalBeforeDeparture(list).size(), 5);
    }

    @Test
    public void testFlightsWithoutLandTimeMoreTwoHours() {
        assertEquals(flightFilterService.flightsWithoutLandTimeMoreTwoHours(list).size(), 4);
    }
}