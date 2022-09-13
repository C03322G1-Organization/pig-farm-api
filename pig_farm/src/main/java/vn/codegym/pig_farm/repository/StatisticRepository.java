package vn.codegym.pig_farm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.dto.projections.IStatisticByMonthDto;
import vn.codegym.pig_farm.dto.projections.IStatisticByYearDto;
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
            "concat(month(start_date),'/', year(start_date), '-' ,company) as `time` " +
            "from `export` " +
            "where (start_date > date(:starTime)) " +
            "and (start_date < date(:endTime)) " +
            "and type_pigs like %:type% group by `time` order by `time`", nativeQuery = true)
    List<IStatisticByMonthDto> getStatisticByMonth(@Param("starTime") String starTime,
                                                   @Param("endTime") String endTime,
                                                   @Param("type") String type);

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
            "concat(year(start_date),'-', company) as `time` " +
            "from `export` " +
            "where (start_date > date(:starTime)) " +
            "and (start_date < date(:endTime)) " +
            "and type_pigs like %:type% group by `time` order by `time`", nativeQuery = true)
    List<IStatisticByYearDto> getStatisticByYear(@Param("starTime") String starTime,
                                                 @Param("endTime") String endTime,
                                                 @Param("type") String type);

    /**
     * Created by: ToanNH
     * Date created: 9/9/2022
     * function: Get value statistic by month and company from Database to return value.
     *
     * @return List<StatisticByMonth> or null
     */

    @Query(value= " select " +
            "sum(price * amount) as price, " +
            "company as company, " +
            "sum(amount) as amount, " +
            "month(start_date) as `month`, " +
            "year(start_date) as `year`, " +
            "concat(month(start_date),'/', year(start_date), '-' ,company) as `time` " +
            "from `export` " +
            "where (start_date > date(:starTime)) " +
            "and company = :company " +
            "and (start_date < date(:endTime)) " +
            "and type_pigs like %:type% group by `time` order by `time`", nativeQuery = true)
    List<IStatisticByMonthDto> getStatisticByMonthAndCompany(@Param("starTime") String starTime,
                                                             @Param("endTime") String endTime,
                                                             @Param("type") String type,
                                                             @Param("company") String company);

    /**
     * Created by: ToanNH
     * Date created: 9/9/2022
     * function: Get value statistic by year and company from Database to return value.
     *
     * @return List<StatisticByMonth> or null
     */

    @Query(value= " select " +
            "sum(price * amount) as price, " +
            "company as company, " +
            "sum(amount) as amount, " +
            "month(start_date) as `month`, " +
            "year(start_date) as `year`, " +
            "concat(year(start_date), '-' ,company) as `time` " +
            "from `export` " +
            "where (start_date > date(:starTime)) " +
            "and company like %:company% " +
            "and (start_date < date(:endTime)) " +
            "and type_pigs like %:type% group by `time` order by `time`", nativeQuery = true)
    List<IStatisticByYearDto> getStatisticByYearAndCompany(@Param("starTime") String starTime,
                                                           @Param("endTime") String endTime,
                                                           @Param("type") String type,
                                                           @Param("company") String company);


    /**
     * Created by: ToanNH
     * Date created: 13/9/2022
     * function: Get list company.
     *
     * @return List<String> or null
     */

    @Query(value = "select company from `export` group by company", nativeQuery = true)
    List<String> getListCompany();
}

