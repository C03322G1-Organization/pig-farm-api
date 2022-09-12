package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.NotificationDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationController_create {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to test the validation of field content more specific is null
     *
     * @author HuyenTN
     * @Time 09/09/2022
     */
    @Test
    public void create_content_13() throws Exception {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setContent(null);
        notificationDto.setImage("https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field image more specific is null
     *
     * @author HuyenTN
     * @Time 09/09/2022
     */
    @Test
    public void create_image_13() throws Exception {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setContent("Hello");
        notificationDto.setImage(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field content more specific is empty
     *
     * @author HuyenTN
     * @Time 09/09/2022
     */
    @Test
    public void create_content_14() throws Exception {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setContent("");
        notificationDto.setImage("https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field image more specific is empty
     *
     * @author HuyenTN
     * @Time 09/09/2022
     */
    @Test
    public void create_image_14() throws Exception {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setContent("Ngay 10/9 toàn thể nhân viên được tăng lương 10%");
        notificationDto.setImage("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field content more specific is max length
     *
     * @author HuyenTN
     * @Time 09/09/2022
     */
    @Test
    public void create_content_15() throws Exception {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setContent("Ngày Quốc tế Phụ nữ mùng 8 tháng 3 ra đời từ phong trào đấu tranh của công nhân nữ ở Mỹ nhằm đòi quyền sống.  Vào khoảng cuối thế kỉ 19 là thời kì chủ nghĩa tư bản thịnh vượng đặc biệt là ở Mỹ.  Công nghiệp kỹ nghệ thời đó phát triển, người ta tuyển dụng rất nhiều phụ nữ và trẻ em. Tuy nhiên, thời buổi bấy giờ quyền lợi của phụ nữ bị xem nhẹ, tư bản đã chèn ép, bóc lột sức lao động của phụ nữ và trẻ em đến cùng cực nhưng trả lương lại rất rẻ mạt. Cuộc sống của phụ nữ, trẻ em ngày càng nghèo túng, khắc nghiệt.\n" +
                "\n" +
                "Phản đối sự bóc lột tàn nhẫn đó, vào ngày 8/3/1899 thành phố Chicago lẫn New York đã bùng nổ cuộc đấu tranh của nữ công nhân ngành dệt may với mục đích đòi tăng lương, giảm giờ làm. Tuy nhiên, cuộc đấu tranh này nhanh chóng bị đàn áp thẳng tay, các nữ công nhân bị đuổi khỏi nhà máy. Song điều đó không làm nhụt chí tinh thần đấu tranh của chị em phụ nữ, họ vẫn sôi sục ý chí vùng dậy buộc tư bản phải nhượng bộ. Ngày mùng 8 tháng 3 là ngày Quốc tế Phụ nữ. Trong ngày này, người ta thường dành để vinh danh, thể hiện sự tôn trọng với những người phụ nữ trên thế giới. Đây cũng là dịp để mọi người bày tỏ tình cảm, sự quan tâm đến các chị em, các bà, các mẹ, những người phụ nữ tuyệt vời xung quanh mình.");
        notificationDto.setImage("https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of successful
     *
     * @author HuyenTN
     * @Time 09/09/2022
     */
    @Test
    public void create_content_18() throws Exception {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setContent("Ngày mai toàn thể nhân viên được nghỉ");
        notificationDto.setImage("https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
