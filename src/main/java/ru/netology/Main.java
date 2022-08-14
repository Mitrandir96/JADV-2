package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final int TIME_CREATE = 500;
        final int DESIRE_BUY = 150;

        List<String> cars = new ArrayList<>();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (cars) {
                    cars.add("Производитель Toyota выпустил 1 авто");
                    cars.notify();
                }
                try {
                    Thread.sleep(TIME_CREATE);
                } catch (InterruptedException e) {
                    return;
                }

            }


        }).start();

        new Thread(() -> {
            synchronized (cars) {
                System.out.println("Покупатель1 зашел в автосалон");
                if (cars.isEmpty()) {
                    System.out.println("Машин нет");
                    try {
                        Thread.sleep(DESIRE_BUY);
                        cars.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(cars.remove(0));
            System.out.println("Покупатель 1 уехал на новеньком авто");


        }).start();

        new Thread(() -> {
            synchronized (cars) {
                System.out.println("Покупатель2 зашел в автосалон");
                if (cars.isEmpty()) {
                    System.out.println("Машин нет");
                    try {
                        Thread.sleep(DESIRE_BUY);
                        cars.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(cars.remove(0));
            System.out.println("Покупатель 2 уехал на новеньком авто");


        }).start();

        new Thread(() -> {
            synchronized (cars) {
                System.out.println("Покупатель3 зашел в автосалон");
                if (cars.isEmpty()) {
                    System.out.println("Машин нет");
                    try {
                        Thread.sleep(DESIRE_BUY);
                        cars.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(cars.remove(0));
            System.out.println("Покупатель 3 уехал на новеньком авто");


        }).start();


    }
}