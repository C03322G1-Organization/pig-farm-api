package vn.codegym.pig_farm.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.pig_farm.entity.Employee;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Data
public class PigstyDto implements Validator {
    private Integer id;
    @NotNull
    @NotEmpty
    private String creationDate;

    private String buildDate;

    @Max(value = 20, message = "không được lớn hơn 20 cá thể")
    @Min(value = 1, message ="không được nhỏ hơn 20 cá thể" )
    private Integer maxNumber;

    private Boolean isDeleted;

    private EmployeeDto employeeDto;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
