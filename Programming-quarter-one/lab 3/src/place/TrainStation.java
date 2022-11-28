package place;

import item.Item;
import other.BankAccountException;
import person.Person;

import java.util.ArrayList;
import java.util.List;

public class TrainStation extends Place implements Business {
    protected List<Item> goods = new ArrayList<>();

    int money = 20000;

    public static class Ticket implements Item{
        @Override
        public void affect(Person person) {
            System.out.printf("The ticket has no affect on %s \n",person.getName());
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
        try {
            customer.reduceMoney(item.getPrice());
        } catch (BankAccountException e) {
            System.out.println(customer.getName() + " can't afford " + item.toString());
            this.removePerson(customer);
        }
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
    public String toString() {
        return "Train Station";
    }
}
