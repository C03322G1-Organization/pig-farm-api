package vn.codegym.pig_farm.dto;

import java.time.LocalDate;

public interface IExportDto {
    String getCompany();
    LocalDate getStartDate();
    String getCodeExport();
    Integer getAmount();
    Double getKilogram();
    Double getPrice();
    Boolean getIsDeleted();
    String getIdEmployee();
    String getNameEmployee();
}
