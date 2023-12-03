package org.example.animal;

public class Cat extends Animal{
    private static final String ANIMAL_FAMILY = "Семейство кошачьих";
    private String murrMechanism;
    private Integer legsNumber;

    public Cat(String name, Integer age, String murrMechanism, Integer legsNumber) {
        super(name, age);
        this.murrMechanism = murrMechanism;
        this.legsNumber = legsNumber;
    }

    public void murr(){
        System.out.println("Meow! Meow!\n");
    }

}
