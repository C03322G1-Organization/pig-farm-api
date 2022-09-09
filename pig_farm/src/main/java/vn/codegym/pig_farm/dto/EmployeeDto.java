package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Export;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Mã Nhân Viên không được để trống !!")
    @Pattern(regexp = "", message = "Mã Nhân Viên phải đúng định dạng: NV-xxx !!")
    private String code;

    @NotBlank(message = "Tên Nhân Viên không được để trống !!")
    @Pattern(regexp = "", message = "Tên Nhân Viên phải viết hoa chữ cái đầu !!")
    @Size(min = 1, max = 30, message = "Tên Nhân Viên không quá 30 kí tự !!")
    private String name;

    @NotNull(message = "Ngày Sinh không được để trống !!")
    private LocalDate birthDay;

    @NotBlank(message = "Giới Tính không được để trống !!")
    private String gender;

    @NotBlank(message = "Số CMND không được để trống !!")
    @Pattern(regexp = "", message = "Số CMND phải đúng định dạng: 9 hoặc 12 chữ số !!")
    private String idCard;

    @NotBlank(message = "Ảnh không được để trống !!")
    private String image;

    private Boolean isDeleted;

    private List<Export> exports;

    private UserDto userDto;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String code, String name, LocalDate birthDay, String gender, String idCard, String image, Boolean isDeleted, List<Export> exports, UserDto userDto) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCard = idCard;
        this.image = image;
        this.isDeleted = isDeleted;
        this.exports = exports;
        this.userDto = userDto;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<Export> getExports() {
        return exports;
    }

    public void setExports(List<Export> exports) {
        this.exports = exports;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
