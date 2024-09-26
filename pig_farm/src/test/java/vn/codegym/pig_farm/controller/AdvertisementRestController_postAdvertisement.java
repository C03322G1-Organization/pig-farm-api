package vn.codegym.pig_farm.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.AdvertisementDto;
import vn.codegym.pig_farm.entity.Placement;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdvertisementRestController_postAdvertisement {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field title more specific is Empty
     */

    @Test
    public void postAdvertisement_title_14() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("4");
        advertisementDto.setImage("http//firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field title does not contain special characters
     */
    @Test
    public void postAdvertisement_title_15() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("?@#");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("4");
        advertisementDto.setImage("http//firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field title successfully
     */
    @Test
    public void postAdvertisement_title_18() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("Quảng cáo");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("4");
        advertisementDto.setImage("http//firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field image more specific is Empty
     */
    @Test
    public void postAdvertisement_image_14() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("Quảng cáo");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("4");
        advertisementDto.setImage("");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field image more can access the link
     */
    @Test
    public void postAdvertisement_image_15() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("Quảng cáo");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("4");
        advertisementDto.setImage("http:firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field image successfully
     */
    @Test
    public void postAdvertisement_image_18() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("Quảng cáo");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("4");
        advertisementDto.setImage("http//firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field submittedDate successfully
     */
    @Test
    public void postAdvertisement_submittedDate_14() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("Quảng cáo");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("4");
        advertisementDto.setImage("http:firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field timeExistence isEmpty
     */
    @Test
    public void postAdvertisement_timeExistence_14() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("Quảng cáo");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("");
        advertisementDto.setImage("http:firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field timeExistence isEmpty
     */
    @Test
    public void postAdvertisement_timeExistence_15() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("Quảng cáo");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("abvs");
        advertisementDto.setImage("http:firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: ChungHV
     * Date Create: 9/09/2022
     * funtion: Post Advertisement
     *
     * @throws Exception this function use to test validation of field timeExistence successfully
     */
    @Test
    public void postAdvertisement_timeExistence_18() throws Exception {

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setTitle("Quảng cáo");
        advertisementDto.setDeleted(false);
        advertisementDto.setSubmittedDate(LocalDate.parse("2022-05-16"));
        advertisementDto.setTimeExistence("4");
        advertisementDto.setImage("http:firebase");

        Placement placement = new Placement();
        placement.setId(1);
        advertisementDto.setPlacement(placement);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/advertisement/post")
                        .content(this.objectMapper.writeValueAsString(advertisementDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
