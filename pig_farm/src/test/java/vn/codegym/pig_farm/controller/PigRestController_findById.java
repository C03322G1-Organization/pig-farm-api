package vn.codegym.pig_farm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PigRestController_findById {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Create by: DatVT
     * Date Create: 09/09/2022
     * funtion: Create test JUnit 5 findById in pig
     * @throws Exception
     */
    @Test
    public void findById_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/pig/list/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findById_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/pig/list/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(2))
                .andExpect(jsonPath("code").value("ML001"))
                .andExpect(jsonPath("dateIn").value("2022-01-01"))
                .andExpect(jsonPath("dateOut").value("2022-02-02"))
                .andExpect(jsonPath("status").value("1"))
                .andExpect(jsonPath("weight").value("20"))
                .andExpect(jsonPath("pigsy.id").value(1))
                .andExpect(jsonPath("isDelete").value(false));
    }
}
