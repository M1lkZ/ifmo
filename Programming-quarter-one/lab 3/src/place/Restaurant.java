package place;

import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import person.Person;

import java.util.HashSet;
import java.util.Set;

public class Restaurant implements Business, Service, Place {
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
        public int makeFood() {
            return (int)(Math.random()*100);
        }
    };
    @Override
    public void serve() {
        for (Person person : visitors) {
            try {
                person.reduceMoney(500);
                person.affectSaturation(factory.makeFood());
                System.out.printf("%s's saturation is %o \n",person.toString(),person.getSaturationLevel());
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
            System.out.printf("%s's saturation is %o \n",person.toString(),person.getSaturationLevel());
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
    public Set<Person> getVisitors() {
        return visitors;
    }

    @Override
    public String toString() {
        return "Restaurant";
    }
}
