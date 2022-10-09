package pokemons;

import moves.mamoswine.IceFang;

public class Mamoswine extends Piloswine{
    public Mamoswine(String s, int i) {
        super(s, i);
        this.setStats(110,130,80,70,60,80);
        this.addMove(new IceFang());
    }
}
