package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.INotificationDto;
import vn.codegym.pig_farm.entity.Notification;
import vn.codegym.pig_farm.repository.NotificationRepository;
import vn.codegym.pig_farm.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
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
    public Page<INotificationDto> findAll(String content, Pageable pageable) {
        return notificationRepository.findAllNotification("%" + content + "%", pageable);

    }

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Find by id : Notification
     *
     * @param id
     * @return
     */
    @Override
    public Notification findById(Integer id) {
        return notificationRepository.findById(id).orElse(null);
    }

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
}
