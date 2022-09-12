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
public class PigstyRestController_findAll {
    /**
     * Create by: PhucND
     * Date Create: 09/09/2022
     * function: Create test JUnit 5 create in contact
     * @throws Exception
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * this function use to test get list param is null
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void findAll_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("api/pigsty/list?search=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test get list param is blank
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void findAll_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("api/pigsty/list/list?search= "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test get list param not in database
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void findAll_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("api/pigsty/list?search=234"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test get list success
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void findAll_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("api/pigsty/list?search=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[2].id").value(3))
                .andExpect(jsonPath("content[2].code").value("C03"))
                .andExpect(jsonPath("content[2].employee.id").value(1))
                .andExpect(jsonPath("content[2].creationDate").value("2019-01-12"))
                .andExpect(jsonPath("content[2].buildDate").value("2019-12-12"))
                .andExpect(jsonPath("content[2].maxNumber").value(20));
    }

}
