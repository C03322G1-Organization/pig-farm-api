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
public class AppUserRestController_save {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Created LongNT
     * @function return error when miss [item] username user
     * @throws Exception
     */

    @Test
    public void save_username_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setPassword("987645");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when miss [item] password user
     * @throws Exception
     */

    @Test
    public void save_password_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when miss [item] email user
     * @throws Exception
     */

    @Test
    public void save_email_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("987645");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when miss [item] creationDate user
     * @throws Exception
     */

    @Test
    public void save_creationDate_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("987645");
        userDto.setEmail("vana@gmail.com");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] username is empty user
     * @throws Exception
     */

    @Test
    public void save_username_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("");
        userDto.setPassword("987645");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] password is empty user
     * @throws Exception
     */

    @Test
    public void save_password_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] email is empty user
     * @throws Exception
     */

    @Test
    public void save_email_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("987645");
        userDto.setEmail("");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] creationDate is empty user
     * @throws Exception
     */

    @Test
    public void save_creationDate_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("987645");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse(""));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] email user incorrect format
     * @throws Exception
     */

    @Test
    public void save_email_15() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("qư12");
        userDto.setEmail("vana.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return error when [item] password user <= minlength
     * @throws Exception
     */

    @Test
    public void save_password_16() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("qư12");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2020-10-11"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Created LongNT
     * @function return register user successful in database
     * @throws Exception
     */

    @Test
    public void save_18() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("Admin");
        userDto.setPassword("7854632");
        userDto.setEmail("vana@gmail.com");
        userDto.setCreationDate(LocalDate.parse("2022-09-09"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
