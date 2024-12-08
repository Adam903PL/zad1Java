package mammals;
import animals.Animal;
public class Hare extends Animal {
    private static final int MAX_AGE = 5;
    public Hare(int age, boolean gender) {
        super(age, gender);
    }

    @Override
    public boolean grow() {
        setAge(getAge() + 1);
        return getAge() > MAX_AGE;
    }

}
