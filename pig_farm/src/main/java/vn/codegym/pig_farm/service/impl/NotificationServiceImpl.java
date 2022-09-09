package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Notification;
import vn.codegym.pig_farm.repository.NotificationRepository;
import vn.codegym.pig_farm.service.NotificationService;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

//    @Override
//    public List<Notification> findAll() {
//        return notificationRepository.findAll();
//    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Override method findById
     * @param id
     * @return notificationRepository.findById(id)
     */
    @Override
    public Optional<Notification> findById(Integer id) {
        return notificationRepository.findById(id);
    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Override method save
     * @param notification
     */

    @Override
    public void save(Notification notification) {
        notificationRepository.save(notification.getId(), notification.getContent(), notification.getSubmittedDate(),
                notification.getImage());
    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Override method update
     * @param notification
     */

    @Override
    public void update(Notification notification) {
        notificationRepository.update(notification.getContent(), notification.getSubmittedDate(),
                notification.getImage(), notification.getIsDeleted(), notification.getId());
    }
}
