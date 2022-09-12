package vn.codegym.pig_farm.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Contact;

public interface IContactService {
    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: Delete Contact
     */
    void deleteContact(int id);

    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: get all Contact Pageable
     */
    Page<Contact> getAll(Pageable pageable, String name, String content);

    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: find by id contact
     */
    Contact findByIdContact(int id);


    /**
     * Create by PhucND
     * Date Create: 08/09/2022
     * This save
     */
    Contact save(Contact contact);

}
