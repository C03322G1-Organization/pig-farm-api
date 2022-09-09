package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Advertisement;
import vn.codegym.pig_farm.projection.IAdvertisementProjection;
import vn.codegym.pig_farm.service.IAdvertisementService;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/advertisement")
public class AdvertisementController {
    @Autowired
    IAdvertisementService advertisementService;

    /**
     * @param pageable
     * @param keySearch return List Advertisement, status 200
     * @function (Query to display all Advertisement and search)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    @GetMapping("/page")
    public ResponseEntity<Page<IAdvertisementProjection>> findAllAdvertisement(@PageableDefault(value = 5) Pageable pageable,
                                                                               Optional<String> keySearch) {
        String title = keySearch.orElse("");
        if (title.equals("null")) {
            title = "";
        }
        Page<IAdvertisementProjection> advertisementPage = advertisementService.findAllAdvertisement(pageable, title);
        if (advertisementPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(advertisementPage, HttpStatus.OK);
    }

    /**
     * @param id return status 200
     * @function (Query to delete Advertisement)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    @PutMapping("/delete/{id}")
    private ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<Advertisement> advertisement = advertisementService.findById(id);
        if (advertisement.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        advertisementService.deleteAdvertisement(advertisement.get().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
