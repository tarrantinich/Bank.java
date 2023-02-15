package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Bank {
    private Set<Client> clientsList = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    private static <T> T inputInt(String message, Function<String, T> converter) {
        while (true) {
            try {
                System.out.println(message);
                return converter.apply(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вы ввели недопустимый формат данных ");
            }
        }
    }

    private static String inputString(String message) {
        while (true) {
                System.out.println(message);
                String word = scanner.nextLine();
                for (int i = 0; i < word.length(); i++) {
                    if (Character.isDigit(word.charAt(i))==false) {
                        return word;
                    }else System.out.println("Вы ввели недопустимый формат данных ");
                    break;
                }
        }
    }

    public void addClient() throws InputMismatchException {
        System.out.println("Введите информацию о клиенте.");
        String clientName = inputString("Введите имя:");
        int cardNumber = inputInt("Введите номер карты: ", Integer::valueOf);
        int currentAccount = inputInt("Введите текущий баланс карты: ", Integer::valueOf);
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
        int cardNumber = inputInt("Выберите клиента: \"ведите номер карты\"", Integer::valueOf);
        int amount = inputInt("Введите сумму платежа", Integer::valueOf);
        for (Client i : clientsList) {
            if (i.getCardNumber() == cardNumber) i.pay(amount);
        }
        System.out.println("Такого клиента не существует");
    }

    public void deposits() {
        int cardNumber = inputInt("Выберите клиента: \"ведите номер карты\"", Integer::valueOf);
        int amount = inputInt("Введите сумму пополнения", Integer::valueOf);
        for (Client i : clientsList) {
            if (i.getCardNumber() == cardNumber) i.addMoney(amount);
        }
        System.out.println("Такого клиента не существует");
    }

    public void listOfClients() {
        System.out.println("Список клиентов:");
        for (Client i : clientsList) {
            System.out.println(i);
        }
    }
}
