package vn.codegym.pig_farm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.NotificationDto;
import vn.codegym.pig_farm.entity.Notification;
import vn.codegym.pig_farm.service.NotificationService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Create notification
     *
     * @param notificationDto
     * @param bindingResult
     * @return HttpStatus: Http 200 OK, ResponseEntity<>(),
     * * HttpStatus: Http 404 NOT_FOUND, ResponseEntity is enity
     */

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> create(@RequestBody @Valid NotificationDto notificationDto,
                                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        Notification notification = new Notification();
        BeanUtils.copyProperties(notificationDto, notification);

        this.notificationService.save(notification);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Find By Id
     *
     * @param id
     * @return HttpStatus: Http 200 OK, ResponseEntity<>(notification.get()),
     *         HttpStatus: Http 404 NOT_FOUND, ResponseEntity is enity
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
     *
     * @param id
     * @param notificationDto
     * @param bindingResult
     * @return HttpStatus.NOT_MODIFIED: Http 300, errors
     *         HttpStatus.NO_CONTENT: Http 404, ResponseEntity is enity
     *         HttpStatus.OK: Http 200, ResponseEntity(currentNotification.get())
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<Notification> update(@PathVariable Integer id, @Valid @RequestBody NotificationDto notificationDto,
                                               BindingResult bindingResult) {
        Optional<Notification> currentNotification = notificationService.findById(id);

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

        if (!currentNotification.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentNotification.get().setId(notificationDto.getId());
        currentNotification.get().setContent(notificationDto.getContent());
        currentNotification.get().setImage(notificationDto.getImage());

        notificationService.update(currentNotification.get());

        return new ResponseEntity(currentNotification.get(), HttpStatus.OK);
    }
}

