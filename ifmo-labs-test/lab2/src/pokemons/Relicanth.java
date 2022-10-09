package pokemons;

import moves.replicanth.DoubleTeam;
import moves.replicanth.Rest;
import moves.replicanth.Tackle;
import moves.replicanth.Waterfall;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Relicanth extends Pokemon {
    public Relicanth(String s, int i) {
        super(s, i);
        this.setType(Type.WATER, Type.ROCK);
        this.setMove(new DoubleTeam(), new Rest(), new Tackle(), new Waterfall());
        this.setStats(100,90,130,45,65,55);
    }

}
