package vn.codegym.pig_farm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.PigDto;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.service.IPigService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pig")
@CrossOrigin
public class PigRestController {

    @Autowired
    private IPigService pigService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/list")
    public ResponseEntity<List<Pig>> findAll() {
        if (pigService.findAll().isEmpty()) {
            return new ResponseEntity<>(pigService.findAll(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pigService.findAll(), HttpStatus.OK);
    }

    /**
     * Create by: DatVT
     * Date Create: 08/09/2022
     * function: Create item in pig
     *
     * @param pigDto
     */
    @PostMapping("/create")
    public ResponseEntity<?> createPig(@RequestBody @Valid PigDto pigDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }else {
            Pig pig = new Pig();
            BeanUtils.copyProperties(pigDto, pig);
            pigService.createPig(pig);
            return new ResponseEntity<>(pig, HttpStatus.CREATED);
        }
    }

    /**
     * Create by: DatVT
     * Date Create: 08/09/2022
     * function: Update item in pig
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePig(@PathVariable("id") Integer id,
                                       @RequestBody @Valid PigDto pigDTO) {
        Pig pig = modelMapper.map(pigDTO, Pig.class);
        pigService.updatePig(id, pig);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//        Pig pig1 = pigService.findById(id);
//        if (pig1 == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } else {
//            pigService.updatePig(pig);
//            return new ResponseEntity<>(pig1, HttpStatus.OK);
//        }

    /**
     * @param pageable
     * @param codeSearch
     * @param dateInSearch
     * @param statusSearch
     * @return pig, status 200
     * @function (display all Pig and search)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @GetMapping("/page")
    public ResponseEntity<Page<Pig>> listAll(@PageableDefault(5) Pageable pageable,
                                             @RequestParam Optional<String> codeSearch,
                                             @RequestParam Optional<String> dateInSearch,
                                             @RequestParam Optional<String> statusSearch) {
        {
            String code = codeSearch.orElse("");
            String dateIn = dateInSearch.orElse("");
            String status = statusSearch.orElse("");
            if (code.equals("null")) {
                code = "";
            }
            if (dateIn.equals("null")) {
                dateIn = "";
            }
            if (status.equals("null")) {
                status = "";
            }
            Page<Pig> pigs = pigService.findAllPig(pageable, code, dateIn, status);
            if (pigs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pigs, HttpStatus.OK);
        }
    }

    /**
     * @param id
     * @return
     * @function (delete Pig by Id)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<Pig> pig = pigService.findById(id);
        if (!pig.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pigService.deletePigById(pig.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
