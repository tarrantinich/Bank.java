package com.company;

import java.util.Objects;

public class Client {
    private String name;
    private int cardNumber;
    private int currentAccount;

    public Client(String name, int cardNumber, int currentAccount) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.currentAccount = currentAccount;
    }

    public int pay(int amount) {
        if (currentAccount < amount) {
            System.out.println("На вашем счёте недостаточно средств");
            System.out.println("======================================================");
        } else {
            currentAccount -= amount;
            System.out.println("Оплата " + amount);
            System.out.println("Баланс " + currentAccount);
            System.out.println("======================================================");
        }
        return currentAccount;
    }

    public int addMoney(int amount) {
        currentAccount += amount;
        System.out.println("Пополнение счёта на " + amount);
        System.out.println("Баланс " + currentAccount);
        System.out.println("======================================================");
        return currentAccount;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !obj.getClass().equals(Client.class)) return false;
        Client newClient = (Client) obj;
        return this.cardNumber == newClient.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", " Имя: " + name + ",", "Номер карты: " + cardNumber + ",", "Текущий счёт: " + currentAccount + '\n');
    }
}
