package vn.codegym.pig_farm.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.pig_farm.entity.Placement;

import java.time.LocalDate;
import java.util.List;


public class AdvertisementDto implements Validator {
    private Integer id;
    private String title;
    private String image;
    private LocalDate submittedDate;
    private String timeExistence;
    private List<Placement> placements;
    private Boolean isDeleted;

    public AdvertisementDto() {
    }

    public AdvertisementDto(Integer id, String title, String image, LocalDate submittedDate, String timeExistence, List<Placement> placements, Boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.submittedDate = submittedDate;
        this.timeExistence = timeExistence;
        this.placements = placements;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDate submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getTimeExistence() {
        return timeExistence;
    }

    public void setTimeExistence(String timeExistence) {
        this.timeExistence = timeExistence;
    }

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
