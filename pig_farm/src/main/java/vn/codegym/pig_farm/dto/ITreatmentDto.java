package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Pig;

import java.time.LocalDate;
/**
 * Create by ThuanT
 * Date create: 08/09/2022
 * interface: ITreatmentDto
 * @return
 */
public interface ITreatmentDto {
    Integer getId();
    Integer getAmount();
    LocalDate getDate();
    String getDiseases();
    String getDoctor();
    String getMedicine();
    String getPigCode();
    String getPigstyCode();



}
