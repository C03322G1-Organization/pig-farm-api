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
import vn.codegym.pig_farm.dto.ExportDto;
import vn.codegym.pig_farm.dto.PigstyDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExportRestController_createExport {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_company_14
     */
    @Test
    public void createExport_company_14() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany("");
        exportDto.setAmount(10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_company_13
     */
    @Test
    public void createExport_company_13() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany(null);
        exportDto.setAmount(10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_company_17
     */
    @Test
    public void createExport_company_17() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        exportDto.setAmount(10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_18
     */
    @Test
    public void createExport_18() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany("nhadong");
        exportDto.setAmount(10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        exportDto.setEmployeeDto(employeeDto);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);
        exportDto.setPigstyDto(pigstyDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_amount_15
     */
    @Test
    public void createExport_amount_15() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany("nha dong");
        exportDto.setAmount(-10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_price_15
     */
    @Test
    public void createExport_price_15() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany("nha dong");
        exportDto.setAmount(-10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_typePigs_13
     */
    @Test
    public void createExport_typePigs_13() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany("nha dong");
        exportDto.setAmount(10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs(null);
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_typePigs_14
     */
    @Test
    public void createExport_typePigs_14() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany("nha dong");
        exportDto.setAmount(10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_kilogram_15
     */
    @Test
    public void createExport_kilogram_15() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01");
        exportDto.setCompany("nha dong");
        exportDto.setAmount(10);
        exportDto.setKilogram(-30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_codeExport_13
     */
    @Test
    public void createExport_codeExport_13() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport(null);
        exportDto.setCompany("nha dong");
        exportDto.setAmount(10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_codeExport_14
     */
    @Test
    public void createExport_codeExport_14() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("");
        exportDto.setCompany("nha dong");
        exportDto.setAmount(10);
        exportDto.setKilogram(-30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: createExport_codeExport_17
     */
    @Test
    public void createExport_codeExport_17() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC01aaaaaaaaaaaaaaaaaMC01aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaMC01aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        exportDto.setCompany("nha dong");
        exportDto.setAmount(10);
        exportDto.setKilogram(30.0);
        exportDto.setPrice(30.0);
        exportDto.setTypePigs("Lon thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/export/create")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
