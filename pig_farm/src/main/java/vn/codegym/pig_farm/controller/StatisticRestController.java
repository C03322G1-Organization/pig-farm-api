package vn.codegym.pig_farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.projections.IStatisticByMonthDto;
import vn.codegym.pig_farm.dto.projections.IStatisticByYearDto;
import vn.codegym.pig_farm.service.IStatisticService;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/statistic")
public class StatisticRestController {

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
    public ResponseEntity<List<IStatisticByMonthDto>> getStatisticByMonth(@PathVariable String startTime,
                                                                          @PathVariable String endTime,
                                                                          @PathVariable String type) {
        if (type.equals("all")){
            type = "";
        }
        try {
            if (LocalDate.parse(startTime).plusDays(1).isAfter(LocalDate.parse(endTime)) && !type.equals("0") && !type.equals("1") && !type.equals("")) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IStatisticByMonthDto> IStatisticByMonthDtoList = statisticService.getStatisticByMonth(startTime, endTime, type);
        if (IStatisticByMonthDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(IStatisticByMonthDtoList, HttpStatus.OK);
    }

    /**
     * Created by: ToanNH
     * Date created: 8/9/2022
     * function: Get value statistic by year from Database to return value.
     *
     * @return BAD_REQUEST, NO_CONTENT, OK
     */

    @GetMapping("by-year/{startTime}/{endTime}/{type}")
    public ResponseEntity<List<IStatisticByYearDto>> getStatisticByYear(@PathVariable String startTime,
                                                                        @PathVariable String endTime,
                                                                        @PathVariable String type) {
        if (type.equals("all")){
            type = "";
        }
        try {
            if (LocalDate.parse(startTime).plusDays(1).isAfter(LocalDate.parse(endTime)) && !type.equals("0") && !type.equals("1") && !type.equals("")) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IStatisticByYearDto> statisticByMonthList = statisticService.getStatisticByYear(startTime, endTime, type);
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

    @GetMapping("by-month-company/{startTime}/{endTime}/{type}/{company}")
    public ResponseEntity<List<IStatisticByMonthDto>> getStatisticByMonthAndCompany(@PathVariable String startTime,
                                                                                    @PathVariable String endTime,
                                                                                    @PathVariable String type,
                                                                                    @PathVariable String company) {
        if (type.equals("all")){ type = ""; }
        try {
            if (LocalDate.parse(startTime).plusDays(1).isAfter(LocalDate.parse(endTime)) && company == null && company.equals("") && !type.equals("0") && !type.equals("1") && !type.equals("")) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IStatisticByMonthDto> statisticByYearList = statisticService.getStatisticByMonthAndCompany(startTime, endTime, type, company);
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

    @GetMapping("by-year-company/{startTime}/{endTime}/{type}/{company}")
    public ResponseEntity<List<IStatisticByYearDto>> getStatisticByYearAndCompany(@PathVariable String startTime,
                                                                                  @PathVariable String endTime,
                                                                                  @PathVariable String type,
                                                                                  @PathVariable String company) {
        if (type.equals("all")){ type = ""; }
        try {
            if (LocalDate.parse(startTime).plusDays(1).isAfter(LocalDate.parse(endTime)) && company == null && company.equals("") && !type.equals("0") && !type.equals("1") && !type.equals("")) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IStatisticByYearDto> IStatisticByYearDtoList = statisticService.getStatisticByYearAndCompany(startTime, endTime, type, company);
        if (IStatisticByYearDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(IStatisticByYearDtoList, HttpStatus.OK);
    }

    /**
     * Created by: ToanNH
     * Date created: 13/9/2022
     * function: Get list company.
     *
     * @return BAD_REQUEST, NO_CONTENT, OK
     */

    @GetMapping("listCompany")
    public ResponseEntity<List<String>> getListCompany( ) {
        List<String> listCompany = statisticService.getListCompany();
        return new ResponseEntity<>(listCompany, HttpStatus.OK);
    }
}
