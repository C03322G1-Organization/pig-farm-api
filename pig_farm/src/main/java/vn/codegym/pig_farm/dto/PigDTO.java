package vn.codegym.pig_farm.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.pig_farm.entity.Pigsty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class PigDTO implements Validator {
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^(ML)[0-9]{2,4}$", message = "Code phải có dạng MlXXX")
    private String code;

    @NotBlank(message = "Không được để trống.")
    private String dateIn;

    @NotNull(message = " không được bỏ trống,phải sau ngày nhập")
    private String dateOut;

    @NotBlank(message = "Không được để trống")
    private String status;

    @Length(min = 1, max = 20, message = "Tối thiểu 1 ký tự và lớn nhất 20 ký tự.")
    @NotBlank(message = "Không được để trống")
    private String weight;

    private Pigsty pigsty;

    private Boolean isDeleted;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PigDTO pigDTO = (PigDTO) target;
        Date dateIn = new Date();
        Date dateOut = new Date();
        try {
             dateIn=new SimpleDateFormat("yyyy-MM-dd").parse(pigDTO.dateIn);
        } catch (ParseException e) {
            errors.rejectValue("dateIn","","ngày nhập vào không hợp lệ");
        }
        try {
             dateOut =new SimpleDateFormat("yyyy-MM-dd").parse(pigDTO.dateOut);
        } catch (ParseException e) {
            errors.rejectValue("dateOut","","ngày nhập vào không hợp lệ");
        }
        if (dateIn.after(dateOut)){
            errors.rejectValue("dateOut","ngày xuất phải sau ngày nhập","ngày xuất phải sau ngày nhập");
        }
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

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Pigsty getPigsty() {
        return pigsty;
    }

    public void setPigsty(Pigsty pigsty) {
        this.pigsty = pigsty;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
       this.isDeleted = isDeleted ;
    }
}
