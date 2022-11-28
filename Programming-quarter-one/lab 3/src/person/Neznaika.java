package person;

import other.StressLevel;

public class Neznaika extends Person {

    public Neznaika(String name, StressLevel stress, int saturation, int moneyMultiplier) {
        super(name, stress, saturation, moneyMultiplier);
    }

    public void read_letter(){
        System.out.println("Neznaika took the letter out and read it");
    }
}
