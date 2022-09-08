package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Employee;

import javax.transaction.Transactional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {


    /**
     * @param name
     * @param idCard
     * @param pageable
     * @return Page employee
     * @Creator HungNQ
     * @Date 08/09/2022
     */
    @Query(value = "select e.`name`, e.user_id, e.birth_day, e.`code`, e.gender, e.id_card, e.image, " +
            "e.is_deleted, e.id from employee e " +
            "join `user` on e.user_id = `user`.id " +
            "join user_role on user_role.user_id = `user`.id " +
            "join `role` on `role`.id = user_role.role_id " +
            "where e.is_deleted = 0 " +
            "and e.name like  " +
            "concat('%', :name ,'%') and e.id_card like concat('%',:idCard,'%')", nativeQuery = true,
            countQuery = "select count(*) from (select e.`name`, e.user_id, e.birth_day, e.`code`, e.gender, e.id_card, e.image, " +
                    "e.is_deleted, e.id from employee e join `user` on e.user_id = `user`.id " +
                    "join user_role on user_role.user_id = `user`.id  " +
                    "join `role` on `role`.id = user_role.role_id " +
                    "where e.is_deleted = 0 " +
                    "and e.name like  " +
                    "concat('%', :name ,'%') and e.id_card like concat('%',:idCard,'%')) abc")
    Page<Employee> getAllEmployeePaginationAndSearch(@Param("name") String name, @Param("idCard") String idCard,
                                                     Pageable pageable);

    /**
     * @param id function deleteEmployee
     * @Creator HungNQ
     * @Date 08/09/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update employee set is_deleted = 1 where id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") int id);

}
