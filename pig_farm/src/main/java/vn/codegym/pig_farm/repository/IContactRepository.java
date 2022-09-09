package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Contact;

public interface IContactRepository extends JpaRepository<Contact,Integer> {
    @Query(value = "insert into contact (name,email,phone,address,content) value (:name,:email,:phone,:address,:content)",nativeQuery = true)
    Contact save(@Param("name") String name,@Param("email") String email,@Param("phone") String phone,@Param("address") String address,@Param("content") String content);
}
