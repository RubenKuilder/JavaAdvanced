package nhlstenden.javaminor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nhlstenden.javaminor.config.TestConfiguration;
import nhlstenden.javaminor.config.WebConfig;
import nhlstenden.javaminor.resource.model.domain.Owner;
import nhlstenden.javaminor.resource.model.domain.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(classes = TestConfiguration.class)
public class OwnerControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getOwnersTest() throws Exception {
        this.mockMvc.perform(get("/owners").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void postOwnersTest() throws Exception {
        Owner owner = new Owner();
        owner.setName("Ruben");
        owner.setAge(24);
        owner.setCity("Emmen");

        System.out.println(new ObjectMapper().writeValueAsString(owner));

        mockMvc.perform(post("/owners")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(owner)))
                .andExpect(status().isOk())
                .andReturn();
    }
}
