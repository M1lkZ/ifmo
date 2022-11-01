package place;

import person.Person;

import java.util.HashSet;
import java.util.Set;

public class Restaurant implements Place{
    private Set<Person> visitors = new HashSet<>();
    @Override
    public void acceptPerson(Person person) {
        System.out.println(person.toString() + " entered the restaurant.");
        visitors.add(person);
    }

    @Override
    public void serve() {
        for (Person person : visitors) {
            person.reduceMoney(500);
            person.affectSaturation((int) (Math.random() * 100));
        }
    }

}
