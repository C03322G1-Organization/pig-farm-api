package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Contact;
import vn.codegym.pig_farm.service.IContactService;

import java.util.Optional;

@RestController
@RequestMapping("/contact")
@CrossOrigin()
public class ContactController {
    @Autowired
    private IContactService contactService;
    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: findAll Contact
     */
    @CrossOrigin()
    @GetMapping("/page")
    public ResponseEntity<Page<Contact>> findAllContact(@PageableDefault(value = 5) Pageable pageable,
                                                        Optional<String> keySearch1,
                                                        Optional<String> keySearch2) {
        String name = keySearch1.orElse("");
        String content = keySearch2.orElse("");
        if (name.equals("null")) {
            name = "";
        }
        if (content.equals("null")) {
            content = "";
        }
        Page<Contact> contactPage = contactService.getAll(pageable,name,content);
        if (contactPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contactPage,HttpStatus.OK);
    }

    /**
     * Create by : TriPT
     * Date created: 08/09/2022
     * function: find by id contact
     */
    @GetMapping("/{id}")
    public ResponseEntity<Contact> findById(@PathVariable Integer id) {
        Contact contact = contactService.findByIdContact(id);
        if (contact == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}
