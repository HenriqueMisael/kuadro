package com.henriquemisael.kuadro.controller;

import com.henriquemisael.kuadro.IntegrationTest;
import com.henriquemisael.kuadro.controller.response.ErrorResponse;
import com.henriquemisael.kuadro.exception.notfound.PhaseNotFoundException;
import com.henriquemisael.kuadro.exception.preconditionfailed.PhaseNameRequiredException;
import com.henriquemisael.kuadro.model.entity.Phase;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.henriquemisael.kuadro.controller.PhaseController.PATH;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PhaseControllerTest extends IntegrationTest {

    @Test
    public void getWithoutCreating() throws Exception {
        ResultActions resultActions = get(PATH, 1L).andExpect(status().isNotFound());
        ErrorResponse response = getErrorResponse(resultActions.andReturn());

        assertErrorResponse(response, new PhaseNotFoundException(1L));
    }

    @Test
    public void getListWithoutCreating() throws Exception {
        ResultActions resultActions = get(PATH).andExpect(status().isOk());
        List response = asList(getResponse(resultActions.andReturn(), Phase[].class));

        assertNotNull(response);
        assertEquals(0, response.size());
    }

    @Test
    public void createAndGetList() throws Exception {
        Phase phase = getResponse(post(testSupport.getPhase("On budget")).andExpect(status().isCreated()).andReturn());

        ResultActions resultActions = get().andExpect(status().isOk());
        List<Phase> response = asList(getResponse(resultActions.andReturn(), Phase[].class));

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(phase, response.get(0));
    }

    @Test
    public void createAndGet() throws Exception {
        Phase phase = getResponse(post(testSupport.getPhase("On budget")).andExpect(status().isCreated()).andReturn());

        ResultActions resultActions = get(phase.getId()).andExpect(status().isOk());
        Phase response = getResponse(resultActions.andReturn());

        assertNotNull(response);
        assertEquals(phase, response);
    }

    @Test
    public void createWithoutName() throws Exception {
        ResultActions resultActions = post(new Phase()).andExpect(status().isPreconditionFailed());
        ErrorResponse response = getErrorResponse(resultActions.andReturn());

        assertNameRequired(response);
    }

    @Test
    public void createAndEdit() throws Exception {
        Phase phase = getResponse(post(testSupport.getPhase("On budget")).andExpect(status().isCreated()).andReturn());

        Phase response = getResponse(put(PATH, phase.getId(), testSupport.getPhase("Demand and Budget")).andExpect(status().isOk()).andReturn());

        assertNotNull(response);
        assertEquals("Demand and Budget", response.getName());
    }

    @Test
    public void createAndEditWithoutName() throws Exception {
        Phase phase = getResponse(post(testSupport.getPhase("On budget")).andExpect(status().isCreated()).andReturn());

        assertNameRequired(getErrorResponse(put(PATH, phase.getId(), new Phase()).andExpect(status().isPreconditionFailed()).andReturn()));
    }

    @Test
    public void createAndDelete() throws Exception {
        Phase phase = getResponse(post(testSupport.getPhase("On budget")).andExpect(status().isCreated()).andReturn());

        delete(phase.getId()).andExpect(status().isNoContent());
    }

    @Test
    public void deleteWithoutCreating() throws Exception {
        ErrorResponse response = getErrorResponse(delete(1L).andExpect(status().isNotFound()).andReturn());

        assertErrorResponse(response, new PhaseNotFoundException(1L));
    }

    private void assertNameRequired(ErrorResponse response) {
        assertErrorResponse(response, new PhaseNameRequiredException());
    }

    private ResultActions get() throws Exception {
        return get(PATH);
    }

    private ResultActions get(Long id) throws Exception {
        return get(PATH, id);
    }

    private ResultActions post(Phase phase) throws Exception {
        return post(PATH, phase);
    }

    private ResultActions delete(Long id) throws Exception {
        return delete(PATH, id);
    }

    private Phase getResponse(MvcResult mvcResult) throws UnsupportedEncodingException {
        return getResponse(mvcResult, Phase.class);
    }
}