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



    }
}