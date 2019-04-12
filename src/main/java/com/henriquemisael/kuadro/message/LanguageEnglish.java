package com.henriquemisael.kuadro.message;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:/com.henriquemisael.kuadro.message/en-US/exception.properties", "classpath:/com.henriquemisael.kuadro.message/en-US/dictionary.properties" })
@ConditionalOnProperty(prefix = "kuadro.message", name = "language", havingValue = "en-US", matchIfMissing = true)
public class LanguageEnglish extends AbstractLanguage {

    public LanguageEnglish(Environment environment) {
        super(environment);
    }
}
