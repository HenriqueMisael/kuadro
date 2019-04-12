package com.henriquemisael.kuadro.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Phase extends NamedModel {

    private String descriptionForwarding;
    private String descriptionBackwarding;
    @ManyToMany
    private Set<Phase> advanceOptions;
    @ManyToMany
    private Set<Phase> returnOptions;

    public Phase() {
    }

    public Phase(String name, String descriptionForwarding, String descriptionBackwarding, Set<Phase> advanceOptions, Set<Phase> returnOptions) {
        this.name = name;
        this.descriptionForwarding = descriptionForwarding;
        this.descriptionBackwarding = descriptionBackwarding;
        this.advanceOptions = advanceOptions;
        this.returnOptions = returnOptions;
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
