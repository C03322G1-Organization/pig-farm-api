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
public class EmployeeRestController_edit {

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
    public void edit_code_19() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_name_19() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_birthDay_19() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_gender_19() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_idCard_19() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_image_19() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_code_20() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_name_20() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_birthDay_20() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse(""));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_gender_20() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_idCard_20() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_image_20() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_code_21() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("sldfnkv");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_name_21() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName(",dfvb,vzxc");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_idCard_21() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơn");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("kzfbxkcb xkcjb");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_name_22() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
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
    public void edit_name_23() throws Exception {
        EmployDto employDto = new EmployDto();
        employDto.setCode("NV-001");
        employDto.setName("Trần Ngọc Sơnhhhhhhhhhhhhhhhhhhhhádfsđoàóihdfoáhdfoáhidfoáihdfoáhdfoádhfoádhvoiáh");
        employDto.setBirthDay(LocalDate.parse("2000-10-10"));
        employDto.setGender("Nam");
        employDto.setIdCard("123456789");
        employDto.setImage("sdfdfb");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return update employee successful
     * @throws Exception
     */

    @Test
    public void edit_24() throws Exception {
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

        this.mockMvc.perform(MockMvcRequestBuilders.put("/employee/4")
                        .content(this.objectMapper.writeValueAsString(employDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
