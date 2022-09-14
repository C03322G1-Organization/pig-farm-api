package vn.codegym.pig_farm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.IVaccinationDto;
import vn.codegym.pig_farm.dto.VaccinationDto;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.entity.Vaccination;
import vn.codegym.pig_farm.service.IVaccinationService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vaccination")
@CrossOrigin
public class VaccinationRestController {
    @Autowired
    private IVaccinationService iVaccinationService;

//    @GetMapping("/list")
//    public ResponseEntity<List<Vaccination>> findAll() {
//        List<Vaccination> vaccinationList = iVaccinationService.findAll();
//        if (vaccinationList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(vaccinationList, HttpStatus.OK);
//    }

    @PostMapping(value = "/create")
    public ResponseEntity<FieldError> createVaccination(@RequestBody @Valid VaccinationDto vaccinationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_FOUND);
        }
        Vaccination vaccination = new Vaccination();
        BeanUtils.copyProperties(vaccinationDto, vaccination);
        Pigsty pigsty = new Pigsty();
        pigsty.setId(vaccinationDto.getPigsty().getId());
        vaccination.setPigsty(pigsty);
        this.iVaccinationService.saveVaccination(vaccination);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<IVaccinationDto>> getList(@PageableDefault(5) Pageable pageable, @RequestParam Optional<String> name) {
        /**
         * @function (Display all Vaccination and search)
         * @creator TamLT
         * @date-create 08/09/2022
         * @param pageable
         * @param name
         * @return List Vaccination, HttpStatus.OK
         * @return HttpStatus.NOTFOUND
         */

        String nameSearch = name.orElse("");
        if (nameSearch.equals("null")) {
            nameSearch = "";
        }

        Page<IVaccinationDto> vaccinationList = iVaccinationService.getAll(pageable, nameSearch);
        if (vaccinationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vaccinationList, HttpStatus.OK);
    }


    /**
     * @return List Vaccination, HttpStatus.OK
     * @function (Delete Vaccination)
     * @creator TamLT
     * @date-create 08/09/2022
     */

//    @PostMapping("/delete")
//    public ResponseEntity<?> delete(@RequestBody Map<String, Integer[]> ids) {
//        vaccinationService.delete(ids.get("id"));
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@RequestBody Integer id) {
        iVaccinationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
