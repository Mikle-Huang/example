package com.gao.thinking.proxy.concurrency.returnValueFromTasks;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * callableDemo
 *
 * @Author »Æ²ý»À
 * @Date 2017-05-31  23:22
 */
public class CallableDemo {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for(int i=0;i<10;i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for(Future<String> fs:results)
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            }finally{
                exec.shutdown();
            }
    }
}


class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id=id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult "+id;
    }
}