package com.gao.thinking.proxy.concurrency.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * shows the use of thread priorities
 *
 * @Author »Æ²ý»À
 * @Date 2017-06-05  21:05
 */
public class SimplePriorities implements Runnable{
    private int countDown=5;
    private volatile double d;
    private int priority;
    public SimplePriorities(int priority){
        this.priority=priority;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for(int i=1;i<100000;i++){
                d+=(Math.PI+Math.E)/(double) i;
                if(i%1000==0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown==0)return;
        }
    }
    public String toString(){
        return Thread.currentThread()+":"+countDown;
    }
    public static void main(String[] args){
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++)
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
