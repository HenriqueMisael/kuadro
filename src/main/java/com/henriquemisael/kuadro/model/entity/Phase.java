package com.henriquemisael.kuadro.model.entity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Phase extends NamedModel {

    public Phase() {
    }

    public Phase(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Phase))
            return false;
        Phase phase = (Phase) o;
        return Objects.equals(getName(), phase.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }
}
