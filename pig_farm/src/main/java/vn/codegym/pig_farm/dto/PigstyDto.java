package vn.codegym.pig_farm.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.entity.Pig;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by: HoaL
 * Date created: 09/09/2022
 * Function: PigstyDto
 * return pigstyDto
 */

public class PigstyDto implements Validator {
    private Integer id;
    private String code;
    private LocalDate creationDate;
    private LocalDate buildDate;
    private Integer maxNumber;
    private Boolean isDeleted;
    private List<Food> foods;
    private List<Pig> pigs;
    private List<Export> exports;
    private Employee employee;

    public PigstyDto() {
    }

    public PigstyDto(Integer id, String code, LocalDate creationDate, LocalDate buildDate, Integer maxNumber, Boolean isDeleted, List<Food> foods, List<Pig> pigs, List<Export> exports, Employee employee) {
        this.id = id;
        this.code = code;
        this.creationDate = creationDate;
        this.buildDate = buildDate;
        this.maxNumber = maxNumber;
        this.isDeleted = isDeleted;
        this.foods = foods;
        this.pigs = pigs;
        this.exports = exports;
        this.employee = employee;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(LocalDate buildDate) {
        this.buildDate = buildDate;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Pig> getPigs() {
        return pigs;
    }

    public void setPigs(List<Pig> pigs) {
        this.pigs = pigs;
    }

    public List<Export> getExports() {
        return exports;
    }

    public void setExports(List<Export> exports) {
        this.exports = exports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}
