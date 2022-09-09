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

import java.util.Map;
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
                                                        Optional<String> nameSearch,
                                                        Optional<String> contentSearch) {
        String name = nameSearch.orElse("");
        String content = contentSearch.orElse("");
        if (name.equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        if (content.equals("null")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<Contact> contactPage = contactService.getAll(pageable,name,content);
        if (contactPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    /**
     * Create by : TriPT
     * Date created: 08/09/2022
     * function: delete Contact
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Integer id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
