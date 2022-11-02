package person;

import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import place.Business;
import place.Place;

import java.util.Objects;

public class Kozlik extends Person{

    public Kozlik(StressLevel stress, int saturation, int money) {
        super(stress, saturation, money);
    }

    @Override
    public void enter(Place place) {
        System.out.printf("Kozlik came near %s . \n", place.toString());
        place.acceptPerson(this);
    }

    @Override
    public void buy(Business place, Item... items) throws NotEnteredException, BankAccountException {
        for (Item item : items) {
            place.sell(item, this);
        }
    }

    @Override
    public String toString() {
        return "Kozlik";
    }
}
