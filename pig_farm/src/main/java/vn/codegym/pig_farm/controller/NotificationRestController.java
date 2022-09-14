package vn.codegym.pig_farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.projections.NotificationDto;
import vn.codegym.pig_farm.service.INotificationService;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/notification")
public class NotificationRestController {
    @Autowired
    private INotificationService notificationService;

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Display : Notification
     *
     * @param content
     * @param pageable
     * @return HttpStatus: Http 200 OK
     * @return HttpStatus: Http 400 NO_CONTENT
     */
    @GetMapping("/page")
    private ResponseEntity<Page<NotificationDto>> findAllNotification(@PageableDefault(5) Pageable pageable,
                                                                      Optional<String> content
            ) {
        String searchContent = content.orElse("");
        if (searchContent.equals("null")) {
            searchContent = "";
        }
        Page<NotificationDto> notifications = notificationService.findAllNotification( pageable,searchContent);
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }


    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Delete : Notification
     *
     * @param ids
     * @return HttpStatus: Http 200 OK
     */
    @PostMapping("/delete")
    private ResponseEntity<?> delete(@RequestBody Map<String, Integer[]> ids) {
        notificationService.delete(ids.get("id"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
