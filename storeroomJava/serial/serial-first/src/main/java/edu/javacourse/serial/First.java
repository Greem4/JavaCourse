package edu.javacourse.serial;


import java.io.Serializable;

public class First implements Serializable {
    private static final long serialVersionUID = 199l;
    private String firstCode;
    private String firstName;
    private String firstOther;

    public String getFirstOther() {
        return firstOther;
    }

    public void setFirstOther(String firstOther) {
        this.firstOther = firstOther;
    }

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
