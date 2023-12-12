package org.example.task2;

import java.io.*;


public class Student implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private double GPA;
    private boolean isExpelled;

    //region Конструкторы

    public Student() {
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.GPA = gpa;
        isExpelled = false;
    }

    //endregion

    //region Externalizable implementation

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeDouble(GPA);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        GPA = in.readDouble();
    }

    //endregion

    //region Методы

    /**
     * Получить статус студента
     * @return статус студента
     */
    public boolean isExpelled() {
        return isExpelled;
    }

    /**
     * Изменить статус студента
     * @param expelled новый статус студента
     */
    public void setExpelled(boolean expelled) {
        isExpelled = expelled;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    //endregion

}
