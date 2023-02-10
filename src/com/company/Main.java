package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static Set<Client> addClient(String client, Set<Client> clientsList) {
        String delimeter = ", ";
        String[] subClient = client.split(delimeter);
        int currentAccount = Integer.parseInt(subClient[2]);
        Client client1 = new Client(subClient[0], subClient[1], currentAccount);
        if (clientsList.contains(client1))
            System.out.println("Клиент с таким именем уже существует");
        clientsList.add(client1);
        return clientsList;
    }


    public static void main(String[] args) {
        Set<Client> clientsList = new HashSet<>();
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить нового клиента");
            System.out.println("2. Оплата");
            System.out.println("3. Внесение средств");
            System.out.println("4. Вывести информацию о клиентах");
            System.out.println("0. Выход");

            Scanner scanner = new Scanner(System.in);
            String operation1 = scanner.nextLine();
            int operation = Integer.parseInt(operation1);
            if (0 == operation) {
                System.out.println("Программа завершена!");
                break;
            }
            switch (operation) {
                case 1:
                    System.out.println("Введите информацию о клиенте: \"Имя, номер карты, текущий счёт\"");
                    String client = scanner.nextLine();
                    addClient(client, clientsList);
                    System.out.println("Список клиентов:");
                    for (Client i : clientsList)
                        System.out.println(i);

                    break;
                case 2:
                    System.out.println("Выберите клиента: \"Имя\"");
                    String clientName = scanner.nextLine();
                    System.out.println("Введите сумму платежа");
                    int amount = scanner.nextInt();
                    for (Client i : clientsList) {
                        if (i.name.equals(clientName)) {
                            i.pay(amount);
                        } else System.out.println("Такого клиента не существует");
                    }

                    break;
                case 3:
                    System.out.println("Выберите клиента: \"Имя\"");
                    String clientName1 = scanner.nextLine();
                    System.out.println("Введите сумму пополнения");
                    int amount1 = scanner.nextInt();
                    for (Client i : clientsList) {
                        if (i.name.equals(clientName1)) {
                            i.addMoney(amount1);
                        } else System.out.println("Такого клиента не существует");
                    }
                    break;
                case 4:
                    System.out.println("Список клиентов:");
                    for (Client i : clientsList) {
                        System.out.println(i);
                    }
                    break;

                default:
                    System.out.println("Такой операции нет");
                    break;
            }
        }
    }
}



