package vn.codegym.pig_farm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.VaccinationDto;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.entity.Vaccination;
import vn.codegym.pig_farm.service.IVaccinationService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vaccine")
@CrossOrigin
public class VaccinationRestController {
    @Autowired
    private IVaccinationService iVaccinationService;

    @GetMapping("/list")
    public ResponseEntity<List<Vaccination>> findAll() {
        List<Vaccination> vaccinationList = iVaccinationService.findAll();
        if (vaccinationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vaccinationList, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<FieldError> createVaccination(@RequestBody @Valid  VaccinationDto vaccinationDto,
                                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(),
                    HttpStatus.NOT_FOUND);
        }
        Vaccination vaccination = new Vaccination();
        BeanUtils.copyProperties(vaccinationDto, vaccination);
        Pigsty pigsty = new Pigsty();
        pigsty.setId(vaccinationDto.getPigsty().getId());
        vaccination.setPigsty(pigsty);
        this.iVaccinationService.saveVaccination(vaccination);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
