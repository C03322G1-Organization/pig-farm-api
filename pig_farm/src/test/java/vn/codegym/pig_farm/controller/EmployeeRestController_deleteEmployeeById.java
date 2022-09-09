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
public class EmployeeRestController_deleteEmployeeById {

    @Autowired
    private MockMvc mockMvc;


    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Return error method not allowed
     */
    @Test
    public void deleteEmployeeById_1_idNull() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/employee/delete/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Return error 404 not found
     */
    @Test
    public void deleteEmployeeById_2_idEmpty() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/employee/delete/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Return error 404 not found
     */
    @Test
    public void deleteEmployeeById_3_idNotExist() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/employee/delete/9"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Return update column is_deleted = 1 in database
     */
    @Test
    public void deleteEmployeeById_4_idOk() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/employee/delete/4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
