package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.service.IPigstyService;

@RestController
@RequestMapping("api/pigsty")
@CrossOrigin
public class PigstyRestController {
    @Autowired
    private IPigstyService iPigstyService;
    @GetMapping("/list")
    public ResponseEntity<Page<Pigsty>> findAll(@RequestParam(value = "search", defaultValue = "") String search, @PageableDefault(5) Pageable pageable) {
        return new ResponseEntity<>(iPigstyService.findAll(pageable, search), HttpStatus.OK);
    }
}
