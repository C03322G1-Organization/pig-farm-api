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
public class NotificationRestController_findAll {
    @Autowired
    private MockMvc mockMvc;


    /**
     * This function used to test display all record with keyword = null
     * @author DatLT
     * @Time 09/09/2022
     *
     * @throws Exception
     */
    @Test
    public void findAll_keyword_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification/list?keyword=" + null))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * This function used to test display all record with keyword = "", has pagination
     * @author DatLT
     * @Time 09/09/2022
     *
     * @throws Exception
     */
    @Test
    public void findAll_keyword_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification/list?keyword="))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(19))
                .andExpect(jsonPath("content[9].id").value(11))
                .andExpect(jsonPath("content[9].title").value("Công nghệ SPR trong thiết kế và đánh giá hiệu quả vắc xin"))
                .andExpect(jsonPath("content[9].content").value("Sự thiếu hiệu quả trong gây đáp ứng miễn dịch là rào cản lớn nhất ..."))
                .andExpect(jsonPath("content[9].submittedDate").value("2022-09-10"))
                .andExpect(jsonPath("content[9].image").value("../../assets/image/VACXIN.png"))
                .andExpect(jsonPath("content[9].isDeleted").value(false));
    }


    /**
     * This function used to test display all record with keyword = "long"
     * @author DatLT
     * @Time 09/09/2022
     *
     * @throws Exception
     */
    @Test
    public void findAll_keyword_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification/list?keyword=long"))
                .andDo(print())
                .andExpect(status().is(204));
    }


    /**
     * This function used to test display all record with keyword = "ngãi"
     * @author DatLT
     * @Time 09/09/2022
     *
     * @throws Exception
     */
    @Test
    public void findAll_keyword_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification/list?keyword=ngãi"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * This function used to test display all record with keyword = "heo", has pagination
     * @author DatLT
     * @Time 09/09/2022
     *
     * @throws Exception
     */
    @Test
    public void findAll_keyword_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/notification/list?keyword=heo"))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[4].id").value(19))
                .andExpect(jsonPath("content[4].title").value("Sử dụng chế phẩm vi sinh trong chăn nuôi heo"))
                .andExpect(jsonPath("content[4].content").value("Sử dụng chế phẩm vi sinh phối trộn vào thức ăn cho heo là ..."))
                .andExpect(jsonPath("content[4].submittedDate").value("2022-09-10"))
                .andExpect(jsonPath("content[4].image").value("../../assets/image/khkt3.jpg"))
                .andExpect(jsonPath("content[4].isDeleted").value(false));
    }
}
