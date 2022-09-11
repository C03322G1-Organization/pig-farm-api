package vn.codegym.pig_farm;

<<<<<<< HEAD
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PigFarmApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PigFarmApplication {

>>>>>>> origin/contact-PhucND
    public static void main(String[] args) {
        SpringApplication.run(PigFarmApplication.class, args);
    }

}
