package ru.checker.service;

import ru.checker.model.Root;


import static java.lang.Math.abs;

public class AverageTime {

    public String calculateAverageTime(Parser parser) {

        int totalFlightTime = 0;

        for (int i = 0; i< parser.ticketFlightTimeParser().size(); i++){
            totalFlightTime += parser.ticketFlightTimeParser().get(i);
        }

        int averageTime = totalFlightTime / (parser.ticketFlightTimeParser().size());
        int hours = averageTime / 60;
        int minutes = averageTime % 60;

        String averageTimeString = hours + ":" + minutes;

        return averageTimeString;

    }
}
