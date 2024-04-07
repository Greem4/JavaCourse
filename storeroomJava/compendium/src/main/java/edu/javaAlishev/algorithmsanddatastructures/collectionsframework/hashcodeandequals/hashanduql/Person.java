package edu.javaAlishev.algorithmsanddatastructures.collectionsframework.hashcodeandequals.hashanduql;

import java.util.Objects;

public class Person {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    // {object} -> {int}
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /*
       Контракт hashcode() equals()
       1) У двух проверяемых объектов вызываем метод hashcode()
       если хэши разные -> два объекта точно разные.

       2) Если хэши одинаковые -> equals()

       3) equals() -> ответ
     */
}
