package edu.groovy

class Test {

    static void main(String[] args) {
        def list = [1, 2, 3, 4, 5, 6, 7]

        0.upto(list.size()) {value ->
            println value
        }
    }

}
