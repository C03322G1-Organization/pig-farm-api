package vn.codegym.pig_farm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TreatmentRestController_deleteTreatment {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Delete treatment list with id wrong format
     * Return failure
     */
    @Test
    public void deleteTreatment_id_21() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/api/treatment/v1/{id}","càgdausjk"))
                .andDo(print())
                .andExpect(status().is(404));
    }

    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Delete treatment list with id = null
     * Return failure
     */
    @Test
    public void deleteTreatment_id_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/api/treatment/v1/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is(405));
    }

    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Delete treatment list with id = ""
     * Return failure
     */
    @Test
    public void deleteTreatment_id_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/api/treatment/v1/{id}",""))
                .andDo(print())
                .andExpect(status().is(405));
    }

    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Delete treatment list with id does not exist
     * Return failure
     */
    @Test
    public void deleteTreatment_id_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/api/treatment/v1/{id}",123))
                .andDo(print())
                .andExpect(status().is(404));
    }

    /**
     * Create: ThuanT
     * Date create: 09/09/2022
     * Delete treatment list with id exist
     * Return successful
     */
    @Test
    public void deleteTreatment_id_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .put("/api/treatment/v1/{id}",1))
                .andDo(print())
                .andExpect(status().is(200));
    }

}
