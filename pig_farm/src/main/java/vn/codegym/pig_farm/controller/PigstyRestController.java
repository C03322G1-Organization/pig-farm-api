package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.service.IPigstyService;

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
     * @param pigsty
     * @return
     * if created pigsty return HttpStatus.CREATED(201)
     *
     */
    @PostMapping("/createPigsty")
    public ResponseEntity<Pigsty> createPigsty(@RequestBody Pigsty pigsty) {
        this.iPigstyService.createPigsty(pigsty);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
