package edu.groovy.lesson17

trait WithId {
    Integer id

    boolean validateID() {
        id > 0
    }

}