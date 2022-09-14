package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.projections.ExportDto;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.repository.ExportRepository;
import vn.codegym.pig_farm.service.IExportService;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/export")
public class ExportRestController {

    @Autowired
    IExportService iExportService;

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: get all and search export in Database
     *
     * @return HttpStatus.NOT_FOUND
     * @return HttpStatus.OK
     * @param: pageable
     */
    @GetMapping("/page")
    public ResponseEntity<Page<ExportDto>> getListExport(@PageableDefault(value = 5) Pageable pageable,
                                                          Optional<String> codeExport,
                                                          Optional<String> company,
                                                          Optional<String> nameEmployee) {
        String code = codeExport.orElse("");
        String company1 = company.orElse("");
        String nameEmployee1 = nameEmployee.orElse("");
        if (code.equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        if (company1.equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (nameEmployee1.equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<ExportDto> contactPage = iExportService.listAll(pageable, code, company1,nameEmployee1);

        if (contactPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contactPage, HttpStatus.OK);

    }

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: delete export by Id
     *
     * @return HttpStatus.NOT_FOUND
     * @return HttpStatus.OK
     */
    @PostMapping("/delete")
    public ResponseEntity<?> deleteExport(@RequestBody Map<String, Integer[]> ids){
        iExportService.delete(ids.get("id"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by : HoaL
     * Date create : 08/09/2022
     * Function : create item in Export
     * return exportDto
     */

    @PostMapping("/create")
    private ResponseEntity<?> create(@Validated @RequestBody vn.codegym.pig_farm.dto.ExportDto exportDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
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
    public ResponseEntity<Export> update(@Validated @PathVariable int id, @RequestBody Export export, BindingResult bindingResult) {
        Export export1 = iExportService.findById(id);
        if (export1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        export1.setPigsty(export.getPigsty());
        export1.setEmployee(export.getEmployee());
        export1.setCodeExport(export.getCodeExport());
        export1.setCompany(export.getCompany());
        export1.setPrice(export.getPrice());
        export1.setTypePigs(export.getTypePigs());
        export1.setAmount(export.getAmount());
        export1.setKilogram(export.getKilogram());
        iExportService.update(export1);
        return new ResponseEntity<>(export1, HttpStatus.OK);
    }
    @Autowired
    private ExportRepository exportRepository;
    @GetMapping("/totalWeightCount/{id}")
    private ResponseEntity<Object[]> totalWeightCount(@PathVariable("id") Integer id) {
        Object[] temp = {(exportRepository.countPigOnPigsty(id)),exportRepository.totalWeight(id)};
       return new ResponseEntity<>(temp,HttpStatus.OK);
    }

}
