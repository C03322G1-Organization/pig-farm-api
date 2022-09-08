package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Pigsty;

import java.time.LocalDate;

public interface IVaccinationDto {
    LocalDate getDate();
    Pigsty getPigsty();
    String getVaccinatedPerson();
    String getVaccineType();
    Integer getAmount();
}
