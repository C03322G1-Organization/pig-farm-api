package vn.codegym.pig_farm.dto;

import java.time.LocalDate;

public class PigstyDto {
    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: PigstyDto
     * return pigstyDto
     */
    private Integer id;
    private String code;
    private LocalDate creationDate;
    private LocalDate buildDate;
    private Integer maxNumber;

    public PigstyDto() {
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
}
