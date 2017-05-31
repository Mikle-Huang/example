package com.gao.thinking.proxy.concurrency.usingExecutor;

import com.gao.thinking.proxy.concurrency.definingTask.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * fixedthreadpool
 *
 * @Author »Æ²ý»À
 * @Date 2017-05-28  15:19
 */
public class FixedThreadPool {
    public static void main(String[] args){
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
