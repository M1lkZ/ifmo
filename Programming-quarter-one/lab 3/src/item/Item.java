package item;

import person.Person;

public interface Item {
    void affect(Person person);

    int getPrice();
}
