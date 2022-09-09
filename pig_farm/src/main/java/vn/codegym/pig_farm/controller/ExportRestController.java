package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.ExportDto;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.service.IExportService;

@RestController
@RequestMapping("/pigFarm")
public class ExportRestController {
    @Autowired
    private IExportService iExportService;

    /**
     * Created by : HoaL
     * Date create : 08/09/2022
     * Function : create item in Export
     * return exportDto
     */

    @PostMapping("/create")
    private ResponseEntity<?> create(@Validated @RequestBody ExportDto exportDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        iExportService.create(exportDto);
        return new ResponseEntity<>(exportDto, HttpStatus.CREATED);
    }

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: update item in Export
     * return export1
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Export> update(@Validated @PathVariable int id, @RequestBody Export export,
                                         BindingResult bindingResult) {
        Export export1 = iExportService.findById(id);
        if (export1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        export1.setPigsty(export.getPigsty());
        export1.setEmployee(export.getEmployee());
        export1.setCodeExport(export.getCodeExport());
        export1.setCompany(export.getCompany());
        export1.setPrice(export.getPrice());
        export1.setTypePigs(export.getTypePigs());
        iExportService.update(export1);
        return new ResponseEntity<>(export1, HttpStatus.OK);
    }
}
