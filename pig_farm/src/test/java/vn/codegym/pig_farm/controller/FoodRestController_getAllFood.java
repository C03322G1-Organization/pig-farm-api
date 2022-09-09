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
public class FoodRestController_getAllFood {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by HoanTV
     * Date: 16:30 pm  09-09-2022
     * function: check with case id equals null
     * HoanTV-list-food
     *
     * @throws Exception
     */

    @Test
    public void getListStudent_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/food/list?search=null"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListStudent_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/food/list?search= "))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListStudent_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/food/list?search=234"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListStudent_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/food/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudent_4_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/food/list?search=1"))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[2].id").value(3))
                .andExpect(jsonPath("content[2].unit").value(1))
                .andExpect(jsonPath("content[2].amount").value(1))
                .andExpect(jsonPath("content[2].storage").value(1))
                .andExpect(jsonPath("content[2].pigsty").value(1));
    }

}