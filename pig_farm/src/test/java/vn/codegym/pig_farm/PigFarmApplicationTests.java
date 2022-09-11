package vn.codegym.pig_farm;

import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PigFarmApplicationTests {

    @Test
    void contextLoads() {
    }

}
=======
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class PigFarmApplicationTests {
    @Test
    void contextLoads() {
    }
}

>>>>>>> origin/food-HoanTV
