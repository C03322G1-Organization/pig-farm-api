package vn.codegym.pig_farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PigFarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigFarmApplication.class, args);

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode("123456"));
    }
}
