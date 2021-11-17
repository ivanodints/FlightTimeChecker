package ru.checker.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.checker.model.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

@Getter
@AllArgsConstructor
public class Percentile {

    private int percentile;

    public String calculatePercentile(Parser parser) throws Exception {

        List<Integer> flightTimeArray = parser.ticketFlightTimeParser();
        Double timePercentile;
        Collections.sort(flightTimeArray);

        double i = (percentile /100d)*flightTimeArray.size();
        int j;

        if (percentile == 100) {

            timePercentile = Double.valueOf((flightTimeArray.get(flightTimeArray.size()-1)));

        } else if(percentile>100 || percentile<0 ){

            throw new Exception("Неверный перцентиль");
        }
        else if (i%1 == 0) {

            j = (int)i;
            timePercentile = Double.valueOf(((flightTimeArray.get(j-1))+(flightTimeArray.get(j)))/2);

        } else {

            j = (int)i + 1;
            timePercentile = Double.valueOf(flightTimeArray.get(j-1));
        }

        int hours = (int) (timePercentile / 60);
        int minutes = (int) (timePercentile % 60);

        String percentileTimeString = hours + ":" + minutes;

        return percentileTimeString;
    }
}
