package com.gao.thinking.proxy.concurrency.usingExecutor;

import com.gao.thinking.proxy.concurrency.definingTask.LiftOff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * using executors to run thread
 *
 * @Author »Æ²ý»À
 * @Date 2017-05-26  17:27
 */
public class CachedThreadPool {
    private final static Logger logger = LoggerFactory.getLogger(CachedThreadPool.class);
    public static void main(String[] args){
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
