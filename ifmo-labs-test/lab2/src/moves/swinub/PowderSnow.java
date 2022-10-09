package moves.swinub;

import ru.ifmo.se.pokemon.*;

public class PowderSnow extends SpecialMove {
    public PowderSnow() {
        super(Type.ICE, 40, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(Math.random() < 0.1){
            Effect.freeze(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "used Powder Snow";
    }
}
