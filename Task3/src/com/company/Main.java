package com.company;

public class Main {

    public static void main(String[] args) {
        int[] da = new int[]{ 19, 14, 28 };
        int[] sol = Solution.solution(5,da);
        for(int el: sol){
            System.out.print(el);
            System.out.print(" ");
        }
    }
}
