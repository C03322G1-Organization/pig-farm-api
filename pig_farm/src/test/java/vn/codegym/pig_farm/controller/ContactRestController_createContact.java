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
    /**
     * Create by: PhucND
     * Date Create: 09/09/2022
     * function: Create test JUnit 5 create in contact
     * @throws Exception
     */

    /**
     * this function use to test validation of field name more specific is null
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_name_13() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName(null);
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("0987687678");
        contactDto.setAddress("Huế");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field name more specific is blank
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_name_14() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("");
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("0987687678");
        contactDto.setAddress("Huế");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field email more specific is null
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_email_13() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail(null);
        contactDto.setPhone("0987687678");
        contactDto.setAddress("Huế");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field email more specific is blank
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_email_14() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("");
        contactDto.setPhone("0987687678");
        contactDto.setAddress("Huế");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field phone more specific is null
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_phone_13() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone(null);
        contactDto.setAddress("Huế");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field phone more specific is blank
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_phone_14() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("");
        contactDto.setAddress("Huế");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field address more specific is null
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_address_13() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("0987687678");
        contactDto.setAddress(null);
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field address more specific is blank
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_address_14() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("0987687678");
        contactDto.setAddress("");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field content more specific is null
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_content_13() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("0987687678");
        contactDto.setAddress("Huế");
        contactDto.setContent(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field content more specific is blank
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_content_14() throws Exception {
        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("0987687678");
        contactDto.setAddress("Huế");
        contactDto.setContent("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field phone more specific is validator
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_phone_15() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("ndphuc@gmail.com");
        contactDto.setPhone("0897");
        contactDto.setAddress("Huế");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test validation of field email more specific is validator
     *
     * @throws Exception
     * @author PhucND
     */
    @Test
    public void createContact_email_15() throws Exception {

        ContactDto contactDto = new ContactDto();
        contactDto.setName("Phuc");
        contactDto.setEmail("ndphuc@");
        contactDto.setPhone("0812341234");
        contactDto.setAddress("Huế");
        contactDto.setContent("mua heo");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/contact/create")
                        .content(this.objectMapper.writeValueAsString(contactDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
