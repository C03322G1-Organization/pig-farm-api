package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.PigDTO;
import vn.codegym.pig_farm.entity.Pigsty;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PigRestController_createPig {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * Create by: DatVT
     * Date Create: 09/09/2022
     * funtion: Create test JUnit 5 create in pig
     * @throws Exception
     */

    /**
     * this funtion use to test validation of field code more specific is null
     *
     * @throws Exception
     * @author DatVT
     */
    @Test
    public void createPig_code_13() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode(null);
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this funtion use to test validation of field code more specific is empty
     *
     * @author DatVT
     * @throws Exception
     */
    @Test
    public void createPig_code_14() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this funtion use to test validation of field code more specific is empty
     *
     * @author DatVT
     * @throws Exception
     */
    @Test
    public void createPig_dateIn_14() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn("");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this funtion use to test validation of field code more specific is null
     *
     * @throws Exception
     * @author DatVT
     */
    @Test
    public void createPig_dateIn_13() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn(null);
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this funtion use to test validation of field code more specific is empty
     *
     * @author DatVT
     * @throws Exception
     */
    @Test
    public void createPig_dateOut_14() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML002");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this funtion use to test validation of field code more specific is null
     *
     * @throws Exception
     * @author DatVT
     */
    @Test
    public void createPig_dateOut_13() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML002");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut(null);
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this funtion use to test validation of field code more specific is empty
     *
     * @author DatVT
     * @throws Exception
     */
    @Test
    public void createPig_status_14() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML002");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this funtion use to test validation of field code more specific is null
     *
     * @throws Exception
     * @author DatVT
     */
    @Test
    public void createPig_status_13() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode(null);
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus(null);
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this funtion use to test validation of field code more specific is empty
     *
     * @author DatVT
     * @throws Exception
     */
    @Test
    public void createPig_weight_14() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this funtion use to test validation of field code more specific is null
     *
     * @throws Exception
     * @author DatVT
     */
    @Test
    public void createPig_weight_13() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight(null);

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this funtion use to test validation of field code more specific is min length
     *
     * @author DatVT
     * @throws Exception
     */
    @Test
    public void createPig_weight_15() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("0");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this funtion use to test validation of field code more specific is max length
     *
     * @author DatVT
     * @throws Exception
     */
    @Test
    public void createPig_weight_16() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("150");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this funtion use to test validation of field code more specific is empty
     *
     * @author DatVT
     * @throws Exception
     */
    @Test
    public void createPig_id_14() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this funtion use to test validation of field code more specific is null
     *
     * @throws Exception
     * @author DatVT
     */
    @Test
    public void createPig_id_13() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(null);
        pigDTO.setPigsty(pigsty);

        pigDTO.setIsDeleted(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this funtion use to test validation of field code more specific is null
     *
     * @throws Exception
     * @author DatVT
     */
    @Test
    public void createPig_delete_13() throws Exception {
        PigDTO pigDTO = new PigDTO();
        pigDTO.setCode("ML001");
        pigDTO.setDateIn("2022-01-01");
        pigDTO.setDateOut("2022-02-02");
        pigDTO.setStatus("1");
        pigDTO.setWeight("1");

        Pigsty pigsty = new Pigsty();
        pigsty.setId(1);
        pigDTO.setPigsty(pigsty);
        pigDTO.setIsDeleted(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pig/create")
                        .content(this.objectMapper.writeValueAsString(pigDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
