package in.blogspot.randomcompiler.asynchronous.computation.api;

public class AsyncCallFailedException extends Exception {
    private static final long serialVersionUID = -2884062743459740236L;

    public AsyncCallFailedException(Throwable e) {
        super(e);
    }
}
