package mammals;
import animals.Animal;
public class Macaque extends Animal {
    private static final int MAX_AGE = 27;

    public Macaque(int age, boolean gender) {
        super(age, gender);
    }

    @Override
    public boolean grow() {
        setAge(getAge() + 1);
        return getAge() > MAX_AGE;
    }
}
