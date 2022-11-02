package place;

import person.Person;

import java.util.HashSet;
import java.util.Set;

public interface Place {
    public void acceptPerson(Person person);
    public void removePerson(Person person);
}
