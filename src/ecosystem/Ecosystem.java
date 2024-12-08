package ecosystem;

import animals.Animal;
import mammals.Hare;
import mammals.Macaque;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Ecosystem {
    private List<Animal> animals;

    public Ecosystem(List<Animal> animals) {
        this.animals = animals;
    }
    public void report() {
        int mH = 0,  fH  = 0, mM = 0, fM = 0;

        for (Animal animal : animals) {
            if (animal instanceof Hare) {
                if (animal.isGender()) mH++;
                else  fH ++;
            } else if (animal instanceof Macaque) {
                if (animal.isGender()) mM++;
                else fM++;
            }
        }

        System.out.println("Hares - Males: " + mH + ", Females: " +  fH );
        System.out.println("Macaques - Males: " + mM + ", Females: " + fM);
    }

    public void step() {
        List<Animal> newAnimals = new ArrayList<>();
        Random rnd = new Random();


        animals.removeIf(a -> a.grow());

        List<Hare> mH = new ArrayList<>();
        List<Hare> fH = new ArrayList<>();
        List<Macaque> mM = new ArrayList<>();
        List<Macaque> fM = new ArrayList<>();


        for (Animal a : animals) {
            if (a instanceof Hare h) {
                if (h.isGender()) mH.add(h);
                else fH.add(h);
            } else if (a instanceof Macaque m) {
                if (m.isGender()) mM.add(m);
                else fM.add(m);
            }
        }

        int hPairs = Math.min(mH.size(), fH.size());
        for (int i = 0; i < hPairs; i++) {
            if (mH.get(i).getAge() >= 1 && fH.get(i).getAge() >= 1) {
                for (int j = 0; j < 2; j++) {
                    boolean gender = rnd.nextBoolean();
                    newAnimals.add(new Hare(0, gender));
                }
            }
        }


        int fertM = 0;
        int fertF = 0;
        for (Macaque m : mM) {
            if (m.getAge() >= 3) fertM++;
        }

        for (Macaque f : fM) {
            if (f.getAge() >= 3) fertF++;
        }

        int mPairs = Math.min(fertM * 2, fertF);


        for (int i = 0; i < mPairs; i++) {
            boolean gender = rnd.nextBoolean();
            newAnimals.add(new Macaque(0, gender));
        }


        animals.addAll(newAnimals);
    }


}
