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
public class TreatmentRestController_getAllTreatment {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Get Treatment list with key search = null
     * Return full list at page 1(Here, when null returns full list)
     */
    @Test
    public void getInfoTreatment_keySearch_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/treatment/v1/?keySearch=null"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Get Treatment list with key search = ""
     * Return full list at page 1(Here, when null returns full list)
     */
    @Test
    public void getInfoTreatment_keySearch_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/treatment/v1/?keySearch="))
                .andDo(print())
                .andExpect(status().is(200));
    }

    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Get Treatment list with key search does not exist
     * Returns no data message
     */
    @Test
    public void getInfoTreatment_keySearch_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/treatment/v1/?keySearch=dghjklasfsd"))
                .andDo(print())
                .andExpect(status().is(204));
    }
    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Get Treatment list
     * Returns no data message
     */
    @Test
    public void getInfoTreatment_keySearch_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/treatment/v1/?keySearch="))
                .andDo(print())

                .andExpect(status().is(204));
    }
    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Get Treatment list with keySearch is exist
     * Returns a list containing all records in the table
     */
    @Test
    public void getInfoTreatment_keySearch_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/treatment/v1/?keySearch=pigsty-001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].diseases").value("dfv"))
                .andExpect(jsonPath("content[0].medicine").value("H5n1"))
                .andExpect(jsonPath("content[0].amount").value(1))
                .andExpect(jsonPath("content[0].doctor").value("thuan"))
                .andExpect(jsonPath("content[0].pigCode").value("pig-001"))
                .andExpect(jsonPath("content[0].pigstyCode").value("pigsty-001"))
                .andExpect(jsonPath("content[0].date").value("2022-09-09"));
    }

}
