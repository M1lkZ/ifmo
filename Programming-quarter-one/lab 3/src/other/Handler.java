package other;

import person.Person;
import place.Park;
import place.Restaurant;
import place.TrainStation;

import java.util.Set;

public class Handler {
    public static void handle(Set<Person> persons, TrainStation ts, Restaurant restaurant, Park park){
        for (Person person: persons) {
            System.out.println(person.getName() + " has " + person.getMoney() + "$.");
            if (person.getName() == "Julio"){
                person.move(ts);
                try {
                    person.buy(ts,new TrainStation.Ticket());
                    person.leave(ts);
                    System.out.println("Julio is out of town with money");
                } catch (BankAccountException e) {
                    System.out.println("Julio gets arrested for trying to sneak on the Train.");
                }
                persons.remove(person);
            }
        }
        park.handle(persons);
        restaurant.handle(persons);
    }
}
