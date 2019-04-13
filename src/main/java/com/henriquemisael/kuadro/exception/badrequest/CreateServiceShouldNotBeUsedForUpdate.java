package com.henriquemisael.kuadro.exception.badrequest;

import static com.henriquemisael.kuadro.message.MessageKey.CREATE_SERVICE_SHOULD_NOT_BE_USED_FOR_UPDATE;

public class CreateServiceShouldNotBeUsedForUpdate extends BadRequestException {

    protected CreateServiceShouldNotBeUsedForUpdate(String uri, Long id) {
        super(CREATE_SERVICE_SHOULD_NOT_BE_USED_FOR_UPDATE, uri, uri + "/" + id);
    }
}
