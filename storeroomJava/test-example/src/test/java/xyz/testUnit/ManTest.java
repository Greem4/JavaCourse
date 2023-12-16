package xyz.testUnit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ManTest {

    @Test
    public void getFullName() {
        Man man = new Man("Eva", "lo", 30);
        String fullName = man.getFullName();
        Assertions.assertEquals("Eva lo", fullName);
    }
    @Test
    public void getFullInfo() {
        Man man = new Man("Eva", "lo", 30);
        String fullName = man.getFullInfo();
        Assertions.assertEquals("Eva lo age+ 30", fullName);
    }


}