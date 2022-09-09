package vn.codegym.pig_farm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.PigDTO;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.service.IPigService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/pig")
public class PigController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IPigService pigService;

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
     * @param pigDTO
     */
    @PostMapping("/create")
    public ResponseEntity<?> createPig(@RequestBody @Valid PigDTO pigDTO, BindingResult bindingResult) {
        new PigDTO().validate(pigDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }else {
            Pig pig = new Pig();
            BeanUtils.copyProperties(pigDTO, pig);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            pig.setDateIn(LocalDate.parse(pigDTO.getDateIn(), formatter));
            pig.setDateOut(LocalDate.parse(pigDTO.getDateOut(), formatter));
            pigService.createPig(pig);
            return new ResponseEntity<>(pig, HttpStatus.CREATED);
        }
//        if (pig == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }else{
//            pigService.createPig(pig);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
    }

    /**
     * Create by: DatVT
     * Date Create: 08/09/2022
     * function: Update item in pig
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePig(@PathVariable("id") Integer id,
                                       @RequestBody @Valid PigDTO pigDTO) {
        Pig pig = modelMapper.map(pigDTO, Pig.class);
        pigService.updatePig(id, pig);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
//        Pig pig1 = pigService.findById(id);
//        if (pig1 == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } else {
//            pigService.updatePig(pig);
//            return new ResponseEntity<>(pig1, HttpStatus.OK);
//        }
