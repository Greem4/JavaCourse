package edu.groovy.lesson19

class IORunner {

    static void main(String[] args) {
        def file = new File(".gitignore")
        println file.text

        file.each {line -> println line}
        file.withInputStream {
            def allText = new String(it.readAllBytes())
            println allText
        }
    }
}
 