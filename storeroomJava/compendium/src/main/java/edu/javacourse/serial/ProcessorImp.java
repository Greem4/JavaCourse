package edu.javacourse.serial;

public class ProcessorImp implements Processor {
    @Override
    public String process(String code, String name) {
        return code + " :" + name;
    }
}
