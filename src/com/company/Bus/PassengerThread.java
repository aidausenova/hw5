package com.company.Bus;

import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    private Semaphore semaphore;

    public PassengerThread(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    public void run() {
        try {


            System.out.println(this.getName() + " подошел к кассе ");
            semaphore.acquire();
            System.out.println(this.getName() + " купил билет ");
            sleep(2000);
            semaphore.release();
            System.out.println(this.getName() + " сел в автобус ");
        } catch (Exception e) {
        }
    }
}
