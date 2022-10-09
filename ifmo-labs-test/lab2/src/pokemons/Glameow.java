package pokemons;

import moves.glameow.AerialAce;
import moves.glameow.DreamEater;
import moves.glameow.Facade;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Glameow extends Pokemon {
    public Glameow(String s, int i) {
        super(s, i);
        this.setType(Type.NORMAL);
        this.setStats(49,55,42,42,37,85);
        this.setMove(new AerialAce(), new DreamEater(), new Facade());
    }
}
