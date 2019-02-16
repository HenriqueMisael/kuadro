package com.henriquemisael.kuadro.controller.response;

import com.henriquemisael.kuadro.model.entity.AbstractModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModelResponse<T extends AbstractModel> {

    private T model;
    private Map<String, Set<AbstractModel>> created;

    protected ModelResponse(T model, Map<String, Set<AbstractModel>> created) {
        this.model = model;
        this.created = created;
    }

    public T getModel() {
        return model;
    }

    public Map<String, Set<AbstractModel>> getCreated() {
        return created;
    }

    public static class Builder<T extends AbstractModel> {

        private final T model;
        private final Map<String, Set<AbstractModel>> created;

        public Builder(T model) {
            this.model = model;
            this.created = new HashMap<String, Set<AbstractModel>>();
        }

        public Builder<T> create(T model) {
            String className = model.getClass().toString();

            if (!created.containsKey(className)) {
                created.put(className, new HashSet<>());
            }

            created.get(className).add(model);

            return this;
        }

        public ModelResponse<T> build() {
            return new ModelResponse<>(model, created);
        }
    }
}
