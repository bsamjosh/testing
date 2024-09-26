package org.home.codingtest.luxoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LruCache {

    public static String loadCache(String[] inArgs){

        List<String> cacheArray = new ArrayList<>();
        boolean maxSize = false;
        Integer cacheController = 0;
        for(int i = 0 ; i < inArgs.length ; i++){
            boolean isTrue = checkIfNewIsExisting(cacheArray , inArgs[i]);
            if(!isTrue){
                if(cacheController <= 5 && !maxSize){
                    cacheController++;
                    cacheArray = addAtLast(cacheArray , inArgs[i]);
                    maxSize = Integer.compare(cacheController, 5) == 0;
                }else if(cacheController == 5 ){
                    cacheArray = removeFirstCache(cacheArray);
                    cacheArray = addAtLast(cacheArray , inArgs[i]);
                }
            }else{
                cacheArray = deleteExistingCache(cacheArray , inArgs[i]);
                cacheArray = addAtLast(cacheArray , inArgs[i]);
            }
        }
        return convertListToString(cacheArray);
    }

    public static List<String> addAtLast(List<String> cachedArray , String toAddToCache){
        cachedArray.add(toAddToCache);
        return cachedArray;
    }

    public static List<String> removeFirstCache(List<String> cachedArray){
        cachedArray.remove(0);
        return cachedArray;
    }
    public static boolean checkIfNewIsExisting(List<String> inCache , String toCheck){
        return inCache.contains(toCheck);
    }

    public static List<String> deleteExistingCache(List<String> inCache , String toDelete){
        inCache.remove(toDelete);
        return inCache;
    }

    public static String convertListToString(List<String> inArray){
        return inArray.stream()
                .reduce((A , B) ->{
                    String s = A + "-" + B;
                    return s;
                }).get();
    }

    public static String convertListToString(String[] inArray){
        return Arrays.asList(inArray).stream()
                .reduce((A , B) ->{
                    String s = A + "-" + B;
                    return s;
                }).get();
    }

    public static void main(String args[]){

        String[] inputArg = {"A","B","C","D","A","D"};
        String outputArg = "B-C-A-D";
        String finalizedCache = loadCache(inputArg);
        if(finalizedCache.equals(outputArg)){
            System.out.println("====================Matching========================");
        }else {
            System.out.println("====================Not - Matching========================");
        }
        System.out.println("Input String - "+convertListToString(inputArg));
        System.out.println("Input String - "+finalizedCache);

        String[] inputArg1 = {"A", "B", "C", "D", "A", "E", "D", "Z"};
        String outputArg1 = "C-A-E-D-Z";
        finalizedCache = loadCache(inputArg1);
        if(finalizedCache.equals(outputArg1)){
            System.out.println("====================Matching========================");
        } else {
            System.out.println("====================Not - Matching========================");
        }
        System.out.println("Input String - "+convertListToString(inputArg1));
        System.out.println("Input String - "+finalizedCache);

//        {"A", "B", "A", "C", "A", "B"}

        String[] inputArg2 = {"A", "B", "A", "C", "A", "B"};
        String outputArg2 = "C-A-B";
        finalizedCache = loadCache(inputArg2);
        if(finalizedCache.equals(outputArg2)){
            System.out.println("====================Matching========================");
        } else {
            System.out.println("====================Not - Matching========================");
        }
        System.out.println("Input String - "+convertListToString(inputArg2));
        System.out.println("Input String - "+finalizedCache);

//        {"A", "B", "C", "D", "E", "D", "Q", "Z", "C"}
        String[] inputArg3 = {"A", "B", "C", "D", "E", "D", "Q", "Z", "C"};
        String outputArg3 = "E-D-Q-Z-C";
        finalizedCache = loadCache(inputArg3);
        if(finalizedCache.equals(outputArg3)){
            System.out.println("====================Matching========================");
        } else {
            System.out.println("====================Not - Matching========================");
        }
        System.out.println("Input String - "+convertListToString(inputArg3));
        System.out.println("Input String - "+finalizedCache);

    }
}
