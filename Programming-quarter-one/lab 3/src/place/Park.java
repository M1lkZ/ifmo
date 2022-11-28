package place;

import other.StressLevel;
import person.Person;

import java.util.HashSet;
import java.util.Set;

public class Park extends Place implements Service {
    @Override
    public void serve() {
        for (Person person : visitors) {
            person.setStressLevel(StressLevel.CALM);
            System.out.println(person.getStressLevel());
        }
    }
    @Override
    public String toString() {
        return "Park";
    }

}
