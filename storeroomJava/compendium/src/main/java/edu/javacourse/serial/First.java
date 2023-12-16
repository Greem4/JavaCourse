package edu.javacourse.serial;

import java.io.Serializable;

public class First {
    private static final long serialVersionUID = 199l;
    private String firstCode;
    private String firstName;




    public String getFirstCode() {
        return firstCode;
    }

    public void setFirstCode(String firstCode) {
        this.firstCode = firstCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
