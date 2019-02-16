package com.henriquemisael.kuadro.controller;

import com.google.gson.reflect.TypeToken;
import com.henriquemisael.kuadro.IntegrationTest;
import com.henriquemisael.kuadro.model.entity.CardType;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import java.lang.reflect.Type;
import java.util.List;

import static com.henriquemisael.kuadro.controller.CardTypeController.PATH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CardTypeControllerTest extends IntegrationTest {

    @Test
    public void getWithoutCreating() throws Exception {
        ResultActions resultActions = get(PATH).andExpect(status().isOk());
        List response = getResponse(resultActions.andReturn(), getTypeList(CardType.class));

        assertNotNull(response);
        assertEquals(0, response.size());
    }

    private <T> Type getTypeList(Class<T> klazz) {
        return new TypeToken<List<T>>() {
        }.getType();
    }
}