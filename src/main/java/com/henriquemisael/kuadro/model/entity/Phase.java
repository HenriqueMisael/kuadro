package com.henriquemisael.kuadro.model.entity;

import com.google.common.collect.ComparisonChain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

import static com.google.common.collect.ComparisonChain.start;

@Entity
public class Phase extends AbstractModel {

    private String name;
    private String descriptionForwarding;
    private String descriptionBackwarding;
    @ManyToMany
    private Set<Phase> advanceOptions;
    @ManyToMany
    private Set<Phase> returnOptions;

    public String getName() {
        return name;
    }

    public String getDescriptionForwarding() {
        return descriptionForwarding;
    }

    public String getDescriptionBackwarding() {
        return descriptionBackwarding;
    }

    public Set<Phase> getAdvanceOptions() {
        return advanceOptions;
    }

    public Set<Phase> getReturnOptions() {
        return returnOptions;
    }

    @Override
    public int compareTo(AbstractModel o) {
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
        if (!(o instanceof Phase))
            return false;
        Phase phase = (Phase) o;
        return Objects.equals(getName(), phase.getName()) &&
                Objects.equals(getDescriptionForwarding(), phase.getDescriptionForwarding()) &&
                Objects.equals(getDescriptionBackwarding(), phase.getDescriptionBackwarding()) &&
                Objects.equals(getAdvanceOptions(), phase.getAdvanceOptions()) &&
                Objects.equals(getReturnOptions(), phase.getReturnOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getDescriptionForwarding(), getDescriptionBackwarding(), getAdvanceOptions(), getReturnOptions());
    }
}
