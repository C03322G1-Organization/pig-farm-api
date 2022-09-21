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
import vn.codegym.pig_farm.entity.Pigsty;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VaccinationRestController_createVaccination {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    /**
     *this function use to create item = null
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_13() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/vaccine/create"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *this function use to create vaccinatedPerson not null
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_vaccinatedPerson_14() throws Exception {
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
    /**
     *this function use to create vaccineType not bank
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_vaccineType_14() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(7);
        vaccinationDto.setDate("2022-01-21");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("Lam Linh");
        vaccinationDto.setVaccineType("");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create").content(this.objectMapper.writeValueAsString(vaccinationDto)).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     *this function use to create date not blank
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_date_14() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(7);
        vaccinationDto.setDate("");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("Lam Linh");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create").content(this.objectMapper.writeValueAsString(vaccinationDto)).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     *this function use to create pigsty < 0
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_pigsty_15() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(1);
        vaccinationDto.setDate("");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("Lam Linh");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(-1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create").content(this.objectMapper.writeValueAsString(vaccinationDto)).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     *this function use to create vaccinatedPerson contains number
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_vaccinatedPerson_15() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(1);
        vaccinationDto.setDate("");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("Lam Linh 1");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create").content(this.objectMapper.writeValueAsString(vaccinationDto)).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     *this function use to create amount > 9
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_amount_16() throws Exception {
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
    /**
     *this function use to create amount<1
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_amount1_16() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(0);
        vaccinationDto.setDate("2022-01-21");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("An Nhiên");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/vaccination/create").content(this.objectMapper.writeValueAsString(vaccinationDto)).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     *this function use to create vaccinatedPerson.length > 30
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_vaccinatedPerson_16() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(3);
        vaccinationDto.setDate("2022-01-21");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("An Nhiên An Nhiên An Nhiên An Nhiên An Nhiên An Nhiên An Nhiên An Nhiên An Nhiên An Nhiên");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/vaccination/create")
                        .content(this.objectMapper.writeValueAsString(vaccinationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *this function use to create vaccinatedPerson.length < 5
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_vaccinatedPerson_17() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(3);
        vaccinationDto.setDate("2022-01-21");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("An");
        vaccinationDto.setVaccineType("PPK");

        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/vaccination/create")
                        .content(this.objectMapper.writeValueAsString(vaccinationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *this function use to create vaccination with all valid item
     * 09/09/2022
     * DamTN
     * @throws Exception
     */
    @Test
    public void createVaccination_18() throws Exception {
        VaccinationDto vaccinationDto = new VaccinationDto();
        vaccinationDto.setAmount(8);
        vaccinationDto.setDate("2022-01-21");
        vaccinationDto.setDeleted(false);
        vaccinationDto.setNote("ML001 không tiêm");
        vaccinationDto.setVaccinatedPerson("Lam Linh");
        vaccinationDto.setVaccineType("PPK");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        vaccinationDto.setPigstyCode(pigsty);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/vaccination/create")
                        .content(this.objectMapper.writeValueAsString(vaccinationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
