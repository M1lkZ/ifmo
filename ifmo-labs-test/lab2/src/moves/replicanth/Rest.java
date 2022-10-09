package moves.replicanth;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC,0,0);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect sleep = (new Effect()).condition(Status.SLEEP).attack(0.0).turns(3);
        pokemon.setCondition(sleep);
        pokemon.setMod(Stat.HP, (int) (pokemon.getHP() - pokemon.getStat(Stat.HP)));
    }

    @Override
    protected String describe() {
        return "User sleeps for 2 turns, but user is fully healed. ";
    }
}
