package vn.codegym.pig_farm.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Notification;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Write query fìndById
     * @param id
     */

    @Query(value = "select * from notification where id = :id", nativeQuery = true)
    Optional<Notification> findById(@Param("id") Integer id);

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Write query create notification
     * @param id
     * @param content
     * @param submitted_date
     * @param image
     */

    @Transactional
    @Modifying
    @Query(value = "insert into notification(id, content, submitted_date, image) " +
            " values (:id, :content, :submitted_date, :image);", nativeQuery = true)
    void save(@Param("id") Integer id, @Param("content") String content,
              @Param("submitted_date") LocalDate submitted_date, @Param("image") String image);

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Write query edit notification
     * @param content
     * @param submittedDate
     * @param image
     * @param isDeleted
     * @param id
     */

    @Transactional
    @Modifying
    @Query(value = "update notification set content = :content, submitted_date = :submittedDate, " +
            " image = :image, is_deleted = :isDeleted where id = :id", nativeQuery = true)
    void update(@Param("content") String content, @Param("submittedDate") LocalDate submittedDate,
                @Param("image") String image, @Param("isDeleted") Boolean isDeleted, @Param("id") Integer id);


    /**
     * Created by: DatLT
     * Date created: 08/09/2022
     * Function: Display all news list by keyword with pagination
     *
     * @param pageable pageable
     * @param keyword  keyword
     * @return Page<Notification> notifications
     */
    @Query(value = "select * from notification where title like %:keyword% and content like %:keyword% and is_deleted = 0", nativeQuery = true)
    Page<Notification> findAll(Pageable pageable, @Param("keyword") String keyword);
}
