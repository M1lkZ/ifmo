package place;

import other.StressLevel;
import person.Person;

import java.util.HashSet;
import java.util.Set;

public class Park implements Place{
    private Set<Person> vacationers = new HashSet<>();
    @Override
    public String toString() {
        return "Park";
    }

    @Override
    public void acceptPerson(Person person) {
        System.out.println(person.toString() + " entered the park.");
        vacationers.add(person);
    }

    @Override
    public void serve() {
        for (Person person : vacationers) {
            person.setStressLevel(StressLevel.HAPPY);
        }
    }
}
