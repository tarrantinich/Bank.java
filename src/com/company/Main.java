package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank alfaBank = new Bank();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить нового клиента");
            System.out.println("2. Оплата");
            System.out.println("3. Внесение средств");
            System.out.println("4. Вывести информацию о клиентах");
            System.out.println("0. Выход");


            int operation = scanner.nextInt();
            if (0 == operation) {
                System.out.println("Программа завершена!");
                break;
            }
            switch (operation) {
                case 1:
                    alfaBank.addClient();
                    break;
                case 2:
                    alfaBank.payment();
                    break;
                case 3:
                    alfaBank.deposits();
                    break;
                case 4:
                    alfaBank.listOfClients();
                    break;
                default:
                    System.out.println("Такой операции нет");
                    break;
            }
        }
    }
}



