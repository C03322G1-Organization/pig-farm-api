package vn.codegym.pig_farm.dto;

import javax.validation.constraints.*;

/**
 * create class TreatmentDto
 * @author TuongTK
 * @Date 09/09/2022
 */
public class TreatmentDto {
    private Integer id;


    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Khong dung dinh dang")
    private String date;

    @NotBlank(message = "khong duoc de trong")
    @Size(min = 10, max = 50)
    private String doctor;


    @NotBlank(message = "khong duoc de trong")
    @Size(min = 4, max = 50)
    private String diseases;


    @NotBlank(message = "khong duoc de trong")
    @Size(min = 3, max = 50)
    private String medicine;

    @NotNull
    @Min(1)
    private Integer amount;


    private Boolean isDeleted;
    @NotNull
    private PigDto pigDto;

    public TreatmentDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public PigDto getPigDto() {
        return pigDto;
    }

    public void setPigDto(PigDto pigDto) {
        this.pigDto = pigDto;
    }
}
