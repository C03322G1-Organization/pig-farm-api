package vn.codegym.pig_farm.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PigstyDto implements Validator {
    private Integer id;
    @NotNull
    @NotEmpty
    private String creationDate;

    private Integer typePigs;

    private String buildDate;

    @Max(value = 20, message = "không được lớn hơn 20 cá thể")
    @Min(value = 1, message = "không được nhỏ hơn 20 cá thể")
    private Integer maxNumber;

    private Boolean isDeleted;

    private EmployeeDto employeeDto;


    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: PigstyDto
     * return pigstyDto
     */

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}
