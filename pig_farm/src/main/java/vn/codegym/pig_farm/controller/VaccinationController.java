package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Vaccination;
import vn.codegym.pig_farm.service.IVaccinationService;

import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/vaccination")
public class VaccinationController {
    @Autowired
    private IVaccinationService vaccinationService;

    @GetMapping("/list")
    public ResponseEntity<Page<Vaccination>> getList(@PageableDefault(5) Pageable pageable,
                                                     @RequestParam Optional<String> name) {
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

        Page<Vaccination> vaccinationList = vaccinationService.getAll(pageable, nameSearch);
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

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Map<String, Integer[]> ids) {
        vaccinationService.delete(ids.get("id"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
