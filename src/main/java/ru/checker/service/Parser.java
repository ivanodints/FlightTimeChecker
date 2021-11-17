package ru.checker.service;

import com.google.gson.Gson;
import lombok.Getter;
import ru.checker.model.Root;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

@Getter
public class Parser {

    private final String path;

    public Parser(String path) {
        this.path = path;
    }

    public Root parse() {

        try(FileReader fileReader = new FileReader(path))  {

            return new Gson().fromJson(fileReader, Root.class);

        } catch (Exception e){
            System.out.println("Ошибка парсера: " + e.toString());
        }

        return null;
    }

    public List<Integer> ticketFlightTimeParser(){

        String city1 = "Тель-Авив";
        String city2 = "Владивосток";

        Root root = new Parser(path).parse();

        List<Integer> flightTimeArray = new ArrayList<>();

        for (int i = 0; i < root.getTickets().size(); i++) {

            if (root.getTickets().get(i).getOriginName().equals(city1) ||
                    root.getTickets().get(i).getOriginName().equals(city2) &
                            root.getTickets().get(i).getDestinationName().equals(city2) ||
                    root.getTickets().get(i).getDestinationName().equals(city1)) {

                String[] departureTimeArray = root.getTickets().get(i).getDepartureTime().split(":");
                int departureTime = (Integer.parseInt(departureTimeArray[0]) * 60) + Integer.parseInt(departureTimeArray[1]);

                String[] arrivalTimeArray = root.getTickets().get(i).getArrivalTime().split(":");
                int arrivalTime = (Integer.parseInt(arrivalTimeArray[0]) * 60) + Integer.parseInt(arrivalTimeArray[1]);

                int flightTime = abs(arrivalTime - departureTime);

                flightTimeArray.add(flightTime);
            }
        }
        return flightTimeArray;
    }
}
