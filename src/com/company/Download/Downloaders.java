package com.company.Download;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread{
    Semaphore semaphore;
    CountDownLatch cdl;


    public Downloaders(String name, Semaphore semaphore, CountDownLatch cdl) {
        super(name);
        this.semaphore = semaphore;
        this.cdl = cdl;
    }
    public void run(){
        try {
            System.out.println(getName() + " присоединяется к серверу");
            semaphore.acquire();
            System.out.println(getName() + " начало загрузки");
            for (int i = 0; i <= 100; i++) {
                sleep(10);
            }
            System.out.println(getName() + " завершена загрузка в сервере");
            semaphore.release();
            cdl.countDown();
        }catch (Exception e){
        }
    }
}
