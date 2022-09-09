package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Contact;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IContactRepository extends JpaRepository<Contact, Integer> {

    /*
     *Create by TriPT
     *Date create: 08/09/2022
     *function: Delete Contact
     */
    @Modifying
    @Query(value = "update contact set is_deleted = 1 where id = :id", nativeQuery = true)
    void deleteContact(@Param("id") Integer id);


    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: find all Contact by name and content
     */
    @Query(value = "select id, `name`, email, phone, address, content,`date`, is_deleted from contact where is_deleted = 0 and `name` like :nameSearch and content like :contentSearch", nativeQuery = true)
    Page<Contact> findAll(Pageable pageable, @Param("nameSearch") String nameSearch, @Param("contentSearch") String contentSearch);


    /**
     * Create by TriPT
     * Date create: 08/09/2022
     * function: find by id
     */
    @Query(value = "select id, `name`, email, phone, address, content,`date`, is_deleted from contact where id =:id", nativeQuery = true)
    Contact findByIdContact(@Param("id") Integer id);
}
