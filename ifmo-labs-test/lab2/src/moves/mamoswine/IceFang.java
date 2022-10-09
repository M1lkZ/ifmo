package moves.mamoswine;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class IceFang extends PhysicalMove {
    public IceFang() {
        super(Type.ICE,65,95);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(Math.random() < 0.1){
            Effect.freeze(pokemon);
        }
        if (Math.random() < 0.1) {
            Effect.flinch(pokemon);
        }
    }
}
