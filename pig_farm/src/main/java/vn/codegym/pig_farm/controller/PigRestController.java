package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.service.IPigService;

import java.util.Optional;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:4200")
public class PigRestController {

    @Autowired
    private IPigService pigService;

    /**
     * @param pageable
     * @param codeSearch
     * @param dateInSearch
     * @param statusSearch
     * @return pig, status 200
     * @function (display all Pig and search)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @GetMapping("/page")
    public ResponseEntity<Page<Pig>> listAll(@PageableDefault(5) Pageable pageable,
                                             @RequestParam Optional<String> codeSearch,
                                             @RequestParam Optional<String> dateInSearch,
                                             @RequestParam Optional<String> statusSearch) {
        {
            String code = codeSearch.orElse("");
            String dateIn = dateInSearch.orElse("");
            String status = statusSearch.orElse("");
            if (code.equals("null")) {
                code = "";
            }
            if (dateIn.equals("null")) {
                dateIn = "";
            }
            if (status.equals("null")) {
                status = "";
            }
            Page<Pig> pigs = pigService.findAllPig(pageable, code, dateIn, status);
            if (pigs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pigs, HttpStatus.OK);
        }
    }

    /**
     * @param id
     * @return
     * @function (delete Pig by Id)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<Pig> pig = pigService.findById(id);
        if (!pig.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pigService.deletePigById(pig.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
