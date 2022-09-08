package vn.codegym.pig_farm.projection.employee;

import vn.codegym.pig_farm.entity.User;

import java.time.LocalDate;

public interface IEmployeeProjection {

    public Integer getId();

    public String getCode();

    public String getName();

    public LocalDate getBirthDay();

    public String getGender();

    public String getIdCard() ;

    public String getImage() ;

    public Boolean getDeleted();

    public User getUser();

    RoleWithName getRole();

    interface RoleWithName{
        String getName();
    }


}
