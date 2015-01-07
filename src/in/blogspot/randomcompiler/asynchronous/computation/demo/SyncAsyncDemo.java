package in.blogspot.randomcompiler.asynchronous.computation.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import in.blogspot.randomcompiler.asynchronous.computation.api.AsyncCallFailedException;
import in.blogspot.randomcompiler.asynchronous.computation.api.ICall;
import in.blogspot.randomcompiler.asynchronous.computation.api.SyncCallFailedException;
import in.blogspot.randomcompiler.asynchronous.computation.impl.Call;

public class SyncAsyncDemo {
    public static void main(String[] args) {
        ICall call = new Call();
        Future<String> future = null;
        try {
            future = call.callAsync(10000);
        } catch (AsyncCallFailedException e) {
            System.out.println("Async call failed");
        }
        try {
            System.out.println("Result from callSync: " + call.callSync(5000, false));
        } catch (SyncCallFailedException e) {
            System.out.println("Sync call failed");
        }
        System.out.println("callAsync is done: " + future.isDone());
        try {
            System.out.println("Result from callAsync: " + future.get());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        }
    }
}
