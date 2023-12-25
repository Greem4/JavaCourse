package edu.javacourse.close;

public class Resource2 implements AutoCloseable {


    @Override
    public void close() throws Exception {
        System.out.println("Close 2");
//        throw new RuntimeException("CREATE 2");
    }
}
