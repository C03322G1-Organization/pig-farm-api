package vn.codegym.pig_farm.dto;

import java.time.LocalDate;

/**
 * Create by: DongLHP
 * Date create: 08/09/2022
 * Function: Create Interface ExportDto
 */
public interface IExportDto {
    Integer getId();
    String getCompany();
    LocalDate getSaleDate();
    String getCodeExport();
    Integer getAmount();
    Double getKilogram();
    Double getPrice();
    String getTypePigs();
    Boolean getIsDeleted();
    String getIdEmployee();
    String getCodeEmployee();
    String getNameEmployee();
}
