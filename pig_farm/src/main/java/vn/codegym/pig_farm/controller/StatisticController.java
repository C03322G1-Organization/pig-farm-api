package vn.codegym.pig_farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.StatisticByMonth;
import vn.codegym.pig_farm.dto.StatisticByYear;
import vn.codegym.pig_farm.service.IStatisticService;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private IStatisticService statisticService;

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by month from Database to return value.
     *
     * @return BAD_REQUEST, NO_CONTENT, OK
     */

    @GetMapping("by-month/{startTime}/{endTime}/{type}")
    public ResponseEntity<List<StatisticByMonth>> getStatisticByMonth(@PathVariable String startTime,
                                                                      @PathVariable String endTime,
                                                                      @PathVariable Integer type) {
        try {
            if (LocalDate.parse(startTime).plusDays(1).isAfter(LocalDate.parse(endTime)) || type != 0 && type != 1) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<StatisticByMonth> statisticByMonthList = statisticService.getStatisticByMonth(startTime, endTime, type);
        if (statisticByMonthList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statisticByMonthList, HttpStatus.OK);
    }

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by year from Database to return value.
     *
     * @return BAD_REQUEST, NO_CONTENT, OK
     */

    @GetMapping("by-year/{startTime}/{endTime}/{type}")
    public ResponseEntity<List<StatisticByYear>> getStatisticByYear(@PathVariable String startTime,
                                                                    @PathVariable String endTime,
                                                                    @PathVariable Integer type) {
        try {
            if (LocalDate.parse(startTime).plusDays(1).isAfter(LocalDate.parse(endTime)) || type != 0 && type != 1) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<StatisticByYear> statisticByMonthList = statisticService.getStatisticByYear(startTime, endTime, type);
        if (statisticByMonthList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statisticByMonthList, HttpStatus.OK);
    }

    /**
     * Created by: ToanNH
     * Date created: 9/9/2022
     * function: Get value statistic by month and company from Database to return value.
     *
     * @return BAD_REQUEST, NO_CONTENT, OK
     */

    @GetMapping("by-month/{startTime}/{endTime}/{type}/{company}")
    public ResponseEntity<List<StatisticByMonth>> getStatisticByMonthAndCompany(@PathVariable String startTime,
                                                                                @PathVariable String endTime,
                                                                                @PathVariable Integer type,
                                                                                @PathVariable String company) {
        try {
            if (LocalDate.parse(startTime).plusDays(1).isAfter(LocalDate.parse(endTime)) || company == null || company.equals("") || type != 0 && type != 1) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<StatisticByMonth> statisticByYearList = statisticService.getStatisticByMonthAndCompany(startTime, endTime, type, company);
        if (statisticByYearList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statisticByYearList, HttpStatus.OK);
    }

    /**
     * Created by: ToanNH
     * Date created: 9/9/2022
     * function: Get value statistic by year and company from Database to return value.
     *
     * @return BAD_REQUEST, NO_CONTENT, OK
     */

    @GetMapping("by-year/{startTime}/{endTime}/{type}/{company}")
    public ResponseEntity<List<StatisticByYear>> getStatisticByYearAndCompany(@PathVariable String startTime,
                                                                              @PathVariable String endTime,
                                                                              @PathVariable Integer type,
                                                                              @PathVariable String company) {
        try {
            if (LocalDate.parse(startTime).plusDays(1).isAfter(LocalDate.parse(endTime)) || company == null || company.equals("") || type != 0 && type != 1) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<StatisticByYear> statisticByYearList = statisticService.getStatisticByYearAndCompany(startTime, endTime, type, company);
        if (statisticByYearList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statisticByYearList, HttpStatus.OK);
    }
}
