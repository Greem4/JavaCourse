package edu.javacourse.inteface.interface4;

public class Test {
    public static void main(String[] args) {
        Info infoAnimal = new Animal(1);
        Info infoPerson = new Person("Bob");

        infoAnimal.showInfo();
        infoPerson.showInfo();

        System.out.println("--------------------");

        outputInfo(infoAnimal);
        outputInfo(infoPerson);

        System.out.println("----------------");

        Animal animal = new Animal(2);
        Person person = new Person("Bob2");

        outputInfo(animal);
        outputInfo(person);
    }
    public static void outputInfo(Info info) {
        info.showInfo();
    }
}
