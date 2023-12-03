package org.example.animal;

public class Dog extends Animal{
    private String waggingMechanism;
    private Integer legsNumber;

    public Dog(String name, Integer age, String waggingMechanism, Integer legsNumber) {
        super(name, age);
        this.waggingMechanism = waggingMechanism;
        this.legsNumber = legsNumber;
    }

    public void wag(){
        System.out.println("Gav! Gav!\n");
    }

}
