package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FlightFilterServiceImpl implements FlightFilterService {

    @Override
    public List<Flight> flightsWithoutCurrentTime(List<Flight> list) {
        final List<Flight> result = new ArrayList<>();
        for (Flight f : list) {
            Segment s = f.getSegments()
                    .stream()
                    .sorted(Comparator.comparing(Segment::getDepartureDate))
                    .findFirst()
                    .orElse(null);
            if (s != null ? s.getDepartureDate().isAfter(LocalDateTime.now()) : false) {
                result.add(f);
            }
        }
        return result;
    }


    @Override
    public List<Flight> flightsWithoutArrivalBeforeDeparture(List<Flight> list) {
        final Set<Flight> result = new LinkedHashSet<>();
        for (Flight f : list) {
            List<Segment> segments = f.getSegments();
            for (int i = 0; i < segments.size(); i++) {
                if (segments.get(i).getDepartureDate().isBefore(segments.get(i).getArrivalDate())) {
                    result.add(f);
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    @Override
    public List<Flight> flightsWithoutLandTimeMoreTwoHours(List<Flight> list) {
        final List<Flight> result = new ArrayList<>();
        for (Flight f : list) {
            Duration landTime = Duration.ZERO;
            List<Segment> segments = f.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                landTime = landTime.plus(Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()));
            }
            if (landTime.toHours() < 2 | segments.size() == 1) {
                result.add(f);
            }
        }
        return result;
    }
}
