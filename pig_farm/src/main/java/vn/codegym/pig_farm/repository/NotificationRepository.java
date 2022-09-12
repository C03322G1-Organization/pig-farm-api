package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.dto.NotificationProjection;
import vn.codegym.pig_farm.entity.Notification;

import javax.transaction.Transactional;

@Transactional
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Display : Notification
     *
     * @param content
     * @param pageable
     * @return
     */
    @Query(value = " select id , content, title , submitted_date as submittedDate , image  " +
            " from notification " +
            " where content " +
            "like :content " +
            "and is_deleted =0",
            nativeQuery = true,
            countQuery = "select count(*) from (select id , content, title , submitted_date as submittedDate , image  " +
                    " from notification " +
                    " where content " +
                    "like :content " +
                    "and is_deleted =0) as abc")
    Page<NotificationProjection> findAllNotification(Pageable pageable, @Param("content") String content);

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Delete : Notification
     *
     * @param id
     */

    @Modifying
    @Query(value = "update notification set is_deleted =1 where id =:id", nativeQuery = true)
    void delete(@Param("id") Integer id);

}
