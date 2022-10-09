import persons.Kozlik;
import persons.Neznaika;
import persons.Person;

public class Main {
    public static void main(String[] args) {
        Person Notknower = new Neznaika();
        Person Kozlik = new Kozlik();
        System.out.println(Notknower.hashCode());
        System.out.println(Notknower.toString());
        System.out.println(Notknower.equals(Kozlik));
        System.out.println(Kozlik.returnName());
    }
}