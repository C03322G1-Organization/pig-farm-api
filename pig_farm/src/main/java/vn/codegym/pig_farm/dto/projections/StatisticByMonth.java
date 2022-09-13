package vn.codegym.pig_farm.dto.projections;


public interface StatisticByMonth {
    Long getPrice();

    String getCompany();

    Long getAmount();

    String getMonth();

    String getYear();

    String getTime();
}
