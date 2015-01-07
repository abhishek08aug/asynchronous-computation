package in.blogspot.randomcompiler.asynchronous.computation.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import in.blogspot.randomcompiler.asynchronous.computation.api.AsyncCallFailedException;
import in.blogspot.randomcompiler.asynchronous.computation.api.ICall;
import in.blogspot.randomcompiler.asynchronous.computation.api.SyncCallFailedException;

public abstract class AbstractCall implements ICall {
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    @Override
    public Future<String> callAsync(final long milliSeconds) throws AsyncCallFailedException {
        Future<String> future = pool.submit(new Callable<String>() {
            public String call() throws AsyncCallFailedException {
                try {
                    return callSync(milliSeconds, true);
                } catch (SyncCallFailedException e) {
                    throw new AsyncCallFailedException(e);
                }
            }
        });
        System.out.println("Made asynchronous call to callSync()");
        return future;
    }

}
