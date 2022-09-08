package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
     */

    @PostMapping("/create")
    private ResponseEntity<Export> create(@RequestBody Export export) {
        iExportService.create(export);
        return new ResponseEntity<>(export, HttpStatus.CREATED);
    }

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: update item in Export
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Export> update(@PathVariable int id, @RequestBody Export export) {
        Export export1 = iExportService.findById(id);
        if (export1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        export1.setPigsty(export.getPigsty());
        export1.setEmployee(export.getEmployee());
        export1.setCodeExport(export.getCodeExport());
        export1.setCompany(export.getCompany());
        export1.setStartDate(export.getStartDate());
        export1.setAmount(export.getAmount());
        export1.setKilogram(export.getKilogram());
        export1.setPrice(export.getPrice());
        export1.setTypePigs(export.getTypePigs());
        iExportService.update(export1);
        return new ResponseEntity<>(export1, HttpStatus.OK);
    }
}
