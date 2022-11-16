package person;

import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import place.Business;
import place.Place;

public class Julio extends Person{

    public Julio(StressLevel stress, int saturation, int money) {
        super(stress, saturation, money);
    }

    @Override
    public void enter(Place place) {
        System.out.printf("Julio came to the %s. \n", place.toString());
        place.acceptPerson(this);
    }

    @Override
    public void buy(Business place, Item... items) throws NotEnteredException, BankAccountException {
        for (Item item: items) {
            place.sell(item, this);
            System.out.printf("Julio bought the %s at the %s \n", item, place);
        }
    }

    public void celebrate(){
        System.out.println(this.getStressLevel() + " and celebrating his scam in different city");
    }

    @Override
    public String toString() {
        return "Julio";
    }
}
