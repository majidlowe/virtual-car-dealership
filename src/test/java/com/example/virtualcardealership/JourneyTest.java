package com.example.virtualcardealership;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.RequestEntity.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JourneyTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void journey() throws Exception {

        // get all the cars from the inventory
        MockHttpServletRequestBuilder getAllCars = get("/cars")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(getAllCars)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].model", is("Cruze")));

        // delete a car from the inventory (purchase a car)
        SalesRequest salesRequest = new SalesRequest(1, 1);

        String srAsString = new ObjectMapper().writeValueAsString(salesRequest);

        MockHttpServletRequestBuilder performCarPurchase = MockMvcRequestBuilders.patch("/cars/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(srAsString);

        this.mvc.perform(performCarPurchase).andExpect(status().isOk()).andExpect(content().string("true"));

        // verify the car has been removed from the inventory
        this.mvc.perform(getAllCars)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", empty()));

    }
}
