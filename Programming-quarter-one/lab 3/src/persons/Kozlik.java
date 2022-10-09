package persons;

import java.util.Objects;

public class Kozlik extends Person{
    protected String name = "Kozlik";
    public Kozlik() {
    }
    @Override
    public String returnName() {
        return this.name + "\n";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kozlik kozlik)) return false;
        return name.equals(kozlik.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Kozlik{" +
                "name='" + name + '\'' +
                '}';
    }

}
