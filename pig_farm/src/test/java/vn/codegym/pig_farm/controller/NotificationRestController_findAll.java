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
class NotificationRestController_findAll {
    @Autowired
    private MockMvc mockMvc;


    /**
     * This function used to test display all record with keyword = null
     *
     * @throws Exception
     * @author DatLT
     * @Time 09/09/2022
     */
    @Test
    void findAll_keyword_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/api/v1/notification/list?keyword=" + null)).andDo(print()).andExpect(status().is(204));
    }


    /**
     * This function used to test display all record with keyword = "", has pagination
     *
     * @throws Exception
     * @author DatLT
     * @Time 09/09/2022
     */
    @Test
    void findAll_keyword_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/api/v1/notification/list?keyword=")).
                andDo(print()).
                andExpect(status().is(200)).
                andExpect(jsonPath("totalPages").value(2)).
                andExpect(jsonPath("totalElements").value(11)).
                andExpect(jsonPath("content[9].id").value(2)).
                andExpect(jsonPath("content[9].title").value("Thị trường thịt heo: Dễ đẩy giá lên, khó kéo giá xuống ?")).
                andExpect(jsonPath("content[9].content").value("<p><strong>TTCT - Lần đầu tiên trong lịch sử, VN cho nhập khẩu heo sống về để giết thịt nhằm tăng nguồn cung trong nước, qua đó bình ổn thị trường và kéo giá heo trong nước xuống.</strong></p><p>Tuy nhiên, theo nhiều chuyên gia, đây chỉ là giải pháp tình thế. Về lâu dài vẫn phải tăng nguồn cung thịt heo trong nước về bằng trước khi có dịch bệnh thì mới có thể đưa giá heo về mức ổn định lâu dài.</p><p><strong>Ai mới thực sự chi phối ?</strong></p><p>Ông Huỳnh Thành Vinh, giám đốc Sở NN&amp;PTNT tỉnh Đồng Nai - một trong những địa phương có đàn heo lớn nhất nước, cho biết toàn tỉnh hiện có khoảng 2,1 triệu con heo. Trong đó, chăn nuôi trang trại chiếm hơn 90% (50-60% trong số này của doanh nghiệp (DN) đầu tư nước ngoài), chăn nuôi nhỏ lẻ chiếm gần 10% tổng đàn với khoảng 6.150 hộ chăn nuôi.</p>")).
                andExpect(jsonPath("content[9].submittedDate").value("2022-09-02")).
                andExpect(jsonPath("content[9].image").value("https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/news%2F2022-09-17%2002%3A15%3A34t%E1%BB%95ng%20quan%20%C4%91%C3%A0n%20heo.jpg?alt=media&token=c0226b8d-0323-4d23-989d-5afb7766985c")).
                andExpect(jsonPath("content[9].isDeleted").value(false));
    }


    /**
     * This function used to test display all record with keyword = "long"
     *
     * @throws Exception
     * @author DatLT
     * @Time 09/09/2022
     */
    @Test
    void findAll_keyword_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/api/v1/notification/list?keyword=long")).andDo(print()).andExpect(status().is(204));
    }


    /**
     * This function used to test display all record with keyword = "ngãi"
     *
     * @throws Exception
     * @author DatLT
     * @Time 09/09/2022
     */
    @Test
    void findAll_keyword_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/api/v1/notification/list?keyword=ngãi")).
                andDo(print()).andExpect(status().is(204));
    }

    /**
     * This function used to test display all record with keyword = "heo", has pagination
     *
     * @throws Exception
     * @author DatLT
     * @Time 09/09/2022
     */
    @Test
    void findAll_keyword_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/public/api/v1/notification/list?keyword=heo")).
                andDo(print()).andExpect(status().is(200)).
                andExpect(jsonPath("totalPages").value(1)).
                andExpect(jsonPath("totalElements").value(8)).
                andExpect(jsonPath("content[7].id").value(1)).
                andExpect(jsonPath("content[7].title").value("giá thịt heo và kinh tế học hành vi")).
                andExpect(jsonPath("content[7].content").value("<p>Theo ghi nhận của Bộ NN&amp;PTNT, kể từ tháng 4, giá heo hơi lên đến 93.000 - 95.000 đồng/kg, khiến mặt bằng bán lẻ khi đến tay người tiêu dùng lên đến con số kỷ lục: 140.000 - 190.000 đồng/kg.</p><p><strong>Đại gia lãi lớn</strong></p><p>Nhờ đó, khá nhiều DN chăn nuôi thu được lợi nhuận cực lớn. Đơn cử như Masan MEAT Life (MML), ghi nhận doanh thu thuần trong quý 1-2020 đạt 3.397 tỉ đồng. Trong đó, ngành hàng thịt là động lực tăng trưởng chính với doanh thu ước tính tăng gấp 13 lần so với cùng kỳ năm ngoái. “Doanh thu MML dù chỉ tăng trưởng nhẹ khoảng 6%, nhưng mảng kinh doanh thịt mát có doanh thu tăng 13 lần so với cùng kỳ năm ngoái. Đây là động lực tăng trưởng chính của MML trong tương lai” - Công ty chứng khoán Phú Hưng nhận định.</p>")).
                andExpect(jsonPath("content[7].submittedDate").value("2022-09-01")).
                andExpect(jsonPath("content[7].image").value("https://firebasestorage.googleapis.com/v0/b/notification-a799c.appspot.com/o/news%2F2022-09-17%2002%3A13%3A05bi%E1%BB%83u%20%C4%91%E1%BB%93%20gi%C3%A1%20th%E1%BB%8Bt%20heo.jpg?alt=media&token=147a5db4-bd42-4216-9ca9-4ed3b65ddc45")).
                andExpect(jsonPath("content[7].isDeleted").value(false));
    }
}
