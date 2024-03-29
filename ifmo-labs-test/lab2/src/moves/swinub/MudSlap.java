package moves.swinub;

import ru.ifmo.se.pokemon.*;

public class MudSlap extends SpecialMove {
    public MudSlap() {
        super(Type.GROUND,20,100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ACCURACY, -1);
    }

    @Override
    protected String describe() {
        return "used Mud-Slap";
    }
}
