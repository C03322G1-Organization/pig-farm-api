package vn.codegym.pig_farm.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StorageDto {
    private Integer id;

    @NotBlank(message = "Không được để trống")
    @Length(min = 1, max = 30, message = "Tối thiểu 1 ký tự và lớn nhất 30 ký tự.")
    private String foodType;

    @NotNull(message = "Không được để trống")
    @Min(value = 1, message = "Số phải lớn hơn 0")
    private Integer amount;

    @NotBlank(message = "Không được để trống")
    @Length(min = 1, max = 15, message = "Tối thiểu 1 ký tự và lớn nhất 30 ký tự.")
    private String unit;

    @NotNull(message = "Không được để trống")
    private LocalDate date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

//    public String getAmount() {
//        return amount;
//    }
//
//    public void setAmount(String amount) {
//        this.amount = amount;
//    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
