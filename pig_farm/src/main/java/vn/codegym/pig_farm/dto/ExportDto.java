package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.Pigsty;

import java.time.LocalDate;

public class ExportDto {

    private String codeExport;
    private String company;
    private LocalDate startDate;
    private Integer amount;
    private Double kilogram;
    private Double price;
    private String typePigs;
    private Boolean isDeleted;
    private Pigsty pigsty;
    private Employee employee;

}
