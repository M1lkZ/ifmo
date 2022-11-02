package place;

import item.Item;
import other.BankAccountException;
import person.Person;

import java.util.HashSet;
import java.util.Set;

public class TrainStation implements Business, Place {
    protected Set<Person> clients = new HashSet<>();

    public static class Ticket implements Item{
        @Override
        public void affect(Person person) {
            System.out.printf("The ticket has no affect on %s",person.toString());
        }

        @Override
        public int getPrice() {
            return 100;
        }

        @Override
        public String toString() {
            return "Ticket";
        }
    }
    @Override
    public void sell(Item item, Person customer) throws BankAccountException {
        customer.reduceMoney(item.getPrice());
        System.out.println("Transaction happened");
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
