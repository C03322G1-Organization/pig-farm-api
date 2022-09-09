package vn.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PigstyRestController_getPigstyById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPigstyById_id_1() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/pigsty/getPigstyById/null")
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
