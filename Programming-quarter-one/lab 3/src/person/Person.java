package person;

import item.Item;
import other.BankAccountException;
import other.StressLevel;
import place.Place;

public abstract class Person {
    protected int money;
    protected StressLevel stressLevel;
    protected int saturationLevel;
    public abstract void enter(Place place);

    public void affectSaturation(int percentage){
        this.saturationLevel += this.saturationLevel * (percentage/100);
    }

    public void setStressLevel(StressLevel stressLevel) {
        this.stressLevel = stressLevel;
    }

    public StressLevel getStressLevel() {
        return stressLevel;
    }

    public int getMoney() {
        return money;
    }

    public void reduceMoney(int amount) {
        if (this.money - amount < 0){
            throw new BankAccountException("Not enough money");
        }
        this.money -= amount;
    }
    public void increaseMoney(int amount){
        this.money += amount;
    }
    public abstract void buy(Item ... item);
}
