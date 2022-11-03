import other.BankAccountException;
import other.NotEnteredException;
import other.StressLevel;
import person.Kozlik;
import person.Neznaika;
import person.Person;
import place.*;

public class Main {
    public static void main(String[] args) throws NotEnteredException, BankAccountException {
        Restaurant restaurant = new Restaurant();
        Park park = new Park();
        Neznaika neznaika = new Neznaika(StressLevel.DEPRESSED,50,1000);
        neznaika.enter(restaurant);
        restaurant.serve();
    }
}