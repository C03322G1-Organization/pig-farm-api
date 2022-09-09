package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.User;

import java.time.LocalDate;

public class EmployeeDto {
    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: EmployeeDto
     * return employeeDto
     */
    private Integer id;
    private String code;
    private String name;
    private LocalDate birthDay;
    private String gender;
    private String idCard;
    private String image;
    private User user;

    public EmployeeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
