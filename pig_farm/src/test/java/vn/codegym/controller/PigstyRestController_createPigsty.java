package vn.codegym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.EmployeeDto;
import vn.codegym.pig_farm.dto.PigstyDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PigstyRestController_createPigsty {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createPigsty_creationDate_13() throws Exception {
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setCreationDate(null);
        pigstyDto.setBuildDate("2020-02-02");
        pigstyDto.setMaxNumber(10);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pigsty/createPigsty")
                        .content(this.objectMapper.writeValueAsString(pigstyDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createPigsty_creationDate_14() throws Exception {
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setCreationDate("");
        pigstyDto.setBuildDate("2020-02-02");
        pigstyDto.setMaxNumber(10);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pigsty/createPigsty")
                        .content(this.objectMapper.writeValueAsString(pigstyDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



}
