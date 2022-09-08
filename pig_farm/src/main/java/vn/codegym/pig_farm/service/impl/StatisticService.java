package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.StatisticByMonth;
import vn.codegym.pig_farm.dto.StatisticByYear;
import vn.codegym.pig_farm.repository.StatisticRepository;
import vn.codegym.pig_farm.service.IStatisticService;

import java.util.List;

@Service
public class StatisticService implements IStatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by month from Database to return value.
     *
     * @return
     */

    @Override
    public List<StatisticByMonth> getStatisticByMonth(String startDate, String endDate, Integer type) {
        return statisticRepository.getStatisticByMonth(startDate, endDate, type);
    }

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by year from Database to return value.
     *
     * @return
     */

    @Override
    public List<StatisticByYear> getStatisticByYear(String startDate, String endDate, Integer type) {
        return statisticRepository.getStatisticByYear(startDate, endDate, type);
    }
}
