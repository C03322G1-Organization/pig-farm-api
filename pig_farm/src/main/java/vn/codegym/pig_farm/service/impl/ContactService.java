package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Contact;
import vn.codegym.pig_farm.repository.IContactRepository;
import vn.codegym.pig_farm.service.IContactService;
@Service
public class ContactService implements IContactService {
    @Autowired
    private IContactRepository iContactRepository;
    /**
     * Create by PhucND
     * Date Create: 08/09/2022
     * This save
     */
    @Override
    public Contact save(Contact contact) {
        return iContactRepository.save(contact.getName(), contact.getEmail(), contact.getPhone(), contact.getAddress(), contact.getContent());
    }
}
