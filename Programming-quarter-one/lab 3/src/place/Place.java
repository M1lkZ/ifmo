package place;

import person.Person;

import java.util.HashSet;
import java.util.Set;

public abstract class Place {
    protected Set<Person> visitors = new HashSet<>();

    public void acceptPerson(Person person) {
        System.out.println(person.getName() + " entered the " + this.toString() + ".");
        this.visitors.add(person);
    }

    public void removePerson(Person person) {
        System.out.println(person.getName() + " left the " + this.toString() + ".");
        this.visitors.remove(person);
    }
}
