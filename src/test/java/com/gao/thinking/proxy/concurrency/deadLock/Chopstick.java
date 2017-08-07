package com.gao.thinking.proxy.concurrency.deadLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Chopsticks for dining philosophers
 *
 * @Author »Æ²ý»À
 * @Date 2017-07-30  11:50
 */
public class Chopstick {
    private final static Logger logger = LoggerFactory.getLogger(Chopstick.class);  private boolean taken = false;
    public synchronized
    void take() throws InterruptedException {
        while(taken)
            wait();
        taken = true;
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}


