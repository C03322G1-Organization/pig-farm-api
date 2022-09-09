package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.Contact;

/**
 * Create by PhucND
 * Date Create: 08/09/2022
 * This save
 */
public interface IContactRepository extends JpaRepository<Contact,Integer> {
    @Query(value = "insert into contact (name,email,phone,address,content) value (:name,:email,:phone,:address,:content)",nativeQuery = true)
    Contact save(@Param("name") String name,@Param("email") String email,@Param("phone") String phone,@Param("address") String address,@Param("content") String content);
}
