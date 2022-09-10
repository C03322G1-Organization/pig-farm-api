package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.IVaccinationDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VaccinationRestController_getListVaccination {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to check the display of null list
     * @author TamLT
     * @Time 09/09/2022
     */

    @Test
    public void getListVaccination_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/vaccination/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to check the display of list
     * @author TamLT
     * @Time 09/09/2022
     */

    @Test
    public void getListVaccination_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/vaccination/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This function is used to check the display of the list with data and pagination
     * @author TamLT
     * @Time 09/09/2022
     */
    @Test
    public void getVaccination_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/vaccination/list/"))

                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].date").value("2022-12-12"))
                .andExpect(jsonPath("content[0].amount").value(123))
                .andExpect(jsonPath("content[0].vaccinatedPerson").value("Tam Le"))
                .andExpect(jsonPath("content[0].vaccineType").value("H5N1"))
                .andExpect(jsonPath("content[0].pigstyCode").value(1));
    }

    /**
     * This function is used to check the display of the list with data and search:true
     * @author TamLT
     * @Time 09/09/2022
     */
    @Test
    public void getListVaccination_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/vaccination/list?name=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This function is used to check the display of the list with data and search:null
     * @author TamLT
     * @Time 09/09/2022
     */
    @Test
    public void getListVaccination_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/vaccination/list?name="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This function is used to check the display of the list with data and search:false
     * @author TamLT
     * @Time 09/09/2022
     */
    @Test
    public void getListVaccination_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/vaccination/list?name=zz"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * This function is used to check the delete of the list
     * Create: TamLT
     * @Time 09/09/2022
     * Delete Vaccination with id = 1
     * if id == null
     */
    @Test
    public void deleteVaccination_idNull() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/vaccination/delete/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: TamLT
     * @Time 09/09/2022
     * Delete Vaccination with id = 1
     * if id == ""
     */
    @Test
    public void deleteVaccination_idIsEmpty() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/vaccination/delete/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: TamLT
     * @Time 09/09/2022
     * Delete Vaccination with id = 1
     * if id is not exist in database
     */
    @Test
    public void deleteVaccination_idNotExist() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/vaccination/delete/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: TamLT
     * @Time 09/09/2022
     * Delete Vaccination with id = 1
     * if id is exist in database
     */
    @Test
    public void deleteVaccination_idOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/vaccination/delete/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
