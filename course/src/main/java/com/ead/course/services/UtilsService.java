package com.ead.course.services;

import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface UtilsService {
    String createUrlGetAllUsersByCourse(UUID courseId, Pageable pageable);

    String createUrlOneUserById(UUID userId);

    String createUrlSubscription(UUID userId);

    String createUrlDeleteCourseInAuthUser(UUID courseId);
}


