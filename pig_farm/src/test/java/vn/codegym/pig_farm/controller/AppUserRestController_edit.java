package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.UserDto;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppUserRestController_edit {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when miss [item] username user
     */

    @Test
    public void edit_username_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setPassword("987645");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when miss [item] password user
     */

    @Test
    public void edit_password_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when miss [item] email user
     */

    @Test
    public void edit_email_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("987645");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when miss [item] creationDate user
     */

    @Test
    public void edit_creationDate_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("987645");
        userDto.setEmail("vana@gmail.com");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when [item] username is empty user
     */

    @Test
    public void edit_username_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("");
        userDto.setPassword("987645");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when [item] password is empty user
     */

    @Test
    public void edit_password_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when [item] email is empty user
     */

    @Test
    public void edit_email_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("987645");
        userDto.setEmail("");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when [item] creationDate is empty user
     */

    @Test
    public void edit_creationDate_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("987645");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse(""));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when [item] email user incorrect format
     */

    @Test
    public void edit_email_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("qư12");
        userDto.setEmail("vana.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return error when [item] password user <= minlength
     */

    @Test
    public void edit_password_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("qư12");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @throws Exception
     * @Created LongNT
     * @function return register user successful in database
     */

    @Test
    public void edit_24() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("7854632");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2022-09-09"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/4")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
