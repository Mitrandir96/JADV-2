package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> cars = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Consumer("Покупатель" + (i+1), cars).start();
            new Seller(cars).start();

        }







    }
}