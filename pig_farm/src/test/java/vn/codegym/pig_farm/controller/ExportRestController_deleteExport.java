package vn.codegym.pig_farm.controller;

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
public class ExportRestController_deleteExport {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteExport_id_25() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                .get("/export/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteExport_id_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void deleteExport_id_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/delete/{id}", "4"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void deleteExport_id_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/delete/{id}", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
