package com.gao.thinking.proxy.concurrency.definingTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * countdown to liftoff
 *
 * @Author 黄昌焕
 * @Date 2017-05-25  11:50
 */
public class LiftOff implements Runnable{
    private final static Logger logger = LoggerFactory.getLogger(LiftOff.class);
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;//标识这是第几个task
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown=countDown;
    }
    public String status(){
        return "#" + id + "(" + (countDown>0?countDown:"liftOff!")+"),";
    }

    @Override
    public void run() {
        while(countDown-->0){
            System.out.print(status());
            Thread.yield();
        }
    }
}

class MainThread{
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
