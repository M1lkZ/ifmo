package moves.glameow;

import ru.ifmo.se.pokemon.*;

public class DreamEater extends PhysicalMove {
    boolean statusCheck = false;
    public DreamEater() {
        super(Type.PSYCHIC, 100, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(pokemon.getCondition() == Status.SLEEP){
            statusCheck = true;
        }
    }

    @Override
    protected void applyOppDamage(Pokemon pokemon, double v) {
        if (pokemon.getCondition() == Status.SLEEP){
            super.applyOppDamage(pokemon, v);
        }
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        if (statusCheck){
            pokemon.setMod(Stat.HP, (int) ((0 - pokemon.getStat(Stat.ATTACK)) / 2));
        }
    }
    @Override
    protected String describe() {
        return "used Dream Eater";
    }

}
