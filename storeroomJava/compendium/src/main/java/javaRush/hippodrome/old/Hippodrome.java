package javaRush.hippodrome.old;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private static List<Horse> horses;


    public static void main(String[] args) {
        List<Horse> horseList = new ArrayList<>();

        Horse horse1 = new Horse("horse1", 3.0, 0.0);
        Horse horse2 = new Horse("horse2", 3.0, 0.0);
        Horse horse3 = new Horse("horse3", 3.0, 0.0);

        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);

        game = new Hippodrome(horseList);

        game.run();
        game.getWinner();
        game.printWinner();
    }

    void run() {
        for (int i = 1; i < 101; i++) {
            move();
            print();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 1; i < 11; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double maxDistance = 0;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
}
