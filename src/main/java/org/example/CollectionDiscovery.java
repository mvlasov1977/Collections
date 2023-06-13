package org.example;
import java.lang.reflect.Array;
import java.util.*;

public class CollectionDiscovery {
    public String collectionName;
    public enum listType{ ArrayList, LinkedList, ArrayDeque, TreeSet, HashSet, LinkedHashSet };
    public RunTimeStatistics measResult;
    public int duplicates;
    public Collection myCollection;
    public Collection myCollectionWithoutDuplicates;
    public CollectionDiscovery(Collection inputArrayOfElements, String collectionName, listType collectionType){
        this.collectionName = collectionName;
        RunTimeStatistics measResult = new RunTimeStatistics(this.collectionName);
        this.measResult = measResult;

        myCollection = createCollection(collectionType);
        myCollectionWithoutDuplicates = createCollection(collectionType);
        executeTestPlan(inputArrayOfElements);
    }
    public CollectionDiscovery(String collectionName, listType collectionType, int sizeOfList, int numberBorder){
        this.collectionName = collectionName;
        RunTimeStatistics measResult = new RunTimeStatistics(this.collectionName);
        this.measResult = measResult;

        myCollection = createCollection(collectionType);
        myCollectionWithoutDuplicates = createCollection(collectionType);
        makeTestNumbers(myCollection, sizeOfList, numberBorder);
        duplicates = findDuplicateNumbersByEnumeration(myCollection, myCollectionWithoutDuplicates, collectionName + " delete duplicate numbers by enumeration method");
    }
    public void executeTestPlan(Collection inputArrayOfElements){
        myCollection.clear();

        fillCollection(inputArrayOfElements, collectionName + " fill");
        duplicates = findDuplicateNumbersByEnumeration(myCollection, myCollectionWithoutDuplicates, collectionName + " delete duplicate numbers by enumeration method");
    }
    public void fillCollection(Collection inputCollection, String taskName){
        long startTimePoint = System.nanoTime();
         copyCollection(inputCollection, myCollection);
        long stopTimePoint = System.nanoTime();
        //measResult.addRunTimePoint(startTimePoint,stopTimePoint,taskName);
    }
    public boolean isCollectionHaveItem(Collection inputCollection, Object collectionItem){
        for (Iterator myElement = inputCollection.iterator(); myElement.hasNext();){
            Object myItem = myElement.next();
            if ( myItem.equals(collectionItem) ){
                return true;
            }
        }
        return false;
    }
    public int findDuplicateNumbersByEnumeration(Collection inputCollection, Collection outputCollection, String taskName){
        int myDuplicateCount = 0;
        long startTimePoint = System.nanoTime();
         if (inputCollection.size() > 0){
             outputCollection.clear();
             for (Iterator myElement = inputCollection.iterator(); myElement.hasNext();){
                 Object myItem = myElement.next();
                 if ( isCollectionHaveItem(outputCollection, myItem) ){
                     myDuplicateCount++;
                 }else{
                     outputCollection.add(myItem);
                 }
             }
         }
        long stopTimePoint = System.nanoTime();
        measResult.addRunTimePoint(startTimePoint,stopTimePoint,taskName);
        return myDuplicateCount;
    }
    public void makeTestNumbers(Collection myCollection, int sizeOfList, int numberBorder){
        for (int myCounter = 0; myCounter < sizeOfList; myCounter++ ){
            myCollection.add(getRandomNumber(numberBorder));
        }
    }
    private int getRandomNumber(int numberBorder){
        return (int) (Math.random() * numberBorder);
    }
    public void printCollection(Collection inputCollection){
        for (Iterator myElement = inputCollection.iterator(); myElement.hasNext();){
            Object myItem = myElement.next();
            System.out.print(myItem + ": ");
        }
        System.out.print("( duplicates: " + duplicates + " )");
        System.out.println("\n");
    }
    private void copyCollection(Collection inputCollection, Collection outputCollection){
        for (Iterator myElement = inputCollection.iterator(); myElement.hasNext();){
            Object myItem = myElement.next();
            outputCollection.add(myItem);
        }
    }
    private Collection createCollection(listType collectionType){
        switch (collectionType.toString()){
            case ("ArrayList") :
                Collection <ArrayList> myArrayList = new ArrayList<>();
                return myArrayList;
            case ("LinkedList") :
                Collection <LinkedList> myLinkedList = new LinkedList();
                return myLinkedList;
            case ("ArrayDeque") :
                Collection <ArrayDeque> myArrayDeque = new ArrayDeque();
                return myArrayDeque;
            case ("TreeSet") :
                Collection <TreeSet> myTreeSet = new TreeSet();
                return myTreeSet;
            case ("HashSet") :
                Collection <HashSet> myHashSet = new HashSet();
                return myHashSet;
            case ("LinkedHashSet") :
                Collection <LinkedHashSet> myLinkedHashSet = new LinkedHashSet();
                return myLinkedHashSet;
            default:
                Collection <ArrayList> myDefaulArrayList = new ArrayList<>();
                return myDefaulArrayList;
        }

    }
}
