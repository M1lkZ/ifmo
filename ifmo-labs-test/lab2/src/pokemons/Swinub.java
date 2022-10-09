package pokemons;

import moves.swinub.MudSlap;
import moves.swinub.PowderSnow;
import ru.ifmo.se.pokemon.Pokemon;

public class Swinub extends Pokemon {
    public Swinub(String s, int i) {
        super(s, i);
        this.setStats(50,50,40,30,30,50);
        this.setMove(new MudSlap(), new PowderSnow());
    }
}
