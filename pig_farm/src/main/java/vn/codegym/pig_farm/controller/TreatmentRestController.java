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
import vn.codegym.pig_farm.dto.projections.TreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;
import vn.codegym.pig_farm.service.ITreatmentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/treatment/v1")
@CrossOrigin
public class TreatmentRestController {
    @Autowired
    private ITreatmentService treatmentService;

    /**
     * create by TuongTK
     * date: 08/09/2022
     * create treatment
     *
     * @param treatmentDto
     * @return HttpStatus.OK : Http 200: ResponseEntity
     */
//    @PostMapping
//    public ResponseEntity<Treatment> create(@RequestBody Treatment treatment) {
//        treatmentService.save(treatment);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<List<FieldError>> createTreatment(@RequestBody @Valid vn.codegym.pig_farm.dto.TreatmentDto treatmentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        Treatment treatment = new Treatment();
        BeanUtils.copyProperties(treatmentDto, treatment);

        this.treatmentService.save(treatment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * method: get All Treatment
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<Page<TreatmentDto>> getAllTreatment(@PageableDefault(value = 5) Pageable pageable, Optional<String> keySearch) {
        String title = keySearch.orElse("");
        if (title.equals("null")) {
            title = "";
        }
        Page<TreatmentDto> treatmentPage = treatmentService.getAllTreatment(pageable, title);
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
    public ResponseEntity<?> deleteTreatment(@PathVariable int id) {
        treatmentService.deleteByIdTreatment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
