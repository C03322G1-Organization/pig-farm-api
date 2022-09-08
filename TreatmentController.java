package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Treatment;
import vn.codegym.pig_farm.service.ITreatmentService;

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
     * @param treatment
     * @return HttpStatus.OK : Http 200: ResponseEntity
     */
    @PostMapping
    public ResponseEntity<Treatment> create(@RequestBody Treatment treatment) {
        treatmentService.save(treatment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
