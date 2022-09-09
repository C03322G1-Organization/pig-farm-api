package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.StorageDto;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StorageRestController_getCreateStorage {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field foodType more specific is null
     */
    @Test
    public void createStorage_food_type_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setAmount(15);
        storageDto.setUnit("Kg");
        storageDto.setDate(LocalDate.ofEpochDay(2000-10-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field foodType more specific is empty
     */
    @Test
    public void createStorage_food_type_14() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("");
        storageDto.setAmount(15);
        storageDto.setUnit("Kg");
        storageDto.setDate(LocalDate.ofEpochDay(2000-10-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field foodType more specific is containing 1-30 character
     */
    @Test
    public void createStorage_food_type_17() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        storageDto.setAmount(15);
        storageDto.setUnit("Kg");
        storageDto.setDate(LocalDate.ofEpochDay(2000-10-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field amount more specific is null
     */
    @Test
    public void createStorage_amount_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setUnit("Kg");
        storageDto.setDate(LocalDate.ofEpochDay(2000-10-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field name more specific is containing character > 0
     */
    @Test
    public void createStorage_amount_17() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount(-1);
        storageDto.setUnit("Kg");
        storageDto.setDate(LocalDate.ofEpochDay(2000-02-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field foodType more specific is null
     */
    @Test
    public void createStorage_unit_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo con");
        storageDto.setAmount(15);
        storageDto.setDate(LocalDate.ofEpochDay(2000-10-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field foodType more specific is empty
     */
    @Test
    public void createStorage_unit_14() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo con");
        storageDto.setAmount(15);
        storageDto.setUnit("");
        storageDto.setDate(LocalDate.ofEpochDay(2000-10-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field name more specific is containing 1-15 character
     */
    @Test
    public void createStorage_unit_17() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount(15);
        storageDto.setUnit("Kgggggggggggggggggggggggggggggg");
        storageDto.setDate(LocalDate.ofEpochDay(2000-02-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to test the validation of field amount more specific is null
     * */
    @Test
    public void createStorage_date_13() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount(15);
        storageDto.setUnit("Kg");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: this function use to check the field-specific date validation rather than the correct format
     */
    @Test
    public void createStorage_date_15() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount(15);
        storageDto.setUnit("Kg");
        storageDto.setDate(LocalDate.ofEpochDay(2000-50-50));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoangDT
     * Date Create: 09/09/2022
     * funtion: his function use to create storage with all valid item
     */
    @Test
    public void createStorage_all_item_18() throws Exception {
        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount(15);
        storageDto.setUnit("Kg");
        storageDto.setDate(LocalDate.ofEpochDay(2000-02-05));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/storage/create")
                        .content(this.objectMapper.writeValueAsString(storageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
