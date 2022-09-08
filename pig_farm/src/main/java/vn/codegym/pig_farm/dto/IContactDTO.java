package vn.codegym.pig_farm.dto;

import java.time.LocalDate;

public interface IContactDTO {
    Integer getId();

    String getName();

    String getContent();

    String getAddress();

    LocalDate getDate();
}
