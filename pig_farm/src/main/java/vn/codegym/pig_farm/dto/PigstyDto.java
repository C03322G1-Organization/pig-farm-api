package vn.codegym.pig_farm.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.pig_farm.entity.Employee;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PigstyDto implements Validator {
    private Integer id;

    private LocalDate creationDate;

    private LocalDate buildDate;

    @Max(value = 20,message = "không được lớn hơn 20 cá thể")
    private Integer maxNumber;

    private Boolean isDeleted;

    private Employee employee;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
