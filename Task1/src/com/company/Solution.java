package com.company;

import java.util.ArrayList;

public class Solution{
    public static int[] solution(int area){
        ArrayList<Integer> rez= new ArrayList<Integer>();
        while(area > 0){
            int aux = (int)Math.floor(Math.sqrt(area));
            rez.add(aux*aux);
            area -= aux*aux;
        }
        int[] arr = new int[rez.size()];
        int i=0;
        for(Integer el : rez)
            arr[i++]=el;
        return arr;
    }
}
