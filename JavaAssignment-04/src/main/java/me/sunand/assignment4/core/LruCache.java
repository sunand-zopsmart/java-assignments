package me.sunand.assignment4.core;

import java.util.*;

public class LruCache {
    //This function returns the least recently used page in the cache
    public static int getOldestPage(Map<Integer, Integer> m) {
        int minTime = Integer.MAX_VALUE;
        int oldestPage = 0;
        for (Map.Entry mapElement : m.entrySet()) {
            if (minTime > (int) mapElement.getValue()) {
                minTime = (int) mapElement.getValue();
                oldestPage = (int) mapElement.getKey();
            }
        }
        return oldestPage;
    }

    public static void main(String[] args) {
        int maxSize = 3; //Maximum size of the cache
        int size = 0; //Current size of the cache
        int timeStamp = 0; //Time of access of page number

        List<Integer> pageRequest = Arrays.asList(1, 2, 3, 3, 4, 2);

        //The key in the map(cache) represents the page number and the value represents the time stamp of insertion
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

        for (Integer i : pageRequest) {
            timeStamp++;
            if (cache.containsKey(i)) {
                System.out.println("Page Hit");//The page is already in the cache
            } else {
                System.out.println("Page Fault");
                if (size < maxSize) { //If there is still space cache , simply insert.

                    size++;//The size of the cache is increased by 1
                } else {
                    //If the cache is full, then remove the oldest page.
                    int oldestPage = getOldestPage(cache);
                    cache.remove(oldestPage);
                }
            }
            cache.put(i, timeStamp);//Insert the page number with the timestamp of insertion
        }
    }
}
