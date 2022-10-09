package moves.purugly;

import ru.ifmo.se.pokemon.*;

public class BodySlam extends PhysicalMove {
    public BodySlam() {
        super(Type.PSYCHIC, 85, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() < 0.3){
            Effect.paralyze(pokemon);
        }
    }
    @Override
    protected String describe() {
        return "used BodySlam";
    }
}
