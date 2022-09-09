package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
//    List<Notification> findAll();

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Create method findById
     * @param id
     * @return findById(Integer id)
     */
    Optional<Notification> findById(Integer id);

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Create method save
     * @param notification
     * @return save(Notification notification)
     */

    void save(Notification notification, Pageable pageable);

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Create method update
     * @param notification
     * @return save(Notification notification)
     */

    void update(Notification notification, Pageable pageable);
}
