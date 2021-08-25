package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;

public class Solution{
    public static int transform(PriorityQueue<Integer> i1, PriorityQueue<Integer> i2, PriorityQueue<Integer> i3){
        ArrayList<Integer> rez = new ArrayList<>(i1);
        rez.addAll(i2);
        rez.addAll(i3);
        Collections.sort(rez, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        int number = 0;
        for(Integer i : rez)
            number = number *10 + i;
        return number;
    }

    public static int solution(int[] l) {
        PriorityQueue<Integer> rest_0 =new PriorityQueue<>();
        PriorityQueue<Integer> rest_1 =new PriorityQueue<>();
        PriorityQueue<Integer> rest_2 =new PriorityQueue<>();
        int sum = 0;
        int rezultat = 0;
        for (int j : l){
            if(j % 3 == 0)
                rest_0.add(j);
            if(j % 3 == 1)
                rest_1.add(j);
            if(j % 3 == 2)
                rest_2.add(j);
            sum += j;
        }
        if(sum % 3 == 0)
            rezultat = transform(rest_0, rest_1, rest_2);
        if(sum % 3 == 1){
            if(rest_1.size() >= 1){
                rest_1.poll();
                rezultat = transform(rest_0, rest_1, rest_2);
            }
            else {
                if(rest_2.size() >= 2){
                    rest_2.poll();
                    rest_2.poll();
                    rezultat = transform(rest_0, rest_1, rest_2);
                }
            }
        }
        if(sum % 3 == 2){
            if(rest_2.size() >= 1){
                rest_2.poll();
                rezultat = transform(rest_0, rest_1, rest_2);
            }
            else {
                if(rest_1.size() >= 2){
                    rest_1.poll();
                    rest_1.poll();
                    rezultat = transform(rest_0, rest_1, rest_2);
                }
            }
        }
        return rezultat;
    }
}
