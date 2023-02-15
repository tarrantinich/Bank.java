package com.company;

public class MyInputException extends Exception {
    public MyInputException(String message) {
        super("Вы ввели недопустимый формат данных. Нужно вводить только буквы.");
    }
}
