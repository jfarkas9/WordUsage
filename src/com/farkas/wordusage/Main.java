package com.farkas.wordusage;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {

        //Map based Word, word count
        TreeMap<String, Integer> list = new TreeMap<String, Integer>();
        File file = new File("document.txt");
        Scanner input = new Scanner(file);
        int sum = 0;
        while(input.hasNext()) {
            String word = input.next();
            //santizes any punctuation from input, converts to lower case
            word = word.replaceAll("\\p{P}", "").toLowerCase();
            //if word in map incrument value, if not add word with value of 1
            if(list.containsKey(word)){
                list.put(word, list.get(word) + 1);
            }else {
                list.put(word, 1);
            }
            sum++;
        }

        System.out.println("Sort by:\n1. Alphabetical\n2. Numerical");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                printList(list, sum);
                break;
            case 2:
                Map sortedMap = new TreeMap(new ValueComparator(list));
                sortedMap.putAll(list);
                printList(sortedMap, sum);
                break;
        }


    }

    private static void printList(Map list, int sum){
            for (Object key : list.keySet()) {
            int value = (int) list.get(key);
            double percentage = value / (double)sum * 100;
            System.out.print(key + " " + value + " ");
            System.out.printf("%.2f\n", percentage);
        }
    }

}
