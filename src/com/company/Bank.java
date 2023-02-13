package com.company;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Bank {
    private Set<Client> clientsList = new HashSet<>();
    Scanner scanner = new Scanner(System.in);

    public void addClient() {
        System.out.println("Введите информацию о клиенте: \"Имя, номер карты, текущий счёт\"");
        String client = scanner.nextLine();
        String delimeter = ", ";
        String[] subClient = client.split(delimeter);
        int currentAccount = Integer.parseInt(subClient[2]);
        Client client1 = new Client(subClient[0], subClient[1], currentAccount);
        if (clientsList.contains(client1))
            System.out.println("Клиент с таким именем уже существует");
        clientsList.add(client1);
        System.out.println("Список клиентов:");
        for (Client i : clientsList)
            System.out.println(i);
    }

    public void payment() {
        System.out.println("Выберите клиента: \"Имя\"");
        Scanner scanner = new Scanner(System.in);
        String clientName = scanner.nextLine();
        System.out.println("Введите сумму платежа");
        int amount = scanner.nextInt();
        for (Client i : clientsList) {
            if (i.name.equals(clientName)) {
                i.pay(amount);
            } else System.out.println("Такого клиента не существует");
        }
    }

    public void deposits() {
        System.out.println("Выберите клиента: \"Имя\"");
        Scanner scanner = new Scanner(System.in);
        String clientName1 = scanner.nextLine();
        System.out.println("Введите сумму пополнения");
        int amount1 = scanner.nextInt();
        for (Client i : clientsList) {
            if (i.name.equals(clientName1)) {
                i.addMoney(amount1);
            } else System.out.println("Такого клиента не существует");
        }
    }

    public void listOfClients() {
        System.out.println("Список клиентов:");
        for (Client i : clientsList) {
            System.out.println(i);
        }
    }
}
