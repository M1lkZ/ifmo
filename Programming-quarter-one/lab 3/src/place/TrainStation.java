package place;

import item.Item;
import other.BankAccountException;
import person.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainStation implements Business, Place {
    protected Set<Person> clients = new HashSet<>();
    protected List<Item> goods = new ArrayList<>();

    int money = 20000;

    public static class Ticket implements Item{
        @Override
        public void affect(Person person) {
            System.out.printf("The ticket has no affect on %s \n",person.toString());
        }


        public int getPrice() {
            return 100;
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
            return "Ticket";
        }
    }
    @Override
    public void sell(Item item, Person customer) throws BankAccountException {
        customer.reduceMoney(item.getPrice());
        this.addMoney(item.getPrice());
        System.out.println("Transaction happened");
        customer.addItem(item);
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
    public void addItem(Item item) {
        this.goods.add(item);
    }

    @Override
    public void removeItem(Item item) {
        this.goods.remove(item);
    }
    public String getItems(){
        return this.toString() + " has " + this.goods.toString();
    }

    @Override
    public void acceptPerson(Person person) {
        System.out.println(person.toString() + " entered the " + this.toString() + ".");
        clients.add(person);
    }
    @Override
    public void removePerson(Person person) {
        System.out.println(person.toString() + " left the " + this.toString() + ".");
        clients.remove(person);
    }
    @Override
    public String toString() {
        return "Train Station";
    }
}
