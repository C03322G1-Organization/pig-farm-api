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
public class ContactRestController_getListContact {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_name_1
     * Description: In situation with input [name]  send the value is null
     */
    @Test
    void getListContact_name_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?nameSearch=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_name_8
     * Description: In situation with input [name] send the value is empty
     */
    @Test
    void getListContact_name_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?nameSearch"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("Nguyễn Văn A"))
                .andExpect(jsonPath("content[0].email").value("nguyenvana@gamil.com"))
                .andExpect(jsonPath("content[0].phone").value("0988888888"))
                .andExpect(jsonPath("content[0].address").value("Quảng Trị"))
                .andExpect(jsonPath("content[0].content").value("Cần mua 1 con lợn"))
                .andExpect(jsonPath("content[0].date").value("2022-10-08"))
                .andExpect(jsonPath("content[0].isDeleted").value(false));
    }

    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_name_9
     * Description: In situation with input [name] send the value was not founded in the DB
     */
    @Test
    void getListComputer_name_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?nameSearch=Thai"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_name_10
     * Description: In situation with input [name] send the value was not founded in the DB
     */
    @Test
    void getListComputer_name_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?nameSearch=Tri"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_name_11
     * Description: In situation with input [name] send the value was founded in the DB
     */
    @Test
    void getListComputer_name_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?nameSearch=Bay"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("Lê Văn Bảy"))
                .andExpect(jsonPath("content[0].email").value("levanbay@gamil.com"))
                .andExpect(jsonPath("content[0].phone").value("0988888889"))
                .andExpect(jsonPath("content[0].address").value("Huế"))
                .andExpect(jsonPath("content[0].content").value("Lợn giống là gì vậy ạ?"))
                .andExpect(jsonPath("content[0].date").value("2022-09-09"))
                .andExpect(jsonPath("content[0].isDeleted").value(false));
    }

    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_content_7
     * Description: In situation with input [content]  send the value is null
     */
    @Test
    void getListContact_content_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?contentSearch=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_content_8
     * Description: In situation with input [name] send the value is empty
     */
    @Test
    void getListContact_content_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?contentSearch"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("Nguyễn Văn A"))
                .andExpect(jsonPath("content[0].email").value("nguyenvana@gamil.com"))
                .andExpect(jsonPath("content[0].phone").value("0988888888"))
                .andExpect(jsonPath("content[0].address").value("Quảng Trị"))
                .andExpect(jsonPath("content[0].content").value("Cần mua 1 con lợn"))
                .andExpect(jsonPath("content[0].date").value("2022-10-08"))
                .andExpect(jsonPath("content[0].isDeleted").value(false));
    }
    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_content_9
     * Description: In situation with input [name] send the value was not founded in the DB
     */
    @Test
    void getListComputer_content_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?contentSearch=Alo"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_content_10
     * Description: In situation with input [name] send the value was not founded in the DB
     */
    @Test
    void getListComputer_content_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?contentSearch=Tri"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Creator: TriPT
     * Date created: 09-09-2022
     * Function: getListContact_content_11
     * Description: In situation with input [name] send the value was founded in the DB
     */
    @Test
    void getListComputer_content_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/contact/page?contentSearch=lon giong"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].name").value("Lê Văn Bảy"))
                .andExpect(jsonPath("content[0].email").value("levanbay@gamil.com"))
                .andExpect(jsonPath("content[0].phone").value("0988888889"))
                .andExpect(jsonPath("content[0].address").value("Huế"))
                .andExpect(jsonPath("content[0].content").value("Lợn giống là gì vậy ạ?"))
                .andExpect(jsonPath("content[0].date").value("2022-09-09"))
                .andExpect(jsonPath("content[0].isDeleted").value(false));
    }
}
