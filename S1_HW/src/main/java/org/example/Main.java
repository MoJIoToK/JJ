package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        double sum = 0;
        int count = 0;
        for (Integer elem: list) {
            if (elem %2 ==0){
                sum += elem;
                count++;
            }
        }
        System.out.println(sum/count);

        OptionalDouble avg = list.stream().filter(e -> (e%2==0)).mapToInt(value -> value).average();

        System.out.println(avg);
    }
}