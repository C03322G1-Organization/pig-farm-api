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
public class EmployeeRestController_findById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * @Created LongNT
     * @function return error when id employee is null
     * @throws Exception
     */

    @Test
    public void findById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/{id}", "null")).andDo(print()).andExpect(status().is4xxClientError());
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
                .andExpect(status().is2xxSuccessful()).andExpect(jsonPath("id").value(4))
                .andExpect(jsonPath("code").value("NV-003"))
                .andExpect(jsonPath("name").value("Ngọc Sơn"))
                .andExpect(jsonPath("birthDay").value("2000-10-10"))
                .andExpect(jsonPath("gender").value("Nam"))
                .andExpect(jsonPath("idCard").value("987654321"))
                .andExpect(jsonPath("image").value("sdfdfb"))
                .andExpect(jsonPath("isDeleted").value(0))
                .andExpect(jsonPath("user.id").value(4));
    }
}
