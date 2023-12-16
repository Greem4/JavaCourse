package edu.javacourse.serial;

import java.io.*;

public class Second extends First implements Externalizable {

    private String secondCode;
    private String secondName;

    public String getSecondCode() {
        return secondCode;
    }

    public void setSecondCode(String secondCode) {
        this.secondCode = secondCode;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(getFirstCode());
        out.writeUTF(getFirstName());
        out.writeUTF(getSecondCode());
        out.writeUTF(getSecondName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setFirstCode(in.readUTF());
        setFirstName(in.readUTF());
        setSecondCode(in.readUTF());
        setSecondName(in.readUTF());
    }
}
