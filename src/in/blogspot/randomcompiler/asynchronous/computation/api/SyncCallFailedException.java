package in.blogspot.randomcompiler.asynchronous.computation.api;

public class SyncCallFailedException extends Exception {
    private static final long serialVersionUID = 5909464498003258189L;

    public SyncCallFailedException(Throwable e) {
        super(e);
    }
}
