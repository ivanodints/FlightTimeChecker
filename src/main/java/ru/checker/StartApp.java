package ru.checker;


import ru.checker.service.AverageTime;
import ru.checker.service.Parser;
import ru.checker.service.Percentile;

import java.util.Scanner;


public class StartApp {

    public static void main(String[] args) throws Exception {

        Parser parser = initParser();

        System.out.println("*******************************************");

        System.out.println("Среднее время полёта между Владивостоком и Тель-Авив составляет "
                + new AverageTime().calculateAverageTime(parser));

        System.out.println("*******************************************");

        Percentile percentile = new Percentile(90);

        System.out.println(percentile.getPercentile()+"-й процентиль времени полёта между городами Владивосток и Тель-Авив равен "
                + percentile.calculatePercentile(parser));

    }

    public static Parser initParser(){
        System.out.println("Введите путь до файла tickets.json");
        String path = (new Scanner(System.in).nextLine())+"tickets.json";
        return new Parser(path);
    }
}
