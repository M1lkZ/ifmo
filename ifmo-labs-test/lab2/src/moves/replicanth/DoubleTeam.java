package moves.replicanth;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam  extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL,0,0);
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.EVASION, 1);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected String describe() {
        return "used DoubleTeam";
    }
}
