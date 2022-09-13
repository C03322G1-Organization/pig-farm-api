package vn.codegym.pig_farm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.TreatmentDto;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.entity.Treatment;
import vn.codegym.pig_farm.service.ITreatmentService;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/treatment/v1")
public class TreatmentController {
    @Autowired
    private ITreatmentService treatmentService;

    /**
     * create by TuongTK
     * date: 08/09/2022
     * create treatment
     * @param treatmentDto
     * @return HttpStatus.OK : Http 200: ResponseEntity
     */
//    @PostMapping
//    public ResponseEntity<Treatment> create(@RequestBody Treatment treatment) {
//        treatmentService.save(treatment);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createTreatment(@RequestBody @Valid TreatmentDto treatmentDto,
                                                   BindingResult bindingResult){

//        if (!validateDate(treatmentDto.getDate())) {
//            return new ResponseEntity<>(bindingResult.getFieldErrors(),
//                    HttpStatus.NOT_ACCEPTABLE);
//        }
//
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getFieldErrors(),
//                    HttpStatus.NO_CONTENT);
//        }

        System.out.println(treatmentDto);

        Treatment treatment = new Treatment();
        BeanUtils.copyProperties(treatmentDto, treatment);

        this.treatmentService.save(treatment);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    public static boolean validateDate(String dateval){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        boolean valid = false;
//        try {
//            // why 2008-02-2x, 20-11-02, 12012-04-05 are valid date?
//            sdf.parse(dateval);
//            // strict mode - check 30 or 31 days, leap year
//            sdf.setLenient(false);
//            valid = true;
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//            valid = false;
//        }
//
//        return valid;
//    }


}
