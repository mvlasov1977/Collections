package org.example;

import java.util.*;

public class Main {
    //public enum listType{ ArrayList, LinkedList, ArrayDeque, TreeSet, HashSet, LinkedHashSet, // TreeMap, HashMap, LinkedHashMap };
    static void printCollection(Collection inputCollection){
        for (Iterator myElement = inputCollection.iterator(); myElement.hasNext();){
            Object myItem = myElement.next();
            System.out.print(myItem + ": ");
        }
        System.out.println("\n");
    }
    static void copyCollection(Collection inputCollection, Collection outputCollection){
        for (Iterator myElement = inputCollection.iterator(); myElement.hasNext();){
            Object myItem = myElement.next();
            outputCollection.add(myItem);
        }
    }
    static void fillCollection(Collection myCollection, int sizeOfList, int numberBorder){
        for (int myCounter = 0; myCounter < sizeOfList; myCounter++ ){
            myCollection.add(getRandomNumber(numberBorder));
        }
    }
    static int getRandomNumber(int numberBorder){
        return (int) (Math.random() * numberBorder);
    }
    public static void main(String[] args) {

        // create measurement tables
        RunTimeStatistics testMassive = new RunTimeStatistics("Create test massive");
        RunTimeStatistics linkedListCollection = new RunTimeStatistics("LinkedList");
        RunTimeStatistics arrayDequeCollection = new RunTimeStatistics("ArrayDeque");
        RunTimeStatistics treeSetCollection = new RunTimeStatistics("TreeSet");
        RunTimeStatistics hashSetCollection = new RunTimeStatistics("HashSet");
        RunTimeStatistics linkedHashSetCollection = new RunTimeStatistics("LinkedHashSet");

        long startTimePoint;
        long stopTimePoint;

        // create test numbers
        Collection <ArrayList> myTestList = new ArrayList<>();
        startTimePoint = System.nanoTime();
         fillCollection(myTestList, 100, 50);
        stopTimePoint = System.nanoTime();
        testMassive.addRunTimePoint(startTimePoint,stopTimePoint,"create massive");
        printCollection(myTestList); // print test numbers

        // fill LinkedList
        Collection <LinkedList> myLinkedList = new LinkedList();
        startTimePoint = System.nanoTime();
         copyCollection(myTestList, myLinkedList);
        stopTimePoint = System.nanoTime();
        linkedListCollection.addRunTimePoint(startTimePoint,stopTimePoint,"LinkedList fill");
        printCollection(myLinkedList);// print LinkedList

        // fill ArrayDeque
        Collection <ArrayDeque> myArrayDeque = new ArrayDeque();
        startTimePoint = System.nanoTime();
         copyCollection(myTestList, myArrayDeque);
        stopTimePoint = System.nanoTime();
        arrayDequeCollection.addRunTimePoint(startTimePoint,stopTimePoint,"ArrayDeque fill");
        printCollection(myArrayDeque);// print ArrayDeque

        Collection <TreeSet> myTreeSet = new TreeSet();
        startTimePoint = System.nanoTime();
         copyCollection(myTestList, myTreeSet);
        stopTimePoint = System.nanoTime();
        treeSetCollection.addRunTimePoint(startTimePoint,stopTimePoint,"TreeSet fill")
        printCollection(myTreeSet);// print TreeSet

        Collection <HashSet> myHashSet = new HashSet();
        startTimePoint = System.nanoTime();
         copyCollection(myTestList, myHashSet);
        stopTimePoint = System.nanoTime();
        hashSetCollection.addRunTimePoint(startTimePoint,stopTimePoint,"HashSet fill");
        printCollection(myHashSet);// print HashSet

        Collection <LinkedHashSet> myLinkedHashSet = new LinkedHashSet();
        startTimePoint = System.nanoTime();
         copyCollection(myTestList, myLinkedHashSet);
        stopTimePoint = System.nanoTime();
        linkedHashSetCollection.addRunTimePoint(startTimePoint,stopTimePoint,"LinkedHashSet fill");
        printCollection(myLinkedHashSet);// print LinkedHashSet


    }
}