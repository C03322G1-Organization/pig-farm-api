package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Storage;
import vn.codegym.pig_farm.service.StorageService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/storage")
public class StorageRestController {

    @Autowired
    StorageService storageService;

//    @GetMapping("/list")
//    public ResponseEntity<List<Storage>> getStorageList() {
//        Page<Storage> storageList = storageService.findAll();
//        if (storageList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(storageList, HttpStatus.OK);
//    }
    @GetMapping("/list")
    public ResponseEntity<Page<Storage>> showAll(@PageableDefault(5) Pageable pageable,
                                             @RequestParam Optional<String> keyWord) {
        {
    //        String code = codeSearch.orElse("");
    //        if (code.equals("null")) {
    //            code = "";
    //        }
            Page<Storage> pigs = storageService.findAll(pageable, String.valueOf(keyWord));
            if (pigs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pigs, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity <Storage> createStorage(@RequestBody Storage storage) {
        storageService.save(storage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
