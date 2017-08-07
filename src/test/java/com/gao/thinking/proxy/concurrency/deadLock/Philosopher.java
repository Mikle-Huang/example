package com.gao.thinking.proxy.concurrency.deadLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * A dining Philosopher
 *
 * @Author �Ʋ���
 * @Date 2017-07-30  11:51
 */
public class Philosopher implements Runnable{
    private final static Logger logger = LoggerFactory.getLogger(Philosopher.class);
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);
    private void pause() throws InterruptedException {
        if(ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(
                rand.nextInt(ponderFactor * 250));//����г�ʱ��˼��,�п��ܱȽ��ѳ�������,���ǻ����п���
    }
    public Philosopher(Chopstick left, Chopstick right,
                       int ident, int ponder) {
        this.left = left;
        this.right = right;
        id = ident;
        ponderFactor = ponder;
    }

    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
// Philosopher becomes hungry
                System.out.println(this + " " + "grabbing right");
                right.take();
                System.out.println(this + " " + "grabbing left");
                left.take();
                System.out.println(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch(InterruptedException e) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }
    public String toString() { return "Philosopher " + id; }
}
