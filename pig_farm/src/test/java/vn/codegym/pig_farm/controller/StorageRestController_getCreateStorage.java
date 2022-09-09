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

    @Test
    public void createStudent_name_14() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("");
        storageDto.setAmount("15");
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

    @Test
    public void createStudent_name_15() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount("15");
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

    @Test
    public void createStudent_name_16() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount("15000000000000000000000");
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

    @Test
    public void createStudent_name_17() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount("-1");
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
    @Test
    public void createStudent_name_18() throws Exception {

        StorageDto storageDto = new StorageDto();
        storageDto.setFoodType("Heo nái");
        storageDto.setAmount("15");
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
