package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Thread {

    private final List<String> list;

    public Seller(List<String> list) {
        this.list = list;
    }

    final int TIME_CREATE = 500;


    public void run() {
        synchronized (list) {
            list.add("Производитель Toyota выпустил 1 авто");
            list.notify();
        }
        try {
            Thread.sleep(TIME_CREATE);
        } catch (InterruptedException e) {
            return;
        }


    }
}
