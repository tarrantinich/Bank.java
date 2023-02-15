package com.company;

import static com.company.Bank.inputInt;

public class Main {
    public static void main(String[] args) {
        Bank alfaBank = new Bank();
        while (true) {
            String message = "Выберите операцию и введите её номер:" + '\n' + "1. Добавить нового клиента" + '\n' + "2. Оплата" + '\n' + "3. Внесение средств" + '\n' + "4. Вывести информацию о клиентах" + '\n' + "0. Выход";
            int operation = inputInt(message);
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



