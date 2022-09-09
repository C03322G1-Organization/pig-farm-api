package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Notification;
import vn.codegym.pig_farm.service.NotificationService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

//    @GetMapping
//    public ResponseEntity<List<Notification>> getAll() {
//        return new ResponseEntity<>(notificationService.findAll(), HttpStatus.OK);
//    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Add new notification
     * @param notification
     * @return HttpStatus: Http 200 OK, ResponseEntity()
     */
    @PostMapping
    public ResponseEntity<Notification> create(@RequestBody Notification notification, Pageable pageable) {
        notificationService.save(notification, pageable);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Find By Id
     * @param id
     * @return  HttpStatus: Http 200 OK, ResponseEntity<>(notification.get()),
     *          HttpStatus: Http 404 NOT_FOUND, ResponseEntity is enity
     */

    @GetMapping("/{id}")
    public ResponseEntity<Notification> findById(@PathVariable Integer id) {
        Optional<Notification> notification = notificationService.findById(id);
        if (!notificationService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notification.get(), HttpStatus.OK);
    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Edit notification
     * @param id
     * @param notification
     * @return HttpStatus: Http 200 OK : ResponseEntity<>(notifications1)
     *         HttpStatus: Http 404 NOT_FOUND : ResponseEntity is enity
     */

    @PutMapping("/{id}")
    public ResponseEntity<Notification> update(@PathVariable Integer id,
                                               @RequestBody Notification notification,
                                               Pageable pageable) {
        Notification notifications1 = notificationService.findById(id).get();
        if (notifications1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        notifications1.setId(notification.getId());
        notifications1.setContent(notification.getContent());
        notifications1.setImage(notification.getImage());

        notificationService.update(notifications1, pageable);
        return new ResponseEntity<>(notifications1, HttpStatus.OK);
    }
}
