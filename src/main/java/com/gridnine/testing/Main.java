package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {
        final FlightFilterService flightFilterService = new FlightFilterServiceImpl();
        System.out.println("Все доступные перелеты");
        System.out.println(FlightBuilder.createFlights());
        System.out.println("1.Исключен вылет до текущего момента времени");
        System.out.println(flightFilterService.flightsWithoutCurrentTime(FlightBuilder.createFlights()));
        System.out.println("2.Исключены вылеты, где имеются сегменты с датой прилёта раньше даты вылета");
        System.out.println(flightFilterService.flightsWithoutArrivalBeforeDeparture(FlightBuilder.createFlights()));
        System.out.println("3.Исключены вылеты, где общее время, проведённое на земле превышает два часа"
                +" (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)");
        System.out.println(flightFilterService.flightsWithoutLandTimeMoreTwoHours(FlightBuilder.createFlights()));

    }
}
