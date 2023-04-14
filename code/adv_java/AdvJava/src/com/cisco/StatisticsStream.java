package com.cisco;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsStream {
    public static void main(String[] args) {
        List<AggregationMethods.Person> people = Arrays.asList(
                new AggregationMethods.Person("hediyeh", 7000L),
                new AggregationMethods.Person("sara", 10000L),
                new AggregationMethods.Person("shabnam", 150000L),
                new AggregationMethods.Person("shiva", 230000L)
        );

        DoubleSummaryStatistics summaryStatistics = people.stream()
                .mapToDouble(AggregationMethods.Person::getSalary)
                .summaryStatistics();
        System.out.println(summaryStatistics);
        summaryStatistics.accept(1L);
        System.out.println(summaryStatistics);
        
    }
}