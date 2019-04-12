package com.henriquemisael.kuadro.model.entity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class CardType extends NamedModel {

    private Phase initialState;

    public CardType() {
    }

    public CardType(String name, Phase initialState) {
        this.name = name;
        this.initialState = initialState;
    }

    public Phase getInitialState() {
        return initialState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CardType))
            return false;
        CardType cardType = (CardType) o;
        return Objects.equals(getName(), cardType.getName()) &&
                Objects.equals(getInitialState(), cardType.getInitialState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getInitialState());
    }
}
