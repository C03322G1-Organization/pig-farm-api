package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationController_findAllNotification {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to check the display of null list
     * @author HaiTV
     * @Time 09/09/2022
     */

    @Test
    public void getListNotification_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/Notification/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to check the display of list
     * @author HaiTV
     * @Time 09/09/2022
     */

    @Test
    public void getListNotification_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/notification/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This function is used to check the display of the list with data and pagination
     * @author HaiTV
     * @Time 09/09/2022
     */
    @Test
    public void getListNotification_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/notification/list/"))

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
     * @author HaiTV
     * @Time 09/09/2022
     */
    @Test
    public void getListNotification_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/Notification/list?content=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This function is used to check the display of the list with data and search:null
     * @author HaiTV
     * @Time 09/09/2022
     */
    @Test
    public void getListNotification_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/vaccination/list?content="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This function is used to check the display of the list with data and search:false
     * @author HaiTV
     * @Time 09/09/2022
     */
    @Test
    public void getListNotification_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/notification/list?content=zz"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * This function is used to check the delete of the list
     * Create: HaiTV
     * @Time 09/09/2022
     * Delete Advertisement with id = 1
     * if id == null
     */
    @Test
    public void deleteNotification_idNull() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/notification/delete/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: HaiTV
     * @Time 09/09/2022
     * Delete Advertisement with id = 1
     * if id == ""
     */
    @Test
    public void deleteNotification_idIsEmpty() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/notification/delete/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: HaiTV
     * @Time 09/09/2022
     * Delete Advertisement with id = 1
     * if id is not exist in database
     */
    @Test
    public void deleteNotification_idNotExist() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/notification/delete/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: HaiTV
     * @Time 09/09/2022
     * Delete Advertisement with id = 1
     * if id is exist in database
     */
    @Test
    public void deleteNotification_idOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/notification/delete/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
