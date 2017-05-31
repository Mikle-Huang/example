package com.gao.thinking.proxy.concurrency.usingExecutor;

import com.gao.thinking.proxy.concurrency.definingTask.LiftOff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * single thread executor
 *
 * @Author »Æ²ý»À
 * @Date 2017-05-30  12:25
 */
public class SingleThreadExecutor {
    private final static Logger logger = LoggerFactory.getLogger(SingleThreadExecutor.class);
    public static void main(String[] args){
        ExecutorService exec= Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
