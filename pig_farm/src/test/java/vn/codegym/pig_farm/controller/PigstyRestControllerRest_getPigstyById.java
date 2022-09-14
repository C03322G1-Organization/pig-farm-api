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
public class PigstyRestControllerRest_getPigstyById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check get a Pigsty with value null
     * @throws Exception
     */
    @Test
    public void getPigstyById_id_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/pigsty/getPigstyById/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check get a Pigsty with value empty
     * @throws Exception
     */
    @Test
    public void getPigstyById_id_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/pigsty/getPigstyById/''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check get a Pigsty with value is not in database
     * @throws Exception
     */
    @Test
    public void getPigstyById_id_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/pigsty/getPigstyById/7"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check get a Pigsty with value in database
     * @throws Exception
     */
    @Test
    public void getPigstyById_id_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/pigsty/getPigstyById/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("buildDate").value("2020-02-02"))
                .andExpect(jsonPath("creationDate").value("2045-02-03"))
                .andExpect(jsonPath("typePigs").value(1))
                .andExpect(jsonPath("maxNumber").value(20))
                .andExpect(jsonPath("employee.id").value(1));
    }
}
