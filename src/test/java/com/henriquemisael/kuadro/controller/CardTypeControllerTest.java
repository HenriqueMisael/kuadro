package com.henriquemisael.kuadro.controller;

import com.henriquemisael.kuadro.IntegrationTest;
import com.henriquemisael.kuadro.controller.response.ErrorResponse;
import com.henriquemisael.kuadro.exception.notfound.CardTypeNotFoundException;
import com.henriquemisael.kuadro.exception.notfound.PhaseNamedNotFoundException;
import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeInitialStateRequiredException;
import com.henriquemisael.kuadro.exception.preconditionfailed.CardTypeNameRequiredException;
import com.henriquemisael.kuadro.model.entity.CardType;
import com.henriquemisael.kuadro.model.entity.Phase;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.henriquemisael.kuadro.controller.CardTypeController.PATH;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CardTypeControllerTest extends IntegrationTest {

    @Test
    public void getWithoutCreating() throws Exception {
        ResultActions resultActions = get(PATH, 1L).andExpect(status().isNotFound());
        ErrorResponse response = getErrorResponse(resultActions.andReturn());

        assertErrorResponse(response, new CardTypeNotFoundException(1L));
    }

    @Test
    public void getListWithoutCreating() throws Exception {
        ResultActions resultActions = get(PATH).andExpect(status().isOk());
        List response = asList(getResponse(resultActions.andReturn(), CardType[].class));

        assertNotNull(response);
        assertEquals(0, response.size());
    }

    @Test
    public void createAndGetList() throws Exception {
        CardType cardType = getResponse(post(new CardType("Demand", testSupport.insertAndGetPhase("On budget"))).andExpect(status().isCreated()).andReturn());

        ResultActions resultActions = get().andExpect(status().isOk());
        List<CardType> response = asList(getResponse(resultActions.andReturn(), CardType[].class));

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(cardType, response.get(0));
    }

    @Test
    public void createAndGet() throws Exception {
        CardType cardType = getResponse(post(new CardType("Demand", testSupport.insertAndGetPhase("On budget"))).andExpect(status().isCreated()).andReturn());

        ResultActions resultActions = get(cardType.getId()).andExpect(status().isOk());
        CardType response = getResponse(resultActions.andReturn());

        assertNotNull(response);
        assertEquals(cardType, response);
    }

    @Test
    public void createWithoutName() throws Exception {
        ResultActions resultActions = post(new CardType(null, new Phase("On budget", null, null, null, null))).andExpect(status().isPreconditionFailed());
        ErrorResponse response = getErrorResponse(resultActions.andReturn());

        assertNameRequired(response);
    }

    @Test
    public void createWithoutInitialState() throws Exception {
        ResultActions resultActions = post(new CardType("Demand", null)).andExpect(status().isPreconditionFailed());
        ErrorResponse response = getErrorResponse(resultActions.andReturn());

        assertInitialStateRequired(response);
    }

    @Test
    public void createAndEdit() throws Exception {
        CardType cardType = getResponse(post(new CardType("Demand", testSupport.insertAndGetPhase("On budget"))).andExpect(status().isCreated()).andReturn());

        CardType response = getResponse(put(PATH, cardType.getId(), new CardType("Demand and Budget", cardType.getInitialState())).andExpect(status().isOk()).andReturn());

        assertNotNull(response);
        assertEquals(cardType, response);
    }

    @Test
    public void createAndEditForUnexistentPhase() throws Exception {
        CardType cardType = getResponse(post(new CardType("Demand", testSupport.insertAndGetPhase("On budget"))).andExpect(status().isCreated()).andReturn());

        ErrorResponse response = getErrorResponse(put(PATH, cardType.getId(), new CardType("Demand", testSupport.getPhase("Deployed"))).andExpect(status().isPreconditionFailed()).andReturn());

        assertErrorResponse(response, new PhaseNamedNotFoundException("On budget"));
    }

    @Test
    public void createAndEditWithoutName() throws Exception {
        CardType cardType = getResponse(post(new CardType("Demand", testSupport.insertAndGetPhase("On budget"))).andExpect(status().isCreated()).andReturn());

        assertNameRequired(getErrorResponse(put(PATH, cardType.getId(), new CardType(null, cardType.getInitialState())).andExpect(status().isPreconditionFailed()).andReturn()));
    }

    @Test
    public void createAndEditWithoutInitialState() throws Exception {
        CardType cardType = getResponse(post(new CardType("Demand", testSupport.insertAndGetPhase("On budget"))).andExpect(status().isCreated()).andReturn());

        assertInitialStateRequired(getErrorResponse(put(PATH, cardType.getId(), new CardType("Demand", null)).andExpect(status().isPreconditionFailed()).andReturn()));
    }

    @Test
    public void createAndDelete() throws Exception {
        CardType cardType = getResponse(post(new CardType("Demand", testSupport.insertAndGetPhase("On budget"))).andExpect(status().isCreated()).andReturn());

        delete(cardType.getId()).andExpect(status().isNoContent());
    }

    @Test
    public void deleteWithoutCreating() throws Exception {
        ErrorResponse response = getErrorResponse(delete(1L).andExpect(status().isNotFound()).andReturn());

        assertErrorResponse(response, new CardTypeNotFoundException(1L));
    }

    private void assertNameRequired(ErrorResponse response) {
        assertErrorResponse(response, new CardTypeNameRequiredException());
    }

    private void assertInitialStateRequired(ErrorResponse response) {
        assertErrorResponse(response, new CardTypeInitialStateRequiredException());
    }

    private ResultActions get() throws Exception {
        return get(PATH);
    }

    private ResultActions get(Long id) throws Exception {
        return get(PATH, id);
    }

    private ResultActions post(CardType cardType) throws Exception {
        return post(PATH, cardType);
    }

    private ResultActions delete(Long id) throws Exception {
        return delete(PATH, id);
    }

    private CardType getResponse(MvcResult mvcResult) throws UnsupportedEncodingException {
        return getResponse(mvcResult, CardType.class);
    }
}