package vn.codegym.pig_farm.dto.projections;

public interface IStatisticByYearDto {
    Long getPrice();

    String getCompany();

    Long getAmount();

    String getYear();

    String getTime();
}
