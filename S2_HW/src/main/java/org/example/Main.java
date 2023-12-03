package org.example;

import org.example.animal.Animal;
import org.example.animal.Cat;
import org.example.animal.Dog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/*
1. Создайте абстрактный класс "Animal" с полями "name" и "age".
2. Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
3. Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
    - Выведите на экран информацию о каждом объекте.
    - Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

public class Main {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        ArrayList<Animal> list = new ArrayList<>();
        Dog dog = new Dog("Sharik", 1, "Tail", 4);
        Cat cat = new Cat("Vasilek", 2, "Throat", 4);
        list.add(dog);
        list.add(cat);

        for (Animal animal : list) {
            analyzeClass(animal);
            invokeMakeSound(animal);
        }
    }

    private static void invokeMakeSound(Object o) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> objClass = o.getClass();
        Method makeSound;
        if (objClass == Cat.class){
            makeSound = objClass.getDeclaredMethod("murr");
        } else {
            makeSound = objClass.getDeclaredMethod("wag");
        }
        makeSound.setAccessible(true);
        makeSound.invoke(o);

    }

    public static void analyzeClass(Object o){
        Class<?> objClass = o.getClass();
        System.out.printf("Имя класса: %s\nПоля класса: %s\nРодительский класс: %s\n" +
                "Методы класса: %s\nКонструкторы класса: %s\n",
                objClass, Arrays.toString(objClass.getDeclaredFields()), objClass.getSuperclass(),
                Arrays.toString(objClass.getDeclaredMethods()), Arrays.toString(objClass.getConstructors()));
    }
}