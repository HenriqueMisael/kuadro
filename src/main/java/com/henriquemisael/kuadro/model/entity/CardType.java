package com.henriquemisael.kuadro.model.entity;

import com.google.common.collect.ComparisonChain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static com.google.common.collect.ComparisonChain.start;

@Entity
public class CardType extends AbstractModel {

    private String name;
    private Phase initialState;

    public CardType(String name, Phase initialState) {
        this.name = name;
        this.initialState = initialState;
    }

    public String getName() {
        return name;
    }

    public Phase getInitialState() {
        return initialState;
    }

    @Override
    public int compareTo(@NotNull AbstractModel o) {
        ComparisonChain comparisonChain = start();

        if (!getClass().equals(o.getClass())) {
            comparisonChain.compare(this.getClass().toString(), o.getClass().toString());
        } else {
            CardType that = (CardType) o;
            comparisonChain.compare(name, that.getName());
        }

        return comparisonChain.result();
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
