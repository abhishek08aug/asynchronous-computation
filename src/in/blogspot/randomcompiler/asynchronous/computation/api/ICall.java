package in.blogspot.randomcompiler.asynchronous.computation.api;

import java.util.concurrent.Future;

public interface ICall {
    public String callSync(long milliSeconds, boolean calledThroughCallAsync) throws SyncCallFailedException;
    
    public Future<String> callAsync(long milliSeconds) throws AsyncCallFailedException;
}