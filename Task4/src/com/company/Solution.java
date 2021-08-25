package com.company;

public class Solution{
    public static int solution(int[] l){
        int contor = 0;
        for(int i = 0; i < l.length; i++)
            for(int j = i+1; j < l.length ;j++)
                if( l[j] % l[i] == 0)
                    for(int k = j +1; k < l.length; k++)
                        if( l[k] % l[j] == 0)
                            contor ++;
        return contor;
    }
}
