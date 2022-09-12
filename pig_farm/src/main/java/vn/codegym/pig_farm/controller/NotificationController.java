package vn.codegym.pig_farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.INotificationDto;
import vn.codegym.pig_farm.service.NotificationService;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    /**
     * Create by HaiTV
     * Date : 08/09/2022
     * Display : Notification
     *
     * @param content
     * @param pageable
     * @return HttpStatus: Http 200 OK
     */
    @GetMapping("")
    private ResponseEntity<Page<INotificationDto>> findAllNotification(
            @RequestParam Optional<String> content,
            @PageableDefault(5) Pageable pageable) {
        String searchContent = content.orElse("");
        if (searchContent.equals("null")) {
            searchContent = "";
        }
        return new ResponseEntity<Page<INotificationDto>>(notificationService.findAll(searchContent, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findAllNotification(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(notificationService.findById(id), HttpStatus.OK);
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
