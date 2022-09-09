package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.Pigsty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ExportDto {
    /**
     * Created by: HoaL
     * Date created: 09/09/2022
     * Function: ExportDto
     * return exportDto
     */

    @Size(min = 1, max = 50, message = "không quá 1-50 từ và không để trống")
    @NotBlank
    private String codeExport;

    @Size(min = 1, max = 50, message = "không quá 1-50 từ và không để trống")
    @NotBlank
    private String company;

    @Min(value = 1, message = "Giá không âm và không để trống")
    private Integer amount;

    @Min(value = 1, message = "Gía không âm và không để trống")
    private Double kilogram;

    @Min(value = 1, message = "Gía không âm và không để trống")
    private Double price;

    @NotBlank(message = "Vui lòng nhập loại")
    private String typePigs;

    private Boolean isDeleted;

    private PigstyDto pigstyDto;

    private EmployeeDto employeeDto;

    public ExportDto() {
    }

    public String getCodeExport() {
        return codeExport;
    }

    public void setCodeExport(String codeExport) {
        this.codeExport = codeExport;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getKilogram() {
        return kilogram;
    }

    public void setKilogram(Double kilogram) {
        this.kilogram = kilogram;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTypePigs() {
        return typePigs;
    }

    public void setTypePigs(String typePigs) {
        this.typePigs = typePigs;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public PigstyDto getPigstyDto() {
        return pigstyDto;
    }

    public void setPigstyDto(PigstyDto pigstyDto) {
        this.pigstyDto = pigstyDto;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }
}
