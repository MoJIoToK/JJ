package org.example.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

    public static final String FILE_JSON = "students.json";
    public static final String FILE_BIN = "students.bin";
    public static final String FILE_XML = "students.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();


    public static void addNewStudent(Scanner scanner, List<Student> students) {
        System.out.println("Введите имя студента:");
        String name = scanner.nextLine();

        System.out.println("Введите возраст студента:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите средний балл:");
        double GPA = Double.parseDouble(scanner.nextLine());

        students.add(new Student(name, age, GPA));
        save(students);

        System.out.println("Сведения о студенте добавлены в базу данных.");
    }

    public static void saveStudentsToFile(String fileName, List<Student> students) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), students);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(students);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), students);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    students = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        students = (List<Student>) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    students = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return students;
    }

    public static void markStudent(Scanner scanner, List<Student> students) {
        System.out.println("Введите порядковый номер студента для отчисления:");
        String input = scanner.nextLine();

        try {
            int StudentNumber = Integer.parseInt(input) - 1;
            if (StudentNumber >= 0 && StudentNumber < students.size()) {
                if (!students.get(StudentNumber).isExpelled()) {
                    students.get(StudentNumber).setExpelled(true);
                    System.out.println("Студент отмечен, как кандидат на отчисление.");
                } else {
                    students.get(StudentNumber).setExpelled(false);
                    System.out.println("Студент больше не кандидат на отчисление.");
                }
                save(students);

            } else {
                System.out.println("Некорректный номер студента. Попробуйте снова.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Попробуйте снова.");
        }
    }

    public static void displayStudents(List<Student> tasks) {
        System.out.println("\nСПИСОК СТУДЕНТОВ:");
        for (int i = 0; i < tasks.size(); i++) {
            Student student = tasks.get(i);
            String status = student.isExpelled() ? "[x]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " +
                    student.getName() + ", возраст: " + student.getAge() +
                    ", средний балл: " + student.getGPA() + "\n");
        }
    }

    public static void save(List<Student> students){
        saveStudentsToFile(FILE_JSON, students);
        saveStudentsToFile(FILE_BIN, students);
        saveStudentsToFile(FILE_XML, students);
    }

}
