package person;

import item.Food;
import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import place.Business;
import place.Place;

public class Kozlik extends Person{

    public Kozlik(StressLevel stress, int saturation, int money) {
        super(stress, saturation, money);
    }

    public void consume(int amount){
        for (int i = 0; i < amount; i++){
            try {
                Food food = (Food) items.get(i);
                food.consume(this);
                items.remove(items.get(i));
            } catch (ClassCastException e) {
                System.out.println("not a food item!");
            }
        }
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
