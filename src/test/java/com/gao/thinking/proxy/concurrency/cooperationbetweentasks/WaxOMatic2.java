package com.gao.thinking.proxy.concurrency.cooperationbetweentasks;

import com.gao.thinking.proxy.concurrency.definingTask.LiftOff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Using explicit Lock and Condition objects
 *
 * @Author »Æ²ý»À
 * @Date 2017-07-29  11:20
 */
public class WaxOMatic2 {
    private final static Logger logger = LoggerFactory.getLogger(WaxOMatic2.class);
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
    class Car {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private boolean waxOn = false;
        public void waxed() {
            lock.lock();
            try {
                waxOn = true; // Ready to buff
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
        public void buffed() {
            lock.lock();
            try {
                waxOn = false; // Ready for another coat of wax
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
        public void waitForWaxing() throws InterruptedException {
            lock.lock();
            try {
                while(waxOn == false)
                    condition.await();
            } finally {
                lock.unlock();
            }
        }
        public void waitForBuffing() throws InterruptedException{
            lock.lock();
            try {
                while(waxOn == true)
                    condition.await();
            } finally {
                lock.unlock();
            }
        }
    }
    class WaxOn implements Runnable {
        private Car car;
        public WaxOn(Car c) { car = c; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    System.out.println("Wax On! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.waxed();
                    car.waitForBuffing();
                }
            } catch(InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax On task");
        }
    }
    class WaxOff implements Runnable {
        private Car car;
        public WaxOff(Car c) { car = c; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    car.waitForWaxing();
                    System.out.println("Wax Off! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.buffed();
                }
            } catch(InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax Off task");
        }
    }


