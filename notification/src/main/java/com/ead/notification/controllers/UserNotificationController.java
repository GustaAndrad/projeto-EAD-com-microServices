package com.ead.notification.controllers;

import com.ead.notification.dtos.NotificationDto;
import com.ead.notification.models.NotificationModel;
import com.ead.notification.services.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserNotificationController {

    final NotificationService notificationService;

    public UserNotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PreAuthorize("hasAnyRole('STUDENT')")
    @GetMapping("/users/{userId}/notifications")
    public ResponseEntity<Page<NotificationModel>> getAllNotificationsByUser(@PathVariable(value = "userId")UUID userId,
                                                                             @PageableDefault(sort = "notificationId", direction = Sort.Direction.ASC)
                                                                             Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(notificationService.findAllNotificationByUser(userId, pageable));
    }

    @PreAuthorize("hasAnyRole=('STUDENT')")
    @PatchMapping("/users/{userId}/notifications/{notificationId}")
    public ResponseEntity<Object> updateNotification(@PathVariable(value = "userId") UUID userId,
                                                      @PathVariable(value = "notificationId") UUID notificationId,
                                                      @RequestBody @Valid NotificationDto notificationDto){
        Optional<NotificationModel> notificationModelOptional = notificationService.findByNotificationIdAndUserId(notificationId, userId);

        if(notificationModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification not found!");
        }

        notificationModelOptional.get().setNotificationStatus(notificationDto.getNotificationStatus());
        notificationService.SaveNotification(notificationModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body(notificationModelOptional.get());
    }
}
