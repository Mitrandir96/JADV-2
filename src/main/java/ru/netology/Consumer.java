package ru.netology;

import java.util.List;

public class Consumer extends Thread {

    private final List<String> list;
    final int DESIRE_BUY = 150;


    Consumer(String name, List<String> list) {
        super(name);
        this.list = list;
    }

    public void run() {
        synchronized (list) {
            System.out.printf("%s зашел в автосалон \n", Thread.currentThread().getName());

            if (list.isEmpty()) {
                System.out.println("Машин нет");
                try {
                    Thread.sleep(DESIRE_BUY);
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(list.remove(0));
            System.out.printf("%s уехал на новеньком авто \n", Thread.currentThread().getName());


        }
    }


}
