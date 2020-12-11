package com.company.Download;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread{

    CountDownLatch cdl;

    public Uploader(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {try {
        for (int i = 1; i <= 25; i++) {

            System.out.print("🥑");

            sleep(500);
        }

            } catch (Exception ignore) {
        }
        System.out.println();
        cdl.countDown();
    }
}
