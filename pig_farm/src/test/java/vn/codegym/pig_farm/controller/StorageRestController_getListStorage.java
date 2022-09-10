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
public class StorageRestController_getListStorage {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: Case Returns a list with size = 0
     */
    @Test
    public void getListStorage_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/storage/page/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: Case Returns a list with size > 0
     */
    @Test
    public void getListStorage_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/storage/page/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[3].foodType").value("Heo nái"))
                .andExpect(jsonPath("content[3].amount").value("15"))
                .andExpect(jsonPath("content[3].unit").value("tấn"))
                .andExpect(jsonPath("content[3].date").value("2022-02-02"));
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field search more specific is empty
     */
    @Test
    public void getListStorage_8() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/storage/page?keyWord= "))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: Test search ,does not exist in DB
     */
    @Test
    public void getListStorage_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/storage/page?keyWord=aaa"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: Test search ,Case Returns a list with size = 0
     */
    @Test
    public void getListStorage_10() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/storage/page?keyWord=Heo nái"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: Test search ,Case Returns a list with size > 0
     */
    @Test
    public void getListStorage_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/storage/page?keyWord=Heo nái"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[1].foodType").value("Heo nái"))
                .andExpect(jsonPath("content[1].amount").value("75"))
                .andExpect(jsonPath("content[1].unit").value("kg"))
                .andExpect(jsonPath("content[1].date").value("2022-07-07"));
    }
}
