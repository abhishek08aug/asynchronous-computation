package in.blogspot.randomcompiler.asynchronous.computation.impl;

import in.blogspot.randomcompiler.asynchronous.computation.api.SyncCallFailedException;

public class Call extends AbstractCall {

    @Override
    public String callSync(long milliSeconds, boolean calledThroughCallAsync) throws SyncCallFailedException {
        try {
            Thread.currentThread().sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new SyncCallFailedException(e);
        }
        if(calledThroughCallAsync) {
            System.out.println("Asynchronous call got over without any errors in " + milliSeconds + " ms");
        } else {
            System.out.println("Synchronous call got over without any errors in " + milliSeconds + " ms");
        }
        
        return "xyz";
    }

}
