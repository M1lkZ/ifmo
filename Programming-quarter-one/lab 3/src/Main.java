import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import person.Neznaika;
import person.Person;
import place.Park;
import place.Restaurant;
import place.TrainStation;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NotEnteredException, BankAccountException {
        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Julio", StressLevel.HAPPY, 80,500));
        persons.add(new Person("Kozlik", StressLevel.DEPRESSED, 40,20));
        persons.add(new Neznaika("Neznaika", StressLevel.DEPRESSED,50,30));
        TrainStation trainStation = new TrainStation();
        Restaurant restaurant = new Restaurant();
        Park park = new Park();
        for (Person person : persons) {
            person.act(trainStation,restaurant,park);
        }
    }
}