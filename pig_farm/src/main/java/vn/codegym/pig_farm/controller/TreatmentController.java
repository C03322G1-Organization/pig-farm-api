package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.ITreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;
import vn.codegym.pig_farm.service.ITreatmentService;

import java.util.List;
import java.util.Optional;

import static java.lang.Float.NaN;
import static java.lang.Float.isNaN;

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
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<Page<ITreatmentDto>> getAllTreatment(@PageableDefault(value = 5) Pageable pageable,
                                                               Optional<String> keySearch) {
        String title = keySearch.orElse("");
        if (title.equals("null")) {
            title = "";
        }
        Page<ITreatmentDto> treatmentPage = treatmentService.getAllTreatment(pageable, title);
        if (treatmentPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(treatmentPage, HttpStatus.OK);
    }

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * method: delete Treatment
     *
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable String id) {
        try {
            Integer.parseInt(id);
            Treatment treatment = treatmentService.findById(Integer.parseInt(id));
            if (treatment == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            treatmentService.deleteByIdTreatment(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (final Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
