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
@CrossOrigin
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    IExportService iExportService;

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: get all export in Database
     * @param: pageable
     * @return HttpStatus.NOT_FOUND
     * @return HttpStatus.OK
     */
    @GetMapping("")
    public ResponseEntity<Page<Export>> diskPlayList(@PageableDefault(value = 5) Pageable pageable) {
        Page<Export> listAll = iExportService.listAll(pageable);
        if (listAll.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listAll, HttpStatus.OK);
    }

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: delete export by Id
     * @param: id
     * @return HttpStatus.NOT_FOUND
     * @return HttpStatus.OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Export> deleteExport(@PathVariable("id") Integer id) {

        Export export = iExportService.findById(id);
        if (export == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iExportService.delete(export);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: search export by code_export and company
     * @param: codeExport, company, pageable
     * @return HttpStatus.NOT_FOUND
     * @return HttpStatus.OK
     */
    @GetMapping("/search")
    public ResponseEntity<Page<Export>> searchExport(
            @RequestParam ("searchByCodeExport") String codeExport,
            @RequestParam ("searchByCompany") String company,
            @PageableDefault(value = 5) Pageable pageable){
        if(codeExport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<Export> listSearch = iExportService.searchExport(codeExport, company, pageable);
        return new ResponseEntity<>(listSearch,HttpStatus.OK);
    }
}
