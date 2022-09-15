package vn.codegym.pig_farm.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.pig_farm.entity.Pigsty;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class VaccinationDto implements Validator {
    private Integer id;
    @NotNull
    private LocalDate date;
    @NotNull
    @Min(value = 1)
    @Max(value = 20)
    private Integer amount;
    @NotBlank
    private String vaccineType;
    @NotBlank
    @Size(min = 5, max = 30)
    @Pattern(regexp = "(^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$)")
    private String vaccinatedPerson;
    @Size(max = 255)
    private String note;
    private Boolean isDeleted;

   private Pigsty pigstyCode;
    public VaccinationDto() {
    }

    public VaccinationDto(Integer id, @NotNull LocalDate date, @NotNull @Min(value = 1) @Max(value = 20) Integer amount, @NotBlank String vaccineType, @NotBlank @Size(min = 5, max = 30) @Pattern(regexp = "(^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$)") String vaccinatedPerson, @Size(max = 255) String note, Boolean isDeleted, Pigsty pigstyCode) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.vaccineType = vaccineType;
        this.vaccinatedPerson = vaccinatedPerson;
        this.note = note;
        this.isDeleted = isDeleted;
        this.pigstyCode = pigstyCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getVaccinatedPerson() {
        return vaccinatedPerson;
    }

    public void setVaccinatedPerson(String vaccinatedPerson) {
        this.vaccinatedPerson = vaccinatedPerson;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

//    public Pigsty getPigsty() {
//        return pigsty;
//    }
//
//    public void setPigsty(Pigsty pigsty) {
//        this.pigsty = pigsty;
//    }

    public Pigsty getPigstyCode() {
        return pigstyCode;
    }

    public void setPigstyCode(Pigsty pigstyCode) {
        this.pigstyCode = pigstyCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
