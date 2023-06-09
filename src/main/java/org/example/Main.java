package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        RunTimeStatistics tstStatistics = new RunTimeStatistics("tstProject");
         tstStatistics.addRunTimePoint(1,2,"firstTest");
         tstStatistics.addRunTimePoint(3,5,"secondTest");
         tstStatistics.addRunTimePoint(6,9,"thirdTest");
        tstStatistics.printRunTimeStatistics();

        CreateCollection myCollection = new CreateCollection(CreateCollection.listType.ArrayList, 100);
        int a = myCollection.getRandomNumber(50);
        System.out.println(a);
    }
}