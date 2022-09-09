package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.IExportDto;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.service.IExportService;

import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/export")
public class ExportRestController {

    @Autowired
    IExportService iExportService;

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: get all export in Database
     *
     * @return HttpStatus.NOT_FOUND
     * @return HttpStatus.OK
     * @param: pageable
     */
//    @GetMapping("")
//    public ResponseEntity<Page<IExportDto>> getListExport(@PageableDefault(value = 5) Pageable pageable) {
//        Page<IExportDto> listAll = iExportService.listAll(pageable);
//        if (listAll.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(listAll, HttpStatus.OK);
//    }

    @GetMapping("/page")
    public ResponseEntity<Page<IExportDto>> getListExport(@PageableDefault(value = 5) Pageable pageable,
                                                        Optional<String> codeExport,
                                                        Optional<String> company) {
        String code = codeExport.orElse("");
        String company1 = company.orElse("");
        if (code.equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        if (company1.equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<IExportDto> contactPage = iExportService.listAll(pageable, code, company1);
        if (contactPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contactPage,HttpStatus.OK);

    }

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: delete export by Id
     *
     * @return HttpStatus.NOT_FOUND
     * @return HttpStatus.OK
     * @param: id
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
     *
     * @return HttpStatus.NOT_FOUND
     * @return HttpStatus.OK
     * @param: codeExport, company, pageable
     */
//    @GetMapping("/search")
//    public ResponseEntity<Page<Export>> searchExport(
//            @RequestParam Optional<String> codeExport,
//            @RequestParam Optional<String> company,
//            @PageableDefault(value = 5) Pageable pageable) {
//        {
//            String code = codeExport.orElse("");
//            String company1 = company.orElse("");
//            if (code.equals("null")) {
//                code = "";
//            }
//            if (company1.equals("null")) {
//                company1 = "";
//            }
//            Page<Export> exports = iExportService.searchExport(code, company1, pageable);
//            if (exports.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(exports, HttpStatus.OK);
//        }
//    }
}
