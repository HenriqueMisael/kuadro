package com.henriquemisael.kuadro;

import com.google.gson.Gson;
import com.henriquemisael.kuadro.controller.response.ErrorResponse;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class IntegrationTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected Gson gson;

    protected ErrorResponse getResponseError(MvcResult mvcResult) throws UnsupportedEncodingException {
        return getResponse(mvcResult, ErrorResponse.class);
    }

    protected <T> T getResponse(MvcResult mvcResult, Type type) throws UnsupportedEncodingException {
        return gson.fromJson(mvcResult.getResponse().getContentAsString(), type);
    }

    protected ResultActions get(String uri) throws Exception {
        return perform(MockMvcRequestBuilders.get(uri));
    }

    protected ResultActions post(String uri, Serializable requestBody) throws Exception {
        return perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(gson.toJson(requestBody)));
    }

    protected ResultActions put(String uri, Serializable requestBody) throws Exception {
        return perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(gson.toJson(requestBody)));
    }

    protected ResultActions delete(String uri) throws Exception {
        return perform(MockMvcRequestBuilders.delete(uri));
    }

    @NotNull
    private ResultActions perform(MockHttpServletRequestBuilder requestBuilder) throws Exception {
        return mockMvc.perform(requestBuilder);
    }
}
