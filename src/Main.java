
import animals.Animal;
import ecosystem.Ecosystem;
import mammals.Hare;
import mammals.Macaque;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> initialAnimals = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            initialAnimals.add(new Hare(1, true));
        }
        for (int i = 0; i < 4; i++) {
            initialAnimals.add(new Hare(1, false));
        }

        for (int i = 0; i < 2; i++) {
            initialAnimals.add(new Macaque(3, true));
        }
        for (int i = 0; i < 3; i++) {
            initialAnimals.add(new Macaque(3, false));
        }

        Ecosystem ecosystem = new Ecosystem(initialAnimals);

        for (int year = 1; year <= 5; year++) {
            System.out.println("Year " + year + ":");
            ecosystem.report();
            ecosystem.step();
            System.out.println();
        }

        System.out.println("Final ecostystem:");
        ecosystem.report();
    }
}
