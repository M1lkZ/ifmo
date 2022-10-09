package moves.replicanth;

import ru.ifmo.se.pokemon.*;

public class Waterfall extends PhysicalMove {
    public Waterfall() {
        super(Type.PSYCHIC, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(Math.random() < 0.20) {
            Effect.flinch(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "used Waterfall";
    }
}
