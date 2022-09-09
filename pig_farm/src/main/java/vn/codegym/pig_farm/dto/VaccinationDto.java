package vn.codegym.pig_farm.dto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.pig_farm.entity.Pigsty;
import java.time.LocalDate;

public class VaccinationDto implements Validator {
    private Integer id;
    private LocalDate date;
    private Integer amount;
    private String vaccineType;
    private String vaccinatedPerson;
    private String note;
    private Boolean isDeleted;
    private Pigsty pigsty;

    public VaccinationDto() {
    }

    public VaccinationDto(Integer id, LocalDate date, Integer amount, String vaccineType, String vaccinatedPerson, String note, Boolean isDeleted, Pigsty pigsty) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.vaccineType = vaccineType;
        this.vaccinatedPerson = vaccinatedPerson;
        this.note = note;
        this.isDeleted = isDeleted;
        this.pigsty = pigsty;
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

    public Pigsty getPigsty() {
        return pigsty;
    }

    public void setPigsty(Pigsty pigsty) {
        this.pigsty = pigsty;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
