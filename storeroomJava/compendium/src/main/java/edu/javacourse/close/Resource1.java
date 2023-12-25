package edu.javacourse.close;

public class Resource1 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Close 1");
        throw new RuntimeException("CREATE 1");
    }
}
