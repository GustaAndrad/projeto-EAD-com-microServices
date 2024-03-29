package com.ead.course.services.impl;

import com.ead.course.services.UtilsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilsServiceImpl implements UtilsService {

    @Value("${ead.api.url.authuser}")
    String REQUEST_URI_AUTHUSER;

    public String createUrlGetAllUsersByCourse(UUID courseId, Pageable pageable) {
        return REQUEST_URI_AUTHUSER + "/users?courseId=" + courseId
                + "&page=" + pageable.getPageNumber()
                + "&size=" + pageable.getPageSize()
                + "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");
    }

    public String createUrlOneUserById(UUID userId) {
        return REQUEST_URI_AUTHUSER + "/users/" + userId;
    }

    @Override
    public String createUrlSubscription(UUID userId) {
        return REQUEST_URI_AUTHUSER + "/users/" + userId + "/courses/subscription";
    }

    @Override
    public String createUrlDeleteCourseInAuthUser(UUID courseId) {
        return REQUEST_URI_AUTHUSER + "/users/courses/" + courseId;
    }


}
