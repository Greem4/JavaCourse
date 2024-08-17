package edu.groovy.lesson17

class OopRunner {
    static void main(String[] args) {
        def student = new Student()
        student.firstName = "Ivan"
        println student.firstName
        println student.'firstName'

        def student1 = new Student(firstName: "Petr", lastName: "Petrov", age: 18)
        println student1
    }
}
