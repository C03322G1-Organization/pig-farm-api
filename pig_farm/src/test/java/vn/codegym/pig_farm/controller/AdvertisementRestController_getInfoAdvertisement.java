package vn.codegym.pig_farm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdvertisementRestController_getInfoAdvertisement {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by : ChungHV
     * Date create : 9/09/2022
     * @throws Exception
     * Get Advertisement findById function null return throws error 404
     */
    @Test
    public void findById_1_null() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/advertisement/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by : ChungHV
     * Date create : 9/09/2022
     * @throws Exception
     * Get Advertisement findById function is Empty return throws error 404
     */
    @Test
    public void findById_1_isEmpty() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/advertisement/{id}", " "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by : ChungHV
     * Date create : 9/09/2022
     * @throws Exception
     * Get Advertisement findById function not exist return throws error 404
     */
    @Test
    public void findById_1_not_exist() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/advertisement/{id}", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by : ChungHV
     * Date create : 9/09/2022
     * @throws Exception
     * Get Advertisement findById function exist return throws message 200
     */
    @Test
    public void findById_1_exist() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/advertisement/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("image").value("http//firebase"))
                .andExpect(jsonPath("isDeleted").value(false))
                .andExpect(jsonPath("submittedDate").value(LocalDate.parse("2022-05-16")))
                .andExpect(jsonPath("timeExistence").value("2022-09-30"))
                .andExpect(jsonPath("title").value("Quảng cáo"))
                .andExpect(jsonPath("placement.id").value(1));
    }
}
