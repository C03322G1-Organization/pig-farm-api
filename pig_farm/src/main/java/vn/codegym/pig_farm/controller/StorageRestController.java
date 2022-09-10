package vn.codegym.pig_farm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.StorageDto;
import vn.codegym.pig_farm.dto.StorageListDto;
import vn.codegym.pig_farm.entity.Storage;
import vn.codegym.pig_farm.service.IStorageService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/storage")
public class StorageRestController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IStorageService storageService;

    /**
     * Create by: HoangDT
     * Date Create: 08/09/2022
     * funtion: findAll storage
     */

    @GetMapping("/page")
    public ResponseEntity<Page<StorageListDto>> showAll(@PageableDefault(5) Pageable pageable,
                                                 Optional<String> keyWord) {
        {
            String foodType = keyWord.orElse("");
            if (foodType.equals("null")) {
                foodType = "";
            }
            Page<StorageListDto> storagePage = storageService.findAll(pageable, foodType);
            if (storagePage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(storagePage, HttpStatus.OK);
        }
    }

    /**
     * Create by: HoangDT
     * Date Create: 08/09/2022
     * funtion: create storage
     */

    @PostMapping("/create")
    public ResponseEntity <Storage> createStorage(@RequestBody @Valid StorageDto storageDto) {
        Storage storage = modelMapper.map(storageDto, Storage.class);
        storageService.save(storage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
