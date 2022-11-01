package person;

import other.StressLevel;
import place.Place;

import java.util.Objects;

public class Neznaika extends Person {

    public Neznaika(StressLevel stress, int saturation) {
        this.stressLevel = stress;
        this.saturationLevel = saturation;
    }

    @Override
    public void enter(Place place) {
        System.out.printf("Neznaika came near %s . \n", place.toString());
        place.acceptPerson(this);
    }

    @Override
    public String toString() {
        return "Neznaika";
    }
}
