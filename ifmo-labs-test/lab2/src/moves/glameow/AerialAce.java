package moves.glameow;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class AerialAce extends PhysicalMove {
    public AerialAce() {
        super(Type.PSYCHIC, 60, 0);
    }
    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected String describe() {
        return "used AerialAce";
    }
}
