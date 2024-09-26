package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.EmployDto;
import vn.codegym.pig_farm.dto.UserDto;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_save {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Created LongNT
     * @function return error when miss [item] code employee
     * @throws Exception
     */

    @Test
    public void save_code_13() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when miss [item] name employee
     * @throws Exception
     */

    @Test
    public void save_name_13() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when miss [item] birthDay employee
     * @throws Exception
     */

    @Test
    public void save_birthDay_13() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when miss [item] gender employee
     * @throws Exception
     */

    @Test
    public void save_gender_13() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when miss [item] idCard employee
     * @throws Exception
     */

    @Test
    public void save_idCard_13() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when miss [item] image employee
     * @throws Exception
     */

    @Test
    public void save_image_13() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] code is empty employee
     * @throws Exception
     */

    @Test
    public void save_code_14() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] name is empty employee
     * @throws Exception
     */

    @Test
    public void save_name_14() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] birthDay is empty employee
     * @throws Exception
     */

    @Test
    public void save_birthDay_14() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse(""));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] gender is empty employee
     * @throws Exception
     */

    @Test
    public void save_gender_14() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] idCard is empty employee
     * @throws Exception
     */

    @Test
    public void save_idCard_14() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] image is empty employee
     * @throws Exception
     */

    @Test
    public void save_image_14() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] code employee incorrect format
     * @throws Exception
     */

    @Test
    public void save_code_15() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("sldfnkv");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] name employee incorrect format
     * @throws Exception
     */

    @Test
    public void save_name_15() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName(",dfvb,vzxc");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] idCard employee incorrect format
     * @throws Exception
     */

    @Test
    public void save_idCard_15() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("kzfbxkcb xkcjb");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] name employee <= minlength
     * @throws Exception
     */

    @Test
    public void save_name_16() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] name employee >= maxlength
     * @throws Exception
     */

    @Test
    public void save_name_17() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơnhhhhhhhhhhhhhhhhhhhhádfsđoàóihdfoáhdfoáhidfoáihdfoáhdfoádhfoádhvoiáh");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return register employee successful in database
     * @throws Exception
     */

    @Test
    public void save_18() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        UserDto userDto = new UserDto();
        userDto.setId(1);
        employDto.setUserDto(userDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}