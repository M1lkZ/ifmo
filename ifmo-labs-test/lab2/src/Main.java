import pokemons.Piloswine;
import ru.ifmo.se.pokemon.Battle;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        pokemons.Relicanth relicanth = new pokemons.Relicanth("Dalbaeb", 35);
        pokemons.Glameow glameow = new pokemons.Glameow("Dowen", 17);
        pokemons.Purugly purugly = new pokemons.Purugly("Suka", 45);
        pokemons.Swinub swinub = new pokemons.Swinub("Chel", 5);
        pokemons.Piloswine piloswine = new Piloswine("Mikrochel", 37);
        pokemons.Mamoswine mamoswine = new pokemons.Mamoswine("Matb", 37);
        b.addAlly(relicanth);
        b.addAlly(glameow);
        b.addAlly(purugly);
        b.addFoe(swinub);
        b.addFoe(piloswine);
        b.addFoe(mamoswine);
        b.go();
    }
}