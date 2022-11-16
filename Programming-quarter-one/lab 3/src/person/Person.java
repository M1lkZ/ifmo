package person;

import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import place.Business;
import place.Place;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    protected int money;
    protected StressLevel stressLevel;
    protected int saturationLevel;

    protected List<Item> items = new ArrayList<>();
    public abstract void enter(Place place);

    public Person(StressLevel stress, int saturation, int money) {
        this.stressLevel = stress;
        this.saturationLevel = saturation;
        this.money = money;
    }
    public void leave(Place place) {
        place.removePerson(this);
    }

    public String getItems(){
        return this.toString() + " has " + this.items.toString();
    }


    public void addItem(Item item){
        this.items.add(item);
    }
    public int getSaturationLevel() {
        return saturationLevel;
    }

    public void affectSaturation(int percentage){
        if ((int)(saturationLevel + saturationLevel * (float)percentage / 100) < 100){
            saturationLevel = (int)(saturationLevel + saturationLevel * (float)percentage / 100);
        } else {
            saturationLevel = 100;
        }

    }

    public void setStressLevel(StressLevel stressLevel) {
        this.stressLevel = stressLevel;
    }

    public String getStressLevel() {
        return (this.toString() + " is " +  stressLevel);
    }

    public int getMoney() {
        return money;
    }

    public void reduceMoney(int amount) throws BankAccountException {
        if (this.money - amount < 0){
            throw new BankAccountException("Not enough money");
        }
        this.money -= amount;
    }
    public abstract void buy(Business place,Item ... items) throws NotEnteredException, BankAccountException;
}
