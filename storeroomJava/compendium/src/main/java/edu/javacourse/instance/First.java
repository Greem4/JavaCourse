package edu.javacourse.instance;

public class First {
    private String name;

    public First() throws SimpleException {
        throw new SimpleException ("CHECK");
    }

    private First(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
