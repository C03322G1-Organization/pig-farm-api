package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.service.IPigService;

import java.util.List;

@RestController
@RequestMapping("/pig")
public class PigController {
    @Autowired
    private IPigService pigService;

    @GetMapping("/list")
    public ResponseEntity<List<Pig>> findAll(){
        if(pigService.findAll().isEmpty()){
            return new ResponseEntity<>(pigService.findAll(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pigService.findAll(), HttpStatus.OK);
    }
    /**
     * Create by: DatVT
     * Date Create: 08/09/2022
     * funtion: Create item in pig
     */
    @PostMapping("/create")
    public ResponseEntity<?> createPig(@RequestBody Pig pig) {
        if (pig == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            pigService.createPig(pig);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    /**
     * Create by: DatVT
     * Date Create: 08/09/2022
     * funtion: Update item in pig
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePig(@PathVariable("id") Integer id,
                                       @RequestBody Pig pig) {
        Pig pig1 = pigService.findById(id);
        if (pig1 == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            pigService.updatePig(pig);
            return new ResponseEntity<>(pig1,HttpStatus.OK);
        }
    }
}
