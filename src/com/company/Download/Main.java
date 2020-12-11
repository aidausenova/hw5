package com.company.Download;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(1);
        Uploader up = new Uploader(cdl);
        up.start();
        try {
            cdl.await();
        } catch (Exception ignore) {

        }
        System.out.println("Загрузка завершена!");
        CountDownLatch cdl2 = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.currentThread().sleep(100);


            } catch (Exception e) {


            }
            new Downloaders("User " + i, semaphore, cdl2).start();

        }
        try {
            cdl2.await();
            System.out.println("🚫Файл удален с сервера!!!🚫");

        } catch (Exception i) {
        }

    }
}