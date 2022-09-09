package vn.codegym.pig_farm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.PigstyDto;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.service.IPigstyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pigsty")
public class PigstyRestController {
    @Autowired
    IPigstyService iPigstyService;

    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: create a Pigsty
     *
     * @param pigstyDto
     * @return if created pigsty return HttpStatus.CREATED(201)
     */
    @PostMapping("/createPigsty")
    public ResponseEntity<Pigsty> createPigsty(@RequestBody @Valid PigstyDto pigstyDto, BindingResult bindingResult) {

        pigstyDto.validate(pigstyDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Pigsty pigsty = new Pigsty();
        BeanUtils.copyProperties(pigstyDto, pigsty);
        this.iPigstyService.createPigsty(pigsty);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: get a Pigsty by id
     *
     * @param id
     * @return HTTP status OK : return pigsty
     * HTTP status NO_CONTENT : return pigsty=null
     * HTTP status NOT_FOUND : return pigstyId =null
     */
    @GetMapping("/getPigstyById/{id}")
    public ResponseEntity<Pigsty> getPigstyById(@PathVariable Integer id) {
        Pigsty pigsty = this.iPigstyService.getPigstyById(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (pigsty == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pigsty, HttpStatus.OK);
    }

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: edit a Pigsty
     *
     * @param pigstyDto
     * @return if edited return Http status OK
     */
    @PatchMapping("/editPigsty")
    public ResponseEntity<Pigsty> editPigsty(@Valid PigstyDto pigstyDto) {
        Pigsty pigsty = new Pigsty();
        BeanUtils.copyProperties(pigstyDto, pigsty);
        this.iPigstyService.editPigsty(pigsty);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/getList")
    public ResponseEntity<List<Pigsty>> getListPigsty() {
        List<Pigsty> pigstyList = this.iPigstyService.getListPigsty();
        if (pigstyList.isEmpty()) {
            return new ResponseEntity<>(pigstyList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pigstyList, HttpStatus.OK);
    }
}
