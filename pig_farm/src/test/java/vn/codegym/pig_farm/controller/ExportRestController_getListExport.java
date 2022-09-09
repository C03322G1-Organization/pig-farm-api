package vn.codegym.pig_farm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExportRestController_getListExport {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListExport_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListExport_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[1].amount").value(30))
                .andExpect(jsonPath("content[1].codeExport").value("MC02"))
                .andExpect(jsonPath("content[1].company").value("Công ty B"))
                .andExpect(jsonPath("content[1].isDeleted").value(false))
                .andExpect(jsonPath("content[1].kilogram").value(150))
                .andExpect(jsonPath("content[1].price").value(80000))
                .andExpect(jsonPath("content[1].startDate").value("2021-09-09"));
    }

    @Test
    public void getSearchExport_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/search?codeSearch=/"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[1].amount").value("null"))
                .andExpect(jsonPath("content[1].codeExport").value("null"))
                .andExpect(jsonPath("content[1].company").value("null"))
                .andExpect(jsonPath("content[1].isDeleted").value("null"))
                .andExpect(jsonPath("content[1].kilogram").value("null"))
                .andExpect(jsonPath("content[1].price").value("null"))
                .andExpect(jsonPath("content[1].startDate").value("null"));
    }

    @Test
    public void getSearchExport_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/search/"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("content.codeExport").value(" "))
                .andExpect(jsonPath("content.company").value(" "));
    }
}
