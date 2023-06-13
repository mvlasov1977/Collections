package org.example;

import java.util.*;

public class Main {
    //public enum listType{ ArrayList, LinkedList, ArrayDeque, TreeSet, HashSet, LinkedHashSet, // TreeMap, HashMap, LinkedHashMap };

    public static void main(String[] args) {
        /*
        1.Написати програму яка видаляє з колекції цілих чисел всі дублікати, якщо вони є.
        Початкову колекцію з 100 елементів потрібно заповнити випадковими числами (ліміт 50).
        На екран потрібно вивести обидві колекції та кількість видалених дублікатів.

         */

        int sizeOfList = 100;
        int maximumValue = 50;

        CollectionDiscovery myTestNumbers = new CollectionDiscovery("Test numbers", CollectionDiscovery.listType.ArrayList,sizeOfList, maximumValue);
        myTestNumbers.measResult.printRunTimeStatistics();
        myTestNumbers.printCollection(myTestNumbers.myCollection);


        CollectionDiscovery myArrayList = new CollectionDiscovery(myTestNumbers.myCollection,"ArrayList",CollectionDiscovery.listType.ArrayList);
        myArrayList.measResult.printRunTimeStatistics();
        myArrayList.printCollection(myArrayList.myCollectionWithoutDuplicates);


        CollectionDiscovery myLinkedList = new CollectionDiscovery(myTestNumbers.myCollection,"LinkedList",CollectionDiscovery.listType.LinkedList);
        myLinkedList.measResult.printRunTimeStatistics();
        myLinkedList.printCollection(myLinkedList.myCollectionWithoutDuplicates);


        CollectionDiscovery myArrayDeque = new CollectionDiscovery(myTestNumbers.myCollection,"ArrayDeque",CollectionDiscovery.listType.ArrayDeque);
        myArrayDeque.measResult.printRunTimeStatistics();
        myArrayDeque.printCollection(myArrayDeque.myCollectionWithoutDuplicates);


        CollectionDiscovery myTreeSet = new CollectionDiscovery(myTestNumbers.myCollection,"TreeSet",CollectionDiscovery.listType.TreeSet);
        myTreeSet.measResult.printRunTimeStatistics();
        myTreeSet.printCollection(myTreeSet.myCollectionWithoutDuplicates);


        CollectionDiscovery myHashSet = new CollectionDiscovery(myTestNumbers.myCollection,"HashSet",CollectionDiscovery.listType.HashSet);
        myHashSet.measResult.printRunTimeStatistics();
        myHashSet.printCollection(myHashSet.myCollectionWithoutDuplicates);


        CollectionDiscovery myLinkedHashSet = new CollectionDiscovery(myTestNumbers.myCollection,"LinkedHashSet",CollectionDiscovery.listType.LinkedHashSet);
        myLinkedHashSet.measResult.printRunTimeStatistics();
        myLinkedHashSet.printCollection(myLinkedHashSet.myCollectionWithoutDuplicates);

       /*
        2.У колі стоять N осіб, пронумерованих від 1 до N. Під час ведення рахунку
        по колу викреслюється кожна друга людина, доки залишиться одна.
        Скласти дві програми, що моделюють процес. Одна із програм
        повинна використовувати клас ArrayList, а друга – LinkedList. Яка з
        двох програм працює швидше? Чому?
       */

        int maxCount = 9;
        ArrayList <Integer> personArrayList = new ArrayList<>();
        LinkedList <Integer> personLinkedList = new LinkedList();
        int countFirst = 1;
        int countSecond = 1;
        for (int i = 0; i < maxCount; i++){
            personArrayList.add(countFirst);
            personLinkedList.add(countSecond);
            countFirst++;
            countSecond++;
        }

        RunTimeStatistics arrayListResult = new RunTimeStatistics("ArrayList");
        System.out.println(personArrayList);
        int itemCount = 0;
        int iteration = 0;

        long startTimePoint = System.nanoTime();
        while (personArrayList.size() > 1){
            iteration++;
            System.out.print("(" + iteration + ") removed: ");
            for (Iterator myElement = personArrayList.iterator(); myElement.hasNext();){
                Object myItem = myElement.next();
                itemCount++;
                if (itemCount == 2){
                    System.out.print(myItem + " ");
                    myElement.remove();
                    itemCount = 0;
                }
            }
            System.out.println("");
        }
        long stopTimePoint = System.nanoTime();
        arrayListResult.addRunTimePoint(startTimePoint, stopTimePoint, "every second leave");
        System.out.println(personArrayList);
        System.out.println("");

        RunTimeStatistics LinkedListResult = new RunTimeStatistics("LinkedList");
        System.out.println(personLinkedList);
         itemCount = 0;
         iteration = 0;
        startTimePoint = System.nanoTime();
        while (personLinkedList.size() > 1){
            iteration++;
            System.out.print("(" + iteration + ") removed: ");
            for (Iterator myElement = personLinkedList.iterator(); myElement.hasNext();){
                Object myItem = myElement.next();
                itemCount++;
                if (itemCount == 2){
                    System.out.print(myItem + " ");
                    myElement.remove();
                    itemCount = 0;
                }
            }
            System.out.println("");
        }
        stopTimePoint = System.nanoTime();
        LinkedListResult.addRunTimePoint(startTimePoint, stopTimePoint, "every second leave");
        System.out.println(personLinkedList);
        System.out.println("");

        arrayListResult.printRunTimeStatistics();
        LinkedListResult.printRunTimeStatistics();

    }
}