package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.dto.projections.NotificationDto;
import vn.codegym.pig_farm.entity.Notification;
import java.util.Optional;

public interface INotificationService {

    /**
     * Created by: DatLT
     * Date created: 08/09/2022
     * Function: Display all news list by keyword with pagination
     * @param pageable pageable
     * @param keyword keyword
     * @return Page<Notification>
     */

    Page<Notification> findAll(Pageable pageable, @Param("keyword") String keyword);


    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Display :Interface  Notification
     *
     * @param content
     * @param pageable
     * @return
     */
    Page<NotificationDto> findAllNotification(Pageable pageable, String content);

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Find by id :Interface Notification
     *
     * @param id
     * @return
     */
    Optional<Notification> findById(Integer id);

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Delete :Interface Notification
     *
     * @param ids
     */
    void delete(Integer[] ids);

    void save(Notification notification);

    void update(Notification notification);
}
