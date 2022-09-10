package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.Pigsty;

import java.time.LocalDate;

public class ExportDto {
    private String company;
    private LocalDate startDate;
    private String codeExport;
    private Integer amount;
    private Double kilogram;
    private Double price;
    private String typePigs;
    private Boolean isDeleted;
    private Pigsty pigsty;
    private Employee employee;

    public ExportDto() {
    }

    public ExportDto(String company, LocalDate startDate, String codeExport,
                     Integer amount, Double kilogram, Double price, String typePigs,
                     Boolean isDeleted, Pigsty pigsty, Employee employee) {
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

    public String getCodeExport() {
        return codeExport;
    }

    public void setCodeExport(String codeExport) {
        this.codeExport = codeExport;
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
}
