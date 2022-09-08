package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.dto.StatisticByMonth;
import vn.codegym.pig_farm.dto.StatisticByYear;

import java.util.List;

public interface IStatisticService {

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by month from Database to return value.
     *
     * @return
     */

    List<StatisticByMonth> getStatisticByMonth(String startDate, String endDate, Integer type);

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by year from Database to return value.
     *
     * @return
     */

    List<StatisticByYear> getStatisticByYear(String startDate, String endDate, Integer type);
}
