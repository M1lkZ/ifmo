package persons;

import java.util.Objects;

public class Neznaika extends Person {
    protected String name = "Neznaika";

    public Neznaika() {
    }

    @Override
    public String returnName() {
        return this.name + "\n";
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Neznaika neznaika)) return false;
        return name.equals(neznaika.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
