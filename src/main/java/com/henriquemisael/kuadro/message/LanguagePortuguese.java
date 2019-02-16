package com.henriquemisael.kuadro.message;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:/com.henriquemisael.kuadro.message/pt-BR/exception.properties", "classpath:/com.henriquemisael.kuadro.message/pt-BR/dictionary.properties" })
@ConditionalOnProperty(prefix = "kuadro.message", name = "language", havingValue = "pt-BR")
public class LanguagePortuguese extends AbstractLanguage {

    public LanguagePortuguese(Environment environment) {
        super(environment);
    }
}
