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
    @PostMapping
    public ResponseEntity<List<FieldError>> createTreatment(@RequestBody @Valid TreatmentDto treatmentDto,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        Treatment treatment = new Treatment();
        BeanUtils.copyProperties(treatmentDto, treatment);

        this.treatmentService.save(treatment);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
