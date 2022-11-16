package place;

import other.StressLevel;
import person.Person;

import java.util.HashSet;
import java.util.Set;

public class Park implements Service, Place {
    protected Set<Person> walkers = new HashSet<>();
    @Override
    public void serve() {
        for (Person person : walkers) {
            person.setStressLevel(StressLevel.CALM);
            System.out.println(person.getStressLevel());
        }
    }
    @Override
    public String toString() {
        return "Park";
    }

    @Override
    public void acceptPerson(Person person) {
        System.out.println(person.toString() + " entered the " + this.toString() + ".");
        walkers.add(person);
    }

    @Override
    public void removePerson(Person person) {
        System.out.println(person.toString() + " left the " + this.toString() + ".");
        walkers.remove(person);
    }
}
