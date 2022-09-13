package vn.codegym.pig_farm.dto.projections;

import java.time.LocalDate;

public interface VaccinationDto {
    Integer getId();

    LocalDate getDate();

    String getPigstyCode();

    String getVaccinatedPerson();

    String getVaccineType();

    Integer getAmount();
}
