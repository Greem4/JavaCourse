package edu.groovy.lesson13

class ListRunner {
    static void main(String[] args) {
        def list = [1, 3, 5, 6]
        assert list.getClass() == ArrayList

        // read

        assert list[2] == 5
        assert list.get(2) == 5
        assert list[-1] == 6
        assert list[1..3] == [3, 5, 6]
        assert list[8] == null // out of bounds

        // write
        list += 9
        list << 11 << 13
        assert list == [1, 3, 5, 6, 9, 11, 13]

    }
}
