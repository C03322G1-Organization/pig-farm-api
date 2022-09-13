package vn.codegym.pig_farm.dto.projections;

import java.time.LocalDate;

public interface EmployeeDto {
        Integer getId();

        String getCode();

        String getNameEmployee();

        String getGender();

        String getImage();

        String getIdCard();

        LocalDate getBirthDay();

        Boolean getDeleted();

        Integer getUserId();

        String getUserName();

        String getRoleName();


}
