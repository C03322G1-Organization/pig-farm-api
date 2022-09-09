package vn.codegym.pig_farm.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.FoodDto;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.entity.Storage;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FoodRestController_update {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     *this function use to edit  item = null
     * 09/09/2022
     * HungNV
     * @throws Exception
     */
    @Test
    public void editComputer_code_19() throws Exception {
        FoodDto foodDto = new FoodDto();
        Storage storage = new Storage();
        Pigsty pigsty = new Pigsty();
        foodDto.setAmount(null);
        foodDto.setUnit("null");
        storage.setId(1);
        foodDto.setStorage(storage);
        pigsty.setId(1);
        foodDto.setPigsty(pigsty);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/food/50")
                        .content(this.objectMapper.writeValueAsString(foodDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *this function use to edit  item = ""
     * 09/09/2022
     * HungNV
     * @throws Exception
     */
    @Test
    public void editComputer_code_20() throws Exception {
        FoodDto foodDto = new FoodDto();
        Storage storage = new Storage();
        Pigsty pigsty = new Pigsty();
        foodDto.setAmount(0);
        foodDto.setUnit("");
        storage.setId(1);
        foodDto.setStorage(storage);
        pigsty.setId(1);
        foodDto.setPigsty(pigsty);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/food/50")
                        .content(this.objectMapper.writeValueAsString(foodDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *this function use to edit  item = (-1,"")
     * 09/09/2022
     * HungNV
     * @throws Exception
     */
    @Test
    public void editComputer_code_21() throws Exception {
        FoodDto foodDto = new FoodDto();
        Storage storage = new Storage();
        Pigsty pigsty = new Pigsty();
        foodDto.setAmount(-1);
        foodDto.setUnit("");
        storage.setId(1);
        foodDto.setStorage(storage);
        pigsty.setId(1);
        foodDto.setPigsty(pigsty);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/food/50")
                        .content(this.objectMapper.writeValueAsString(foodDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *this function use to edit  item = (-10)
     * 09/09/2022
     * HungNV
     * @throws Exception
     */
    @Test
    public void editComputer_code_22() throws Exception {
        FoodDto foodDto = new FoodDto();
        Storage storage = new Storage();
        Pigsty pigsty = new Pigsty();
        foodDto.setAmount(-10);
        foodDto.setUnit("null");
        storage.setId(1);
        foodDto.setStorage(storage);
        pigsty.setId(1);
        foodDto.setPigsty(pigsty);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/food/50")
                        .content(this.objectMapper.writeValueAsString(foodDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *this function use to edit  item = (>1000)
     * 09/09/2022
     * HungNV
     * @throws Exception
     */
    @Test
    public void editComputer_code_23() throws Exception {
        FoodDto foodDto = new FoodDto();
        Storage storage = new Storage();
        Pigsty pigsty = new Pigsty();
        foodDto.setAmount(1001);
        foodDto.setUnit("null");
        storage.setId(1);
        foodDto.setStorage(storage);
        pigsty.setId(1);
        foodDto.setPigsty(pigsty);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/food/50")
                        .content(this.objectMapper.writeValueAsString(foodDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *this function use to edit medicine with all valid item
     * 09/09/2022
     * HungNV
     * @throws Exception
     */
    @Test
    public void editComputer_code_24() throws Exception {
        FoodDto foodDto = new FoodDto();
        Storage storage = new Storage();
        Pigsty pigsty = new Pigsty();
        foodDto.setAmount(5);
        foodDto.setUnit("oke");
        storage.setId(1);
        foodDto.setStorage(storage);
        pigsty.setId(1);
        foodDto.setPigsty(pigsty);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/food/50")
                        .content(this.objectMapper.writeValueAsString(foodDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
