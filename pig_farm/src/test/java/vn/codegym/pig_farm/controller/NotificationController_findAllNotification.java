package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
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
     * This function is used to check the display of the list with data and pagination
     *
     * @author HaiTV
     * @Time 09/09/2022
     */
    @Test
    public void getListNotification_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect((ResultMatcher) jsonPath("totalPages").value(1))
                .andExpect((ResultMatcher) jsonPath("totalElements").value(1))
                .andExpect((ResultMatcher) jsonPath("content[0].id").value(1))
                .andExpect((ResultMatcher) jsonPath("content[0].title").value("Mong 8/3"))
                .andExpect((ResultMatcher) jsonPath("content[0].content").value("Chuc mung ngay phu nu"))
                .andExpect((ResultMatcher) jsonPath("content[0].image").value("https://cdn.pixabay.com/photo/2013/07/18/20/26/sea-164989_960_720.jpg"))
                .andExpect((ResultMatcher) jsonPath("content[0].submittedDate").value("2022-09-05"));
    }

    /**
     * this function use to check the display of list
     *
     * @author HaiTV
     * @Time 09/09/2022
     */

    @Test
    public void getListNotification_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * this function use to check the display of null list
     *
     * @author HaiTV
     * @Time 09/09/2022
     */

    @Test
    public void getListNotification_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the display of the list with data and search:false
     *
     * @author HaiTV
     * @Time 09/09/2022
     */

    @Test
    public void getListNotification_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification/content?content=zz"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This function is used to check the display of the list with data and search:null
     *
     * @author HaiTV
     * @Time 09/09/2022
     */
    @Test
    public void getListNotification_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification/content?content="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * This function is used to check the display of the list with data and search:true
     *
     * @author HaiTV
     * @Time 09/09/2022
     */
    @Test
    public void getListNotification_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification/content?content=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * This function is used to check the delete of the list
     * Create: HaiTV
     *
     * @Time 09/09/2022
     * Delete Advertisement with id = 1
     * if id == null
     */
    @Test
    public void deleteNotification_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/notification/delete/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: HaiTV
     *
     * @Time 09/09/2022
     * Delete Advertisement with id = 1
     * if id == ""
     */
    @Test
    public void deleteNotification_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/notification/delete/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: HaiTV
     *
     * @Time 09/09/2022
     * Delete Advertisement with id = 1
     * if id is not exist in database
     */
    @Test
    public void deleteNotification_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/notification/delete/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the delete of the list
     * Create: HaiTV
     *
     * @Time 09/09/2022
     * Delete Advertisement with id = 1
     * if id is exist in database
     */
    @Test
    public void deleteNotification_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/notification/delete/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
