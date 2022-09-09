package vn.codegym.pig_farm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactRestController_getDeleteContact {

    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: delete_25
     * Description: In situation the id send value is null
     */
    @Test
    void delete_25() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/contact/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: PhucNQ
     * Date created: 11-08-2022 10:30
     * Function: delete_26
     * Description: In situation the id send value is empty
     */
    @Test
    void delete_26() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/computer/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: PhucNQ
     * Date created: 11-08-2022 10:30
     * Function: delete_27
     * Description: In situation the id send value was not founded in database
     */
    @Test
    void delete_27() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/computer/99"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: PhucNQ
     * Date created: 11-08-2022 10:30
     * Function: delete_28
     * Description: In situation the id send value was founded in database
     */
    @Test
    void delete_28() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/computer/4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
