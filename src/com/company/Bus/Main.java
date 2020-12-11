package com.company.Bus;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){

        Semaphore semaphore = new Semaphore(4);

        for (int i = 1; i <= 100; i++) {
            new PassengerThread(" Пассажир " + i, semaphore).start();

        }

    }
}
