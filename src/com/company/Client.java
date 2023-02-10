package com.company;

public class Client {
    public String name;
    public String cardNumber;
    public int currentAccount;

    public Client(String name, String cardNumber, int currentAccount) {
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

    @Override
    public String toString() {
        return String.format("%s %s %s", " Имя: " + name + '\n', "Номер карты - " + cardNumber + '\n', "Текущий счёт - " + currentAccount + '\n');
    }
}
