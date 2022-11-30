package place;

import other.BankAccountException;
import person.Person;

import java.util.Set;

public interface Service {
    void serve();
    public void handle(Set<Person> persons);
}
