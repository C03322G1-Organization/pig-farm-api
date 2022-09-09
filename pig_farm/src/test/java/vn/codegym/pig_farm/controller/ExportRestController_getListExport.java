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
public class ExportRestController_getListExport {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: DongLHP
     * Date create: 09/09/2022
     * Function: Trường hợp list trả về size = 0
     * @throws Exception
     */
    @Test
    public void getListExport_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: DongLHP
     * Date create: 09/09/2022
     * Function: Trường hợp list trả về thành công
     * @throws Exception
     */
    @Test
    public void getListExport_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[1].amount").value(30))
                .andExpect(jsonPath("content[1].codeExport").value("MC02"))
                .andExpect(jsonPath("content[1].company").value("Công ty B"))
                .andExpect(jsonPath("content[1].isDeleted").value(false))
                .andExpect(jsonPath("content[1].kilogram").value(150))
                .andExpect(jsonPath("content[1].price").value(80000))
                .andExpect(jsonPath("content[1].startDate").value("2021-09-09"));
    }

    /**
     * Create by: DongLHP
     * Date create: 09/09/2022
     * Function: Trường hợp tìm kiếm bằng null
     * @throws Exception
     */
    @Test
    public void getSearchExport_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/search/codeSearch=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: DongLHP
     * Date create: 09/09/2022
     * Function: Trường hợp list trả về rỗng
     * @throws Exception
     */
    @Test
    public void getSearchExport_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/search/codeSearch="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: DongLHP
     * Date create: 09/09/2022
     * Function: Trường hợp list trả về dữ liệu không tồn tại trong DB
     * @throws Exception
     */
    @Test
    public void getSearchExport_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/search/codeSearch=ưqwqwq"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: DongLHP
     * Date create: 09/09/2022
     * Function: Trường hợp tìm kiếm trả về size = 0
     * @throws Exception
     */
    @Test
    public void getSearchExport_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/page?codeExport=MC01"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: DongLHP
     * Date create: 09/09/2022
     * Function: Trường hợp tìm kiếm thành công
     * @throws Exception
     */
    @Test
    public void getListExport_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/export/page?codeExport=MC01"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].amount").value(22))
                .andExpect(jsonPath("content[0].codeExport").value("MC01"))
                .andExpect(jsonPath("content[0].company").value("Công ty A"))
                .andExpect(jsonPath("content[0].isDeleted").value(false))
                .andExpect(jsonPath("content[0].kilogram").value(100))
                .andExpect(jsonPath("content[0].price").value(80000))
                .andExpect(jsonPath("content[0].startDate").value("2021-09-09"));
    }
}
