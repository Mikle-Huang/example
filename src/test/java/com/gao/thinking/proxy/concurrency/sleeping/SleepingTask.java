package com.gao.thinking.proxy.concurrency.sleeping;

import com.gao.thinking.proxy.concurrency.definingTask.LiftOff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Calling sleep() to pause for a while
 *
 * @Author »Æ²ý»À
 * @Date 2017-06-02  23:48
 */
public class SleepingTask extends LiftOff{
    private final static Logger logger = LoggerFactory.getLogger(SleepingTask.class);
    public void run(){
        while(countDown-->0){
            System.out.print(status());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        }
    }
    public static void main(String arg[]){
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
