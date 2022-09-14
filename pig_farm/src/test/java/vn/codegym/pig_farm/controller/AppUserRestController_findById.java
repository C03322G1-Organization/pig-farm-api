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
public class AppUserRestController_findById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * @Created LongNT
     * @function return error when id user is null
     * @throws Exception
     */

    @Test
    public void findById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/{id}", "null")).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when id user is empty
     * @throws Exception
     */

    @Test
    public void findById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/{id}", "")).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return employee when find id success
     * @throws Exception
     */

    @Test
    public void findById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/{id}", "4"))
                .andDo(print())
//        '4', '2022-09-08', 'admin@gmail.com', '0', '123', ''
                .andExpect(status().is2xxSuccessful()).andExpect(jsonPath("id").value(4))
                .andExpect(jsonPath("username").value("Admin"))
                .andExpect(jsonPath("password").value("123"))
                .andExpect(jsonPath("email").value("admin@gmail.com"))
                .andExpect(jsonPath("creationDate").value("2022-09-08"));

    }
}
