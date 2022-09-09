package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.projection.IEmployeeProjection;


import javax.transaction.Transactional;
import java.util.List;

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
    @Query(value = "select e.`name` as nameEmployee, e.user_id as userId, e.birth_day as birthDay, e.`code`, e.gender, e.id_card as idCard, e.image, " +
            "e.is_deleted as deleted, e.id, `user`.username , `role`.role_name as roleName from employee e " +
            "join `user` on e.user_id = `user`.id " +
            "join user_role on user_role.user_id = `user`.id " +
            "join `role` on `role`.id = user_role.role_id " +
            "where e.is_deleted = 0 " +
            "and e.name like  " +
            "concat('%', :name ,'%') and e.id_card like concat('%',:idCard,'%')", nativeQuery = true,
            countQuery = "select count(*) from (select e.`name` as nameEmployee , e.user_id as userId, e.birth_day as birthDay, e.`code`, e.gender, e.id_card as idCard, e.image, " +
                    "e.is_deleted as deleted, e.id, `user`.username,`role`.role_name as roleName from employee e " +
                    "join `user` on e.user_id = `user`.id " +
                    "join user_role on user_role.user_id = `user`.id  " +
                    "join `role` on `role`.id = user_role.role_id " +
                    "where e.is_deleted = 0 " +
                    "and e.name like  " +
                    "concat('%', :name ,'%') and e.id_card like concat('%',:idCard,'%')) abc")
    Page<IEmployeeProjection> getAllEmployeePaginationAndSearch(@Param("name") String name, @Param("idCard") String idCard,
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

    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @return List employee
     */
    @Query(value = "select id,birth_day,code,gender,id_card,image,is_deleted,name,user_id from employee",nativeQuery = true)
    List<Employee> getAllEmployee();

}
