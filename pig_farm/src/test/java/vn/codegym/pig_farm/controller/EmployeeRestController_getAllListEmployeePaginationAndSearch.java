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
public class EmployeeRestController_getAllListEmployeePaginationAndSearch {

    @Autowired
    private MockMvc mockMvc;


    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 0
     * Return an empty list at page 1
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_1_nameNull() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?name=null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 5
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_2_nameEmpty() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?name="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 0
     * Return an empty list at page 1
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_3_nameNotExist() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?name=aaaaaa"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 1
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     * Page 0 has 1 element
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_4_nameOk() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?name=buoi"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].nameEmployee").value("Nguyen Thi Buoi"))
                .andExpect(jsonPath("content[0].code").value("NV-124"))
                .andExpect(jsonPath("content[0].birthDay").value("2019-09-09"));
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 0
     * Return an empty list at page 1
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_5_idCardNull() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?idCard=null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 5
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_6_idCardEmpty() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?idCard="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 0
     * Return an empty list at page 1
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_7_idCardNotExist() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?idCard=aaaaaa"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 1
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     * Page 0 has 1 element
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_8_idCardOk() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?idCard=247456789"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 0
     * Return an empty list at page 1
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_9_nameNull_idCardNull() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?name=null&idCard=null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 5
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_10_nameEmpty_idCardEmpty() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?name=&idCard="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 0
     * Return an empty list at page 1
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_11_nameNotExist_idCardNotExist() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?name=aaaaaa&idCard=aaaaaaa"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: HungNQ
     * Date create: 09/09/2022
     * Get employee list with size = 1
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     * Page 0 has 1 element
     */
    @Test
    public void getAllListEmployeePaginationAndSearch_12_nameOk_idCardOk() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/searchList?name=Buoi&idCard=247456789"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
