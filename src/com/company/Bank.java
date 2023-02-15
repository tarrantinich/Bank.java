package com.company;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Bank {
    private Set<Client> clientsList = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    static int inputInt(String message) {
        while (true) {
            System.out.println(message);
            String word = scanner.nextLine();
            if (word.length() != 0 && word.matches("\\d*$")) {
                int word1 = Integer.parseInt(word);
                return word1;
            } else System.out.println("Вы ввели недопустимый формат данных. Нужно вводить только цифры");
        }
    }

    private static String inputString(String message) {
        while (true) {
            System.out.println(message);
            String word = scanner.nextLine();
            if (word.length() != 0 && word.matches("[а-яА-Я]*$")) {
                return word;
            } else System.out.println("Вы ввели недопустимый формат данных. Нужно вводить только буквы.");
        }
    }

    public void addClient() {
        System.out.println("Введите информацию о клиенте.");
        String clientName = inputString("Введите имя:");
        int cardNumber = inputInt("Введите номер карты: ");
        int currentAccount = inputInt("Введите текущий баланс карты: ");
        Client client = new Client(clientName, cardNumber, currentAccount);
        if (clientsList.contains(client)) {
            System.out.println("Клиент с таким номером карты уже существует");
        }
        clientsList.add(client);
        System.out.println("Список клиентов:");
        for (Client i : clientsList)
            System.out.println(i);
    }

    public void payment() {

        int cardNumber = inputInt("Выберите клиента: \"ведите номер карты\"");
        int amount = inputInt("Введите сумму платежа");
        String temp = null;
        for (Client i : clientsList) {
            if (i.getCardNumber() == cardNumber) {
                i.pay(amount);
                temp = "Операция совершена";
            }
        }
        if (temp.length() == 0) System.out.println("Такого клиента не существует");
    }

    public void deposits() {
        int cardNumber = inputInt("Выберите клиента: \"ведите номер карты\"");
        int amount = inputInt("Введите сумму пополнения");
        String temp = null;
        for (Client i : clientsList) {
            if (i.getCardNumber() == cardNumber) {
                i.addMoney(amount);
                temp = "Операция совершена";
            }
        }
        if (temp.length() == 0) System.out.println("Такого клиента не существует");
    }

    public void listOfClients() {
        System.out.println("Список клиентов:");
        for (Client i : clientsList) {
            System.out.println(i);
        }
    }
}
