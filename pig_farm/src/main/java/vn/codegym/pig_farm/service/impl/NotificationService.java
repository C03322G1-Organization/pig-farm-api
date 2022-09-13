package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.projection.INotificationDto;
import vn.codegym.pig_farm.entity.Notification;
import vn.codegym.pig_farm.repository.NotificationRepository;
import vn.codegym.pig_farm.service.INotificationService;

import java.util.Optional;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Display : Notification
     *
     * @param content
     * @param pageable
     * @return
     */
    @Override
    public Page<INotificationDto> findAll(Pageable pageable, String content) {
        return notificationRepository.findAllNotification(pageable, "%" + content + "%");
    }

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Find by id : Notification
     *
     * @param id
     * @return
     */
//    @Override
//    public Notification findById(Integer id) {
//        return notificationRepository.findById(id).orElse(null);
//    }

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Delete : Notification
     *
     * @param ids
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            notificationRepository.delete(id);
        }
    }

    @Override
    public Optional<Notification> findById(Integer id) {
        return notificationRepository.findById(id);
    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Override method save
     *
     * @param notification
     */

    @Override
    public void save(Notification notification) {
        notificationRepository.save(notification.getId(), notification.getContent(), notification.getTitle(), notification.getSubmittedDate(),
                notification.getImage());
    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Override method update
     *
     * @param notification
     */

    @Override
    public void update(Notification notification) {
        notificationRepository.update(notification.getContent(), notification.getTitle(), notification.getSubmittedDate(),
                notification.getImage(), notification.getIsDeleted(), notification.getId());
    }
}
