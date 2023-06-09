package org.example;

import java.util.List;

public class CreateCollection {
    public String collectionName;
    public enum listType{ ArrayList, LinkedList, ArrayDeque, TreeSet, HashSet, LinkedHashSet, TreeMap, HashMap, LinkedHashMap };
    public List myCollection;
    private listType collectionType;
    public CreateCollection(listType collectionType, int sizeOfList){
        this.collectionType = collectionType;
        switch (this.collectionType.toString()){
            case ("ArrayList") :

                break;
            case ("LinkedList") :

                break;
            case ("ArrayDeque") :

                break;
            case ("TreeSet") :

                break;
            case ("HashSet") :

                break;
            case ("LinkedHashSet") :

                break;
            case ("TreeMap") :

                break;
            case ("HashMap") :

                break;
            case ("LinkedHashMap") :

                break;
            default:

                break;
        }
    }

    public listType getCollectionType() {
        return collectionType;
    }
    public int getRandomNumber(int numberBorder){
        return (int) (Math.random() * numberBorder);
    }
}
