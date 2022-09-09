package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.dto.INotificationDto;
import vn.codegym.pig_farm.entity.Notification;

public interface NotificationService {
    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Display :Interface  Notification
     * @param content
     * @param pageable
     * @return
     */
    Page<INotificationDto> findAll(String content, Pageable pageable);

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Find by id :Interface Notification
     * @param id
     * @return
     */
    Notification findById(Integer id);

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Delete :Interface Notification
     * @param ids
     */
    void delete(Integer[] ids);
}
