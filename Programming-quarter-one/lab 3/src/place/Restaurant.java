package place;

import item.Food;
import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import person.Person;

import java.util.*;

public class Restaurant extends Place implements Business, Service {

    protected int money = 80000;
    protected List<Item> items = new ArrayList<>();

    FoodFactory factory = new FoodFactory() {
        @Override
        public int makeFood(int income) {
            return ((int) (income / 10));
        }
    };

    class FoodTradeHandler {
        public FoodTradeHandler() {
        }

        public void handleTrade(FoodFactory factory, Restaurant restaurant){
            int income = restaurant.getMoney();
            int totalBottles = (factory.makeFood(income) / 2) / (new Restaurant.Bottle()).getPrice();
            int totalIcecream = (factory.makeFood(income) / 2) / (new Restaurant.Icecream()).getPrice();
            for (int i = 0; i < totalBottles; i++){
                items.add(new Restaurant.Bottle());
            }
            for (int i = 0; i < totalIcecream; i++){
                restaurant.items.add(new Restaurant.Icecream());
            }
            int spent = factory.makeFood(income);
            restaurant.reduceMoney(spent);
        };
    }
    @Override
    public void serve() {
        if (this.items.size() == 0){
            FoodTradeHandler handler = new FoodTradeHandler();
            handler.handleTrade(factory, this);
            System.out.println("Restaurant traded money for food with factory and served their customers.");
        }
        int allFoodAmount = this.items.size();
        for (Person person : visitors) {
            try {
                int rand = (int)(Math.random()*10);
                person.reduceMoney(allFoodAmount / rand);
                this.addMoney(allFoodAmount / rand);
                person.affectSaturation(allFoodAmount/ rand);
                System.out.println(person.getName() + " is served.");
                System.out.println(person.getName() + "'s saturation is " + person.getSaturationLevel());
                person.setStressLevel(StressLevel.HAPPY);
                System.out.println(person.getStressLevel());
            } catch (BankAccountException exc){
                System.out.printf("%s doesn't have enough money to be served. \n", person.getName());
                this.removePerson(person);
                throw new RuntimeException();
            }
        }
    }

    @Override
    public void handle(Set<Person> persons) {
        for (Person person:persons) {
            person.move(this);
        }
        for (Person person:persons) {
            try {
                this.serve();
                System.out.println(this.getItems());
                for (int i = 0; i < ((int)(Math.random()*10));i++){
                    person.buy(this, new Restaurant.Icecream(), new Restaurant.Bottle());
                }
                person.leave(this);
                System.out.println(this.getItems());
                System.out.println(person.getItems());
            } catch (RuntimeException | BankAccountException e) {
                System.out.println(person.getName() + " can't be served.");
                person.leave(this);
            }
        }
    }

    public void sell(Item item, Person customer) throws NotEnteredException, BankAccountException {
        if (!visitors.contains(customer)){
            throw new NotEnteredException("the customer is not in the restaurant");
        } else {
            try {
                this.addMoney(item.getPrice());
                customer.reduceMoney(item.getPrice());
                item.affect(customer);
                customer.addItem(item);
                this.removeItem(item);
            } catch (BankAccountException exc){
                System.out.printf("%s doesn't have enough money to be served. \n", customer.getName());
                this.removePerson(customer);
                throw new RuntimeException();
            }
        }
    }
    public String getItems(){
        return this.toString() + " has " + this.items.toString();
    }

    @Override
    public void addMoney(int amount) {
        this.money += amount;
    }
    @Override
    public void reduceMoney(int amount) {
        this.money -= amount;
    }

    @Override
    public void addItem(Item item){
        items.add(item);
    }
    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    public static class Bottle implements Item, Food{
        @Override
        public void affect(Person person) {
            System.out.printf("%s has bought %s \n",person.getName(), this.toString());
        }

        public void consume(Person person){
            person.affectSaturation(30);
            System.out.println(person.getName() + " drinked from a bottle.");
            System.out.println(person.getName() + "'s saturation is " + person.getSaturationLevel());
        }

        @Override
        public int getPrice() {
            return 40;
        }

        @Override
        public boolean equals(Object obj) {
            if(this.toString() == obj.toString()){
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Bottle";
        }
    }
    public static class Icecream implements Item, Food {
        @Override
        public void affect(Person person) {
            System.out.printf("%s has bought %s \n",person.getName(), this.toString());
        }
        public void consume(Person person){
            person.affectSaturation(-40);
            System.out.println(person.getName() + " ate an icecream.");
            System.out.println(person.getName() + "'s saturation is " + person.getSaturationLevel());
        }

        @Override
        public int getPrice() {
            return 60;
        }

        @Override
        public boolean equals(Object obj) {
            if(this.toString() == obj.toString()){
                return true;
            }
            return false;
        }
        @Override
        public String toString() {
            return "Icecream";
        }
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Restaurant";
    }
}
