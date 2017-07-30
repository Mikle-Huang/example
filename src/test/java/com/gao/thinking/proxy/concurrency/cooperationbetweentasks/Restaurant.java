package com.gao.thinking.proxy.concurrency.cooperationbetweentasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Producers and consumers
 *
 * @Author 黄昌焕
 * @Date 2017-07-29  9:52
 */
public class Restaurant {
    private final static Logger logger = LoggerFactory.getLogger(Restaurant.class);
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) {
        new Restaurant();
    }

}
class Meal {
    private final int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}
class WaitPerson implements Runnable {
    private Restaurant restaurant;
    public WaitPerson(Restaurant r) { restaurant = r; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                }
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }
            }
        } catch(InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}
class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant r) { restaurant = r; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if(++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized(restaurant.waitPerson) {
                    System.out.println("make a new meal ");
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                //TimeUnit.MILLISECONDS.sleep(100);//shutdownNow()后执行到这里才抛出异常,如果没有这句,那么会执行loop的top中while条件判断,然后结束程序,没有异常抛出
            }
        } catch(InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}













