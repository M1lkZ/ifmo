package pokemons;

import moves.purugly.BodySlam;

public class Purugly extends Glameow {
    public Purugly(String s, int i) {
        super(s, i);
        this.addMove(new BodySlam());
        this.setStats(71,82,64,64,59,112);
    }
}
