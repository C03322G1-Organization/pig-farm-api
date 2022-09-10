package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.PigstyDto;
import vn.codegym.pig_farm.dto.VaccinationDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VaccinationRestController_createVaccination {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createVaccination_name_13() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create")).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createVaccination_name_14() throws Exception {

        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(7);
        vaccinationDto.setDate("2022-01-21");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create").content(this.objectMapper.writeValueAsString(vaccinationDto)).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createVaccination_name_16() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(33);
        vaccinationDto.setDate("2022-01-21");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("An Nhiên");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create").content(this.objectMapper.writeValueAsString(vaccinationDto)).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createVaccination_name_18() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(8);
        vaccinationDto.setDate("2022-01-21");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("Lam Linh");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);
//        vaccinationDto.setPigsty(pigstyDto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create").content(this.objectMapper.writeValueAsString(vaccinationDto)).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
