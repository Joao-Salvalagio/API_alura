package br.com.tuitter.tuitter_api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PiuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should piu") //should = deve ou seja deve fazer piu
    void t1() throws Exception {
        mockMvc.perform(get("/piu"))
                .andExpect(status().isOk())
                .andExpect(content().string("🐦"));
    }
}