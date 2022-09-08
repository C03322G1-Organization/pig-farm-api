package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Vaccination;
import vn.codegym.pig_farm.service.IVaccinationService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vaccine")
@CrossOrigin
public class VaccinationRestController {
    @Autowired
    private IVaccinationService iVaccinationService;

//    @GetMapping("/list")
//    public ResponseEntity<List<Vaccination>> findAll(){
//        List<Vaccination> vaccinationList=iVaccinationService.findAll();
//        if(vaccinationList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(vaccinationList, HttpStatus.OK);
//    }

    @PostMapping("/create")
    public ResponseEntity<Vaccination> createVaccination(Vaccination vaccination) {
        iVaccinationService.saveVaccination(vaccination);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
