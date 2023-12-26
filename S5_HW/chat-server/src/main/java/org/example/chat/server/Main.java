package org.example.chat.server;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> clients = new ArrayList<>();

        clients.add("Nick");

        String messageFromClient = "@Nick hello!";
        System.out.println(messageFromClient);
        String[] parts = messageFromClient.split("[,\\s]+");
        for (String part : parts) {
            System.out.println(part);
        }
        String nameToMessage = parts[0].substring(1);
        System.out.println(nameToMessage);

        String specChar = parts[0].substring(0,1);
        System.out.println(specChar);

        if (parts[0].substring(0,1).equals("@") && clients.contains(nameToMessage)) {
            System.out.println("True");
        }

    }
}
