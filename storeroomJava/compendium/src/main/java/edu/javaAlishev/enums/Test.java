package edu.javaAlishev.enums;

public class Test {
    public static void main(String[] args) {
//        Animal animal = Animal.CAT;
//        System.out.println(animal);
//        Animal animal = Animal.DOG;
//
//        switch (animal) {
//            case CAT -> System.out.println("It's a cat");
//            case DOG -> System.out.println("It's a dog");
//            case FROG -> System.out.println("It's a frog");
//        }
//
//        Season season = Season.SUMMER;
//
//        switch (season) {
//            case SUMMER -> System.out.println("It's a summer");
//            case WINTER -> System.out.println("It's a winter");
//        }

        Season season = Season.WINTER;
        Animal animal = Animal.CAT;
        System.out.println(season.getTemperature());
        System.out.println(season.name());
        System.out.println(animal.name());

        Animal frog = Animal.valueOf("FROG");
        System.out.println(frog.getTranslation());
        System.out.println(frog.ordinal());
    }
}
