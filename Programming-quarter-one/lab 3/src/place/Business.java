package place;

import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import person.Person;

public interface Business {
    void sell(Item item, Person customer) throws NotEnteredException, BankAccountException;
    void addMoney(int amount);

    void reduceMoney(int amount);

    void addItem(Item item);

    void removeItem(Item item);
    String getItems();
}
