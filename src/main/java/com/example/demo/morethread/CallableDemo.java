package com.example.demo.morethread;

import java.util.concurrent.*;

/**
 *使用带有返回值的线程
 */
public class CallableDemo implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        CallableDemo callableDemo=new CallableDemo();
        Future<String> future=executorService.submit(callableDemo);
        System.out.println(future.get());//阻塞
        executorService.shutdown();
    }
    @Override
    public String call() throws Exception {
        return "String"+1;
    }
}
