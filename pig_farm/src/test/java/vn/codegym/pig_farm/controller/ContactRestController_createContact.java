package vn.codegym.pig_farm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.pig_farm.dto.ContactDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactRestController_createContact {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void createContact_name_14() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName(null);
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("0987687678");
        contactDto.setAddress("Huế");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
