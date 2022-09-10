package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.Pigsty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Create by: DongLHP
 * Date create: 08/09/2022
 * Function: Create ExportDto
 */
public class ExportDto {
    private LocalDate startDate;
    private Pigsty pigsty;
    private Employee employee;

    public ExportDto(String company, LocalDate startDate, String codeExport, Integer amount, Double kilogram, Double price, String typePigs, Boolean isDeleted, Pigsty pigsty, Employee employee) {
        this.company = company;
        this.startDate = startDate;
        this.codeExport = codeExport;
        this.amount = amount;
        this.kilogram = kilogram;
        this.price = price;
        this.typePigs = typePigs;
        this.isDeleted = isDeleted;
        this.pigsty = pigsty;
        this.employee = employee;
    }

    public String getTypePigs() {
        return typePigs;
    }

    public void setTypePigs(String typePigs) {
        this.typePigs = typePigs;
    }

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

    @Min(value = 1, message = "Gía không âm ")
    @Max(value = 99000)
    private Double price;

    @NotBlank(message = "Vui lòng nhập loại")
    @Size(min = 1, max = 50, message = "không quá 1-50 từ")
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


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
