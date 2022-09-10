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
public class ExportRestController_updateExport {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_codeExport_19
     */
    @Test
    public void updateExport_codeExport_19() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport(null);
        exportDto.setCompany("NHA A");
        exportDto.setPrice(1000.0);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_codeExport_20
     */
    @Test
    public void updateExport_codeExport_20() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("");
        exportDto.setCompany("NHA A");
        exportDto.setPrice(1000.0);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_codeExport_23
     */
    @Test
    public void updateExport_codeExport_23() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC0111111111111111111111111111111111111111111111111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111111111111111111111111111111111111111");
        exportDto.setCompany("NHA A");
        exportDto.setPrice(1000.0);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_company_19
     */
    @Test
    public void updateExport_company_19() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC0111");
        exportDto.setCompany(null);
        exportDto.setPrice(1000.0);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_company_20
     */
    @Test
    public void updateExport_company_20() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC0111");
        exportDto.setCompany("");
        exportDto.setPrice(1000.0);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_company_23
     */
    @Test
    public void updateExport_company_23() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC0111");
        exportDto.setCompany("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        exportDto.setPrice(1000.0);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_price_19
     */
    @Test
    public void updateExport_price_19() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport(null);
        exportDto.setCompany("NHA A");
        exportDto.setPrice(null);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_price_20
     */
    @Test
    public void updateExport_price_20() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("");
        exportDto.setCompany("NHA A");
        exportDto.setPrice(null);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_price_21
     */
    @Test
    public void updateExport_price_21() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("");
        exportDto.setCompany("NHA A");
        exportDto.setPrice(-10000.0);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_price_23
     */
    @Test
    public void updateExport_price_23() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("");
        exportDto.setCompany("NHA A");
        exportDto.setPrice(100000000.0);
        exportDto.setTypePigs("thit");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_typePigs_19
     */
    @Test
    public void updateExport_typePigs_19() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC0111");
        exportDto.setCompany("Nhà c");
        exportDto.setPrice(10000.0);
        exportDto.setTypePigs(null);
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_typePigs_20
     */
    @Test
    public void updateExport_typePigs_20() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC0111");
        exportDto.setCompany("Nhà c");
        exportDto.setPrice(10000.0);
        exportDto.setTypePigs("");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_typePigs_20
     */
    @Test
    public void updateExport_typePigs_21() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC0111");
        exportDto.setCompany("Nhà c");
        exportDto.setPrice(10000.0);
        exportDto.setTypePigs("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        exportDto.setDeleted(false);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: updateExport_codeExport_24
     */
    @Test
    public void updateExport_codeExport_24() throws Exception {

        ExportDto exportDto = new ExportDto();
        exportDto.setCodeExport("MC0111");
        exportDto.setCompany("Nhà c");
        exportDto.setPrice(10000.0);
        exportDto.setTypePigs("Lợn thịt");

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        PigstyDto pigstyDto = new PigstyDto();
        pigstyDto.setId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/export/update/1")
                        .content(this.objectMapper.writeValueAsString(exportDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
