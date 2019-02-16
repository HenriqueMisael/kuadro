package com.henriquemisael.kuadro.controller.response;

import com.henriquemisael.kuadro.model.entity.Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModelResponse<T extends Model> {

    private T model;
    private Map<String, Set<Model>> created;

    protected ModelResponse(T model, Map<String, Set<Model>> created) {
        this.model = model;
        this.created = created;
    }

    public T getModel() {
        return model;
    }

    public Map<String, Set<Model>> getCreated() {
        return created;
    }

    public static class Builder<T extends Model> {

        private final T model;
        private final Map<String, Set<Model>> created;

        public Builder(T model) {
            this.model = model;
            this.created = new HashMap<String, Set<Model>>();
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
