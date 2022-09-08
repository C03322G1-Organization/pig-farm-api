package vn.codegym.pig_farm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.dto.StatisticByMonth;
import vn.codegym.pig_farm.dto.StatisticByYear;
import vn.codegym.pig_farm.entity.Export;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StatisticRepository extends JpaRepository<Export,Integer> {

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by month from Database to return value.
     *
     * @return List<StatisticByMonth> or null
     */

    @Query(value= " select " +
            "sum(price * amount) as price, " +
            "company as company, " +
            "sum(amount) as amount, " +
            "month(start_date) as `month`, " +
            "year(start_date) as `year`, " +
            "concat(month(start_date),'/', year(start_date)) as `time` " +
            "from `export` " +
            "where (start_date > date(:starTime)) " +
            "and (start_date < date(:endTime)) " +
            "and type_pigs = :type group by `time`", nativeQuery = true)
    List<StatisticByMonth> getStatisticByMonth(@Param("starTime") String starTime, @Param("endTime") String endTime,  @Param("type") Integer type);

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by year from Database to return value.
     *
     * @return List<StatisticByYear> or null
     */

    @Query(value = "select " +
            "sum(price * amount) as price, " +
            "company as company, " +
            "sum(amount) as amount, " +
            "year(start_date) as `year`, " +
            "concat(company,'/', year(start_date)) as `groupD` " +
            "from `export` " +
            "where (start_date > date(:starTime)) " +
            "and (start_date < date(:endTime)) " +
            "and type_pigs =:type group by groupD", nativeQuery = true)
    List<StatisticByYear> getStatisticByYear(@Param("starTime") String starTime, @Param("endTime") String endTime, @Param("type") Integer type);
}

