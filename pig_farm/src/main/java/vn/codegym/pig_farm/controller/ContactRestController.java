package vn.codegym.pig_farm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.pig_farm.dto.ContactDto;
import vn.codegym.pig_farm.entity.Contact;
import vn.codegym.pig_farm.service.IContactService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/contact")
public class ContactRestController {
    @Autowired
    private IContactService iContactService;

    /**
     * Create by PhucND
     * Date Create: 08/09/2022
     * This save
     *
     * Param contactDto
     */
    @PostMapping("/create")
    public ResponseEntity<?> save(@Valid @RequestBody ContactDto contactDto, BindingResult bindingResult) {
        new ContactDto().validate(contactDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        } else {
            Contact contact = new Contact();
            BeanUtils.copyProperties(contactDto, contact);
            iContactService.save(contact);
            return new ResponseEntity<>(contact, HttpStatus.CREATED);
        }
    }
}
