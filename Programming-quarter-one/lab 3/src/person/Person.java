package person;

import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import place.*;

import java.util.ArrayList;
import java.util.List;

public class Person {
    protected int money;
    protected StressLevel stressLevel;
    protected int saturationLevel;
    protected String name;
    protected List<Item> items = new ArrayList<>();

    public Person(String name, StressLevel stress, int saturation, int moneyMultiplier) {
        this.stressLevel = stress;
        this.saturationLevel = saturation;
        this.name = name;
        this.money = genMoney(moneyMultiplier);
    }

    public void act(TrainStation ts, Restaurant restaurant, Park park) {
        System.out.println(this.getName() + " has " + this.getMoney() + "$.");
        if (this.getName() == "Julio"){
            this.move();
            this.enter(ts);
            try {
                this.buy(ts,new TrainStation.Ticket());
                this.leave(ts);
                System.out.println("Julio is out of town with money");
            } catch (BankAccountException e) {
                System.out.println("Julio gets arrested for trying to sneak on the Train.");
            }
        } else {
            this.move();
            this.enter(restaurant);
            try {
                restaurant.serve();
                System.out.println(this.getName() + " is served.");
                System.out.println(restaurant.getItems());
                for (int i = 0; i < ((int)(Math.random()*10));i++){
                    this.buy(restaurant, new Restaurant.Icecream(), new Restaurant.Bottle());
                }
                this.leave(restaurant);
                System.out.println(restaurant.getItems());
                System.out.println(this.getItems());
            } catch (RuntimeException | BankAccountException e) {
                System.out.println(this.getName() + " can't be served.");
            }
            this.move();
            this.enter(park);
            park.serve();
            this.leave(park);
        }
    }


    public void move(){
        this.affectSaturation(-5);
        System.out.println(this.getName() + "'s saturation is " + this.getSaturationLevel());
    }
    public void enter(Place place) {
        place.acceptPerson(this);
    }

    public void leave(Place place) {
        place.removePerson(this);
    }

    public String getItems(){
        return this.getName() + " has " + this.items.toString();
    }

    public void addItem(Item item){
        this.items.add(item);
    }
    public int getSaturationLevel() {
        return saturationLevel;
    }

    public void affectSaturation(int percentage){
        if ((int)(saturationLevel + saturationLevel * (float)percentage / 100) <= 0){
            saturationLevel = 0;
            System.out.println(this.getName() + " is starving.");
            this.stressLevel = StressLevel.WORRIED;
        }
        else if ((int)(saturationLevel + saturationLevel * (float)percentage / 100) > 100){
            saturationLevel = 100;
        } else {
            saturationLevel = (int)(saturationLevel + saturationLevel * (float)percentage / 100);
        }
    }

    public void setStressLevel(StressLevel stressLevel) {
        this.stressLevel = stressLevel;
    }

    public String getStressLevel() {
        return (this.getName() + " is " +  stressLevel);
    }

    public int getMoney() {
        return money;
    }
    public String getName() {
        return this.name;
    }

    public int genMoney(int multiplier) {
        return (int)(Math.random()*100*multiplier);
    }

    public void reduceMoney(int amount) throws BankAccountException {
        if (this.money - amount < 0){
            throw new BankAccountException("Not enough money");
        }
        this.money -= amount;
    }
    public void buy(Business place, Item ... items) throws NotEnteredException, BankAccountException {
        for (Item item : items) {
            place.sell(item, this);
        }
    }
}
