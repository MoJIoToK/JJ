package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x+y);
//            }
//        };

//        PlainInterface plainInterface = Integer::sum;
//        PlainInterface plainInterface1 = Integer::compare;
//
//        System.out.println(plainInterface.action(5,3));
//        System.out.println(plainInterface1.action(1,5));

        //List<String> list = Arrays.asList("Hello", "World", "!", "I", "was", "born");

//        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
//        for (String item: list) {
//            System.out.println(item);
//        }
//
//        list.stream().filter(str -> str.length() > 2).filter(str -> str.contains("o")).forEach(System.out::println);
//
////        Arrays.asList(5,10,3,2,6).stream().map(chislo -> "Число: " + chislo + ". Квадрат числа: "
////                + chislo * chislo).forEach(System.out::println);
//        System.out.println(Arrays.asList(5,10,2,6,4, 5, 10, 1, 100).stream().sorted().distinct().findFirst().get());

        List<User> list = Arrays.asList(new User("Павел", 25), new User("Аркадий", 40),
                new User("Петр", 36));

        list.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age <= 25).forEach(System.out::println);

    }
}