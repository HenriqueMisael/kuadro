package com.henriquemisael.kuadro.model.entity;

import com.google.common.collect.ComparisonChain;

import javax.validation.constraints.NotNull;

import static com.google.common.collect.ComparisonChain.start;

public class NamedModel extends AbstractModel {

    protected String name;

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@NotNull AbstractModel o) {
        ComparisonChain comparisonChain = start();

        if (!getClass().equals(o.getClass())) {
            comparisonChain = comparisonChain.compare(this.getClass().toString(), o.getClass().toString());
        } else {
            CardType that = (CardType) o;
            comparisonChain = comparisonChain.compare(getName(), that.getName());
        }

        return comparisonChain.result();
    }
}
