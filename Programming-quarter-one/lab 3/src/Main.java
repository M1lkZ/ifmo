import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import person.Kozlik;
import person.Neznaika;
import person.Person;
import place.Business;
import place.Place;
import place.Restaurant;
import place.Service;

public class Main {
    public static void main(String[] args) throws NotEnteredException, BankAccountException {
        Restaurant restaurant = new Restaurant();
        Neznaika zhizha = new Neznaika(StressLevel.DEPRESSED,15,1000);
        Kozlik zhozha = new Kozlik(StressLevel.HAPPY,10,5000);
        zhizha.enter(restaurant);
        zhozha.enter(restaurant);
        zhozha.buy(restaurant,new Restaurant.Bottle());
        restaurant.serve();
        zhizha.read();
    }
}