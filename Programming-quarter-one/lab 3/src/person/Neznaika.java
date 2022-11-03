package person;

import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import place.Business;
import place.Place;

public class Neznaika extends Person {
//    protected int saturationLevel;


    public Neznaika(StressLevel stress, int saturation, int money) {
        super(stress, saturation, money);
    }

    @Override
    public void enter(Place place) {
        System.out.printf("Neznaika came near %s. \n", place.toString());
        place.acceptPerson(this);
    }

    @Override
    public void buy(Business place, Item ... items) throws NotEnteredException, BankAccountException {
        for (Item item : items) {
            place.sell(item, this);
        }
    }

    public void read(){
        System.out.println("Neznaika took out the letter and read it.");
    }

    @Override
    public String toString() {
        return "Neznaika";
    }
}
