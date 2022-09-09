package vn.codegym.pig_farm.dto;

import java.time.LocalDate;

public interface IVaccinationDto {
    Integer getId();

    LocalDate getDate();

    String getPigstyCode();

    String getVaccinatedPerson();

    String getVaccineType();

    Integer getAmount();
}
