package place;

import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import person.Person;

import java.util.HashSet;
import java.util.Set;

public class Restaurant implements Business, Service, Place {

    protected int money = 10000;
    protected Set<Person> visitors = new HashSet<>();

    @Override
    public void acceptPerson(Person person) {
        System.out.println(person.toString() + " entered the " + this.toString() + ".");
        visitors.add(person);
    }

    @Override
    public void removePerson(Person person) {
        System.out.println(person.toString() + " left the " + this.toString() + ".");
        visitors.remove(person);
    }

    FoodFactory factory = new FoodFactory() {
        @Override
        public int makeFood(int income) {
            return ((int) (income / 10));
        }
    };

    class FoodTradeHandler {
        public FoodTradeHandler() {
        }

        public int handleTrade(FoodFactory factory, Restaurant restaurant){
            int income = restaurant.getMoney();
            return factory.makeFood(income);

        };
    }
    @Override
    public void serve() {
        FoodTradeHandler handler = new FoodTradeHandler();
        int allFoodAmount = handler.handleTrade(factory,this);
        for (Person person : visitors) {
            try {
                person.reduceMoney(allFoodAmount / (int)(Math.random()*100));
                person.affectSaturation(allFoodAmount/(int)(Math.random()*100));
                System.out.println(person.toString() + "'s saturation is " + person.getSaturationLevel());
            } catch (BankAccountException exc){
                System.out.printf("%s doesn't have enough money to be served. \n", person.toString());
            }
        }
    }
    public void sell(Item item, Person customer) throws NotEnteredException, BankAccountException {
        if (!visitors.contains(customer)){
            throw new NotEnteredException("the customer is not in the restaurant");
        } else {
            customer.reduceMoney(item.getPrice());
            item.affect(customer);
        }
    }
    public static class Bottle implements Item{
        @Override
        public void affect(Person person) {
            person.affectSaturation(30);
            System.out.println(person.toString() + "'s saturation is " + person.getSaturationLevel());
        }

        @Override
        public int getPrice() {
            return 40;
        }

        @Override
        public String toString() {
            return "Bottle";
        }
    }
    public static class Icecream implements Item {
        @Override
        public void affect(Person person) {
            person.affectSaturation(-40);
            System.out.printf("%s's saturation is %o \n",person.toString(),person.getSaturationLevel());
        }

        @Override
        public int getPrice() {
            return 60;
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
