package pokemons;

import moves.piloswine.Amnesia;

public class Piloswine extends Swinub {
    public Piloswine(String s, int i) {
        super(s, i);
        this.setStats(100,100,80,60,60,50);
        this.addMove(new Amnesia());
    }
}
