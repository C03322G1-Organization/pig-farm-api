package vn.codegym.pig_farm.dto;


import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
@Data
public class EmployeeDto implements Validator {
    private Integer id;
    private String code;
    private String name;
    private LocalDate birthDay;
    private String gender;
    private String idCard;
    private String image;
    private Boolean isDeleted;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }

}
