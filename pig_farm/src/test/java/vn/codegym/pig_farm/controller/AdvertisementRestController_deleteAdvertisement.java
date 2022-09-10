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
public class AdvertisementRestController_deleteAdvertisement {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Delete Advertisement with id = 1
     * if id == null
     */
    @Test
    public void deleteAdvertisement_idNull() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/advertisement/delete/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Delete Advertisement with id = 1
     * if id == ""
     */
    @Test
    public void deleteAdvertisement_idIsEmpty() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/advertisement/delete/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Delete Advertisement with id = 1
     * if id is not exist in database
     */
    @Test
    public void deleteAdvertisement_idNotExist() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/advertisement/delete/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Delete Advertisement with id = 1
     * if id is exist in database
     */
    @Test
    public void deleteAdvertisement_idOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/advertisement/delete/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

