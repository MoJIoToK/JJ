package org.example.task1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student stud1 = new Student("Vasiliy", 18, 5.0);
        Student stud2 = new Student("Marya", 20, 4.6);

        try (FileOutputStream fileOutputStream = new FileOutputStream("S3_HW.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(stud1);
            System.out.println("Объект stud1 сериализован!");
            objectOutputStream.writeObject(stud2);
            System.out.println("Объект stud2 сериализован!");
        }

        try (FileInputStream fileInputStream = new FileInputStream("S3_HW.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            stud1 = (Student) objectInputStream.readObject();
            System.out.println("Объект stud1 десериализован.");
            stud2 = (Student) objectInputStream.readObject();
            System.out.println("Объект stud2 десериализован.");
        }

        System.out.println("Объект stud1 десериализован.");
        System.out.println("Имя: " + stud1.getName());
        System.out.println("Возраст: " + stud1.getAge());
        System.out.println("Средний балл (должен быть null, так как transient): " + stud1.getGPA());

        System.out.println("Объект stud2 десериализован.");
        System.out.println("Имя: " + stud2.getName());
        System.out.println("Возраст: " + stud2.getAge());
        System.out.println("Средний балл (должен быть null, так как transient): " + stud2.getGPA());

    }
}



