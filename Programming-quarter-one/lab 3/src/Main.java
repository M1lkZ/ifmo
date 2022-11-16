import item.Item;
import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import person.Julio;
import person.Kozlik;
import person.Neznaika;
import person.Person;
import place.Park;
import place.Restaurant;
import place.TrainStation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NotEnteredException, BankAccountException {
        Restaurant restaurant = new Restaurant();
        Park park = new Park();
        TrainStation trainStation = new TrainStation();
        Julio julio = new Julio(StressLevel.HAPPY, 80, 5000);
        Kozlik kozlik = new Kozlik(StressLevel.DEPRESSED, 40, 500);
        Neznaika neznaika = new Neznaika(StressLevel.DEPRESSED,50,1000);
        julio.enter(trainStation);
        julio.buy(trainStation, new TrainStation.Ticket());
        julio.leave(trainStation);
        System.out.println(julio.getItems());
        julio.celebrate();
        neznaika.read();
        System.out.println(neznaika.getStressLevel());
        System.out.println(kozlik.getStressLevel());
        neznaika.enter(park);
        kozlik.enter(park);
        park.serve();
        neznaika.leave(park);
        kozlik.leave(park);
        neznaika.enter(restaurant);
        kozlik.enter(restaurant);
        restaurant.serve();
        System.out.println(restaurant.getItems());
        neznaika.buy(restaurant, new Restaurant.Bottle());
        kozlik.buy(restaurant, new Restaurant.Icecream(), new Restaurant.Icecream());
        kozlik.leave(restaurant);
        neznaika.leave(restaurant);
        System.out.println(restaurant.getItems());
        System.out.println(neznaika.getItems());
        System.out.println(kozlik.getItems());
        kozlik.consume(1);
        System.out.println(kozlik.getItems());
    }
}