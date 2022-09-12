package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.entity.JwtRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthenticationController_reset {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * This function use to test the validation of field name more specific is null
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void reset_username_13() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setUsername(null);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/reset-password")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test the validation of field name more specific is empty
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void reset_username_14() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setUsername("");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/reset-password")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to verify the field name to be that is not to be used to the special character.
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void reset_username_15() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setUsername("admin@#");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/reset-password")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to verify that a specific field password is not more than 32 characters
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void createAuthenticationToken_password_16() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setPassword("12334455283237283478628731298183778163asdsadjasvhdgjzxcz87872323sjag");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to verify the Ming that a field password can must be more than 8 character
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void createAuthenticationToken_password_17() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setPassword("123344");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to verify that all are valid
     *
     * @author SangNH
     * @Time 15:00 09/09/2022
     */
    @Test
    public void reset_username_18() throws Exception {
        JwtRequest authenticationRequest = new JwtRequest();
        authenticationRequest.setUsername("admin");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/reset-password")
                        .content(this.objectMapper.writeValueAsString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
