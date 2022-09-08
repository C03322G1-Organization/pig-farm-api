package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.ITreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;
import vn.codegym.pig_farm.service.ITreatmentService;
import vn.codegym.pig_farm.service.impl.TreatmentService;

import java.util.List;

@RestController
@RequestMapping("/api/treatment/v1")
@CrossOrigin(origins = "*")
public class TreatmentController {
    @Autowired
    private ITreatmentService treatmentService;

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * method: get All Treatment
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ITreatmentDto>> getAllTreatment() {
        List<ITreatmentDto> treatmentList = treatmentService.getAllTreatment();
        if (treatmentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(treatmentList, HttpStatus.OK);
    }

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * method: delete Treatment
     * @param id
     * @return
     */
    @PutMapping(value ="/{id}")
    public ResponseEntity<ITreatmentDto> deleteTreatment(@PathVariable int id) {
        treatmentService.deleteByIdTreatment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
