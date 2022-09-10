package vn.codegym.pig_farm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdvertisementRestController_listAdvertisement {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Get Advertisement list with title = null
     * Return full list at page 1(Here, when null returns full list)
     */
    @Test
    public void getAdvertisementList_1_titleNull() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/advertisement/page?keySearch=null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Get Advertisement list with title = ""
     * Return full list at page 1(Here, when you do not enter anything, the full list is returned)
     */
    @Test
    public void getAdvertisementList_2_titleEmpty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/advertisement/page?keySearch"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Get Advertisement list with title is not exist
     * Return an empty list at page 1
     */
    @Test
    public void getAdvertisementList_3_titleNotExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/advertisement/page?keySearch=khongco"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Get Advertisement list with size = 0
     * Return an empty list at page 1
     */
    @Test
    public void getAdvertisementList_4_size0() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/advertisement/page?keySearch"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: DucNH
     * Date create: 09/09/2022
     * Get Advertisement list with title is ok and everything is ok
     * Return a page list with the result is the advertisement list who has the title like what you typed
     */
    @Test
    public void getAdvertisementList_5_titleOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/advertisement/page?keySearch=g"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
