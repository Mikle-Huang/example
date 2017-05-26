package com.gao.thinking.proxy.concurrency.definingTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * adding more threads
 *
 * @Author »Æ²ý»À
 * @Date 2017-05-25  13:52
 */
public class MoreBasicThreads {
    private final static Logger logger = LoggerFactory.getLogger(MoreBasicThreads.class);

    public static void main(String[] args) {
        for(int i=0;i<5;i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff!");
    }
}
