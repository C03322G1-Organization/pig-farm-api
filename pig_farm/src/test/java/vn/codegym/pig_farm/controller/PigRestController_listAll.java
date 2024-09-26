package vn.codegym.pig_farm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PigRestController_listAll {

    @Autowired
    private MockMvc mockMvc;

    /**
     * @function list rong, tieu chi 5
     * @throws Exception
     */

    @Test
    public void getListPig_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/pig/page/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * @function id is null, return list ok (ko truyen gi vao la ok)
     * @throws Exception
     */

    @Test
    public void getListPig_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/pig/page"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    /**
     * @function id rong(space) , return fail
     * @throws Exception
     */

    @Test
    public void getListPig_8() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/pig/page/ "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * @function tim kiem ko trong database , tieu chi 9
     * @throws Exception
     */

    @Test
    public void getListPig_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/pig/page/codeSearch=aaa"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function findAll list , tieu chi 11
     * @throws Exception
     */

    @Test
    public void getListPig_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/pig/page/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[1].code").value("L-002"))
                .andExpect(jsonPath("content[1].dateIn").value("2022-09-09"))
                .andExpect(jsonPath("content[1].dateOut").value("2022-12-28"))
                .andExpect(jsonPath("content[1].status").value("khoe manh"))
                .andExpect(jsonPath("content[1].weight").value("26"))
                .andExpect(jsonPath("content[1].isDeleted").value("false"));
    }

    /**
     * @function tim kiem co trong database
     * @throws Exception
     */

    @Test
    public void getListPig() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/pig/page?codeSearch=004"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].code").value("L-004"))
                .andExpect(jsonPath("content[0].dateIn").value("2022-07-13"))
                .andExpect(jsonPath("content[0].dateOut").value("2022-11-27"))
                .andExpect(jsonPath("content[0].status").value("Khoẻ mạnh"))
                .andExpect(jsonPath("content[0].weight").value("26.4"))
                .andExpect(jsonPath("content[0].isDeleted").value("false"));
    }

    /**
     * @function xoa id bang null, tieu chi 25
     * @throws Exception
     */

    @Test
    public void deletePig_25() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/pig"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function xoa id bang rong, tieu chi 26
     * @throws Exception
     */

    @Test
    public void deletePig_26() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/pig/ "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function xoa id ko co trong database, tieu chi 27
     * @throws Exception
     */

    @Test
    public void deletePig_27() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/pig/100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @function xoa id co trong database, tieu chi 28
     * @throws Exception
     */

    @Test
    public void deletePig_28() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/pig/3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
