package edu.javaAlishev.junit.less.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class NetworkUtilsTest {
    @Test(timeout = 1000)
    public void getConnectionsShouldReturnFasterThanOneSecond()  {
        NetworkUtils.getConnection();
    }

}