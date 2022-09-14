package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.PigDto;
import vn.codegym.pig_farm.dto.TreatmentDto;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TreatmentController_createTreatment {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to test the validation of field date more specific is null
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_date_13() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
        treatmentDto.setDate(null);
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field date more specific is empty
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_date_14() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field date more specific is  wrong format
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_date_15() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(22);
//        treatmentDto.setDate('2000-02-02');
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field doctor more specific is null
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_doctor_13() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor(null);
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field doctor more specific is empty
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_doctor_14() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field doctor more specific is min length
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_doctor_16() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("a");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field doctor more specific is max length
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_doctor_17() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("nguyen van a nguyen van a nguyen van a nguyen van a nguyen van a nguyen van a " +
                "nguyen van a nguyen van a nguyen van a nguyen van a nguyen van a");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field amount more specific is null
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_amount_13() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(null);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field amount more specific is negative
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_amount_15() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(-3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field amount more specific is number is too big
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_amount_16() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(22);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(888888888);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field diseases more specific is null
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_diseases_13() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases(null);
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field diseases more specific is empty
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_diseases_14() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field diseases more specific is min length
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_diseases_16() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("a");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field diseases more specific is max length
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_diseases_17() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("nguyen van a");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("hsgdsaghdgsadgajgdakgdkagdgdhsagdhsaghdgsajdgsajkdgsajgdsagdksadksadkasgdgsdgsadgasgdsafdsadja");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field medicine more specific is null
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_medicine_13() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine(null);
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field medicine more specific is empty
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_medicine_14() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field medicine more specific is min length
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_medicine_16() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("a");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field medicine more specific is max length
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_medicine_17() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abcsfdfsadfsahdfsahfdhsafdhfadshfdsjfgsgdjasgkhÂSDGADJGSADGSGDSGDHGSHGDHSGDHGSHGDSHGDHGS");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field pig_id more specific is null
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_pig_id_13() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(21);
//        treatmentDto.setDate("01-01-2000");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(null);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation more specific is successful
     *
     * @author TuongTK
     * @Date 09/09/2022
     */
    @Test
    public void createTreatment_18() throws Exception {
        TreatmentDto treatmentDto = new TreatmentDto();
        treatmentDto.setId(23);
//        treatmentDto.setDate("2022-02-02");
        treatmentDto.setDoctor("Nguyen Van A");
        treatmentDto.setAmount(3);
        treatmentDto.setDiseases("cúm");
        treatmentDto.setMedicine("abc");
        treatmentDto.setDeleted(false);
        PigDto pigDto = new PigDto();
        pigDto.setId(2);
        treatmentDto.setPigDto(pigDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/treatment/v1")
                        .content(this.objectMapper.writeValueAsString(treatmentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
