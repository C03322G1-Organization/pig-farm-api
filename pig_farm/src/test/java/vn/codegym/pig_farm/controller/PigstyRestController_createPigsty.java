package vn.codegym.pig_farm.controller;

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

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check create a Pigsty with value is null
     * @throws Exception
     */
    @Test
    public void createPigsty_name_13() throws Exception {

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setBuildDate("2044-07-01");
        pigstyDto.setCreationDate(null);
        pigstyDto.setMaxNumber(11);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pigsty/createPigsty")
                        .content(this.objectMapper.writeValueAsString(pigstyDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check create a Pigsty with value is empty
     * @throws Exception
     */
    @Test
    public void createPigsty_name_14() throws Exception {

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setBuildDate("2044-07-01");
        pigstyDto.setCreationDate("");
        pigstyDto.setMaxNumber(11);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pigsty/createPigsty")
                        .content(this.objectMapper.writeValueAsString(pigstyDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check create a Pigsty with value is wrong format
     * @throws Exception
     */
    @Test
    public void createPigsty_name_15() throws Exception {

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setBuildDate("99-99-99");
        pigstyDto.setCreationDate("");
        pigstyDto.setMaxNumber(11);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pigsty/createPigsty")
                        .content(this.objectMapper.writeValueAsString(pigstyDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check create a Pigsty with value more than max
     * @throws Exception
     */
    @Test
    public void createPigsty_name_16() throws Exception {

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setBuildDate("2044-07-01");
        pigstyDto.setCreationDate("");
        pigstyDto.setMaxNumber(22);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pigsty/createPigsty")
                        .content(this.objectMapper.writeValueAsString(pigstyDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check create a Pigsty with value less than min
     * @throws Exception
     */
    @Test
    public void createPigsty_name_17() throws Exception {

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setBuildDate("2044-07-01");
        pigstyDto.setCreationDate("");
        pigstyDto.setMaxNumber(-1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pigsty/createPigsty")
                        .content(this.objectMapper.writeValueAsString(pigstyDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: check create a Pigsty with all value is valid
     * @throws Exception
     */
    @Test
    public void createPigsty_name_18() throws Exception {

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setBuildDate("2044-07-01");
        pigstyDto.setCreationDate("2044-07-01");
        pigstyDto.setMaxNumber(20);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        pigstyDto.setEmployeeDto(employeeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pigsty/createPigsty")
                        .content(this.objectMapper.writeValueAsString(pigstyDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
