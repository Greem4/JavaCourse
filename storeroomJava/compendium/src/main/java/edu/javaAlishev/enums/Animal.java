package edu.javaAlishev.enums;

public enum Animal {
    DOG("собака"), CAT("кошка"), FROG("лягушка");
    private String translation;
    Animal(String translations) {
        this.translation = translations;
    }

    public String getTranslation() {
        return translation;
    }

    @Override
    public String toString() {
        return "перевод на русский язык " +  translation;
    }
}
