package com.gao.thinking.proxy.concurrency.daemonthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * daemon threads do not prevent the program from ending
 *
 * @Author »Æ²ý»À
 * @Date 2017-06-06  8:41
 */
public class SimpleDaemons implements Runnable{
    private final static Logger logger = LoggerFactory.getLogger(SimpleDaemons.class);

    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
